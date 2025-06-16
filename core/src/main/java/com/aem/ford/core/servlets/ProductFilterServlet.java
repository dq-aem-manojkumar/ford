package com.aem.ford.core.servlets;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.*;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Product Filter SQL2 Servlet",
                "sling.servlet.methods=GET",
                "sling.servlet.paths=/bin/product-filter"
        })
public class ProductFilterServlet extends SlingAllMethodsServlet {

    private static final Logger LOG = LoggerFactory.getLogger(ProductFilterServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        String category = request.getParameter("category");
        String minPrice = request.getParameter("minPrice");
        String maxPrice = request.getParameter("maxPrice");
        String offsetParam = request.getParameter("offset");
        String limitParam = request.getParameter("limit");
        String availability = request.getParameter("availability");


        LOG.info("Received request with parameters - category: {}, minPrice: {}, maxPrice: {}, offset: {}, limit: {}",
                category, minPrice, maxPrice, offsetParam, limitParam);

        ResourceResolver resolver = request.getResourceResolver();
        Session session = resolver.adaptTo(Session.class);

        if (session == null) {
            LOG.error("Session is null. Cannot proceed.");
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Internal server error: Session unavailable\"}");
            return;
        }

        try {
            StringBuilder sql = new StringBuilder(
                    "SELECT * FROM [cq:PageContent] WHERE ISDESCENDANTNODE('/content/ford/us/en/products')");

            if (StringUtils.isNotBlank(category)) {
                sql.append(" AND [category] = '").append(category).append("'");
            }

            if (StringUtils.isNotBlank(minPrice)) {
                try {
                    Double.parseDouble(minPrice); // validate
                    sql.append(" AND [price] >= ").append(minPrice);
                } catch (NumberFormatException e) {
                    LOG.error("Invalid minPrice format: {}", minPrice, e);
                    response.setStatus(SlingHttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().write("{\"error\": \"Invalid minPrice format\"}");
                    return;
                }
            }

            if (StringUtils.isNotBlank(maxPrice)) {
                try {
                    Double.parseDouble(maxPrice); // validate
                    sql.append(" AND [price] <= ").append(maxPrice);
                } catch (NumberFormatException e) {
                    LOG.error("Invalid maxPrice format: {}", maxPrice, e);
                    response.setStatus(SlingHttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().write("{\"error\": \"Invalid maxPrice format\"}");
                    return;
                }
            }

            if (StringUtils.isNotBlank(availability)) {
                if ("true".equalsIgnoreCase(availability) || "false".equalsIgnoreCase(availability)) {
                    sql.append(" AND [availability] = ").append(availability.toLowerCase());
                } else {
                    LOG.error("Invalid availability format: {}", availability);
                    response.setStatus(SlingHttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().write("{\"error\": \"Invalid availability format (must be true or false)\"}");
                    return;
                }
            }


            sql.append(" AND NOT [jcr:path] = '/content/ford/us/en/products/jcr:content'");

            LOG.info("Final SQL2 Query: {}", sql);

            QueryManager queryManager = session.getWorkspace().getQueryManager();
            Query jcrQuery = queryManager.createQuery(sql.toString(), Query.JCR_SQL2);

            // Handle offset and limit from request
            long offset = 0;
            long limit = 1;

            try {
                if (StringUtils.isNotBlank(offsetParam)) {
                    offset = Long.parseLong(offsetParam);
                }
                if (StringUtils.isNotBlank(limitParam)) {
                    limit = Long.parseLong(limitParam);
                }
            } catch (NumberFormatException e) {
                LOG.warn("Invalid pagination parameters. Using default offset=0, limit=1", e);
            }

            jcrQuery.setOffset(offset);
            jcrQuery.setLimit(limit);

            QueryResult result = jcrQuery.execute();
            NodeIterator nodes = result.getNodes();
            JSONArray products = new JSONArray();

            while (nodes.hasNext()) {
                Node node = nodes.nextNode();
                JSONObject obj = new JSONObject();
                try {
                    obj.put("title", node.hasProperty("jcr:title") ? node.getProperty("jcr:title").getString() : "");
                    obj.put("productName", node.hasProperty("productName") ? node.getProperty("productName").getString() : "");
                    obj.put("price", node.hasProperty("price") ? node.getProperty("price").getDouble() : 0.0);
                    obj.put("availability", node.hasProperty("availability") && node.getProperty("availability").getBoolean());
                    obj.put("category", node.hasProperty("category") ? node.getProperty("category").getString() : "");
                    obj.put("path", node.getParent().getPath() + ".html");
                    obj.put("image", node.hasProperty("fileReference") ? node.getProperty("fileReference").getString() : "");
                    obj.put("productDescription", node.hasProperty("description") ? node.getProperty("description").getString() : "");
                    products.put(obj);
                    LOG.info("Added product: {}", obj.toString());
                } catch (Exception e) {
                    LOG.error("Error reading node: {}", node.getPath(), e);
                }
            }

            response.setContentType("application/json");
            response.getWriter().write(products.toString());
            LOG.info("Response sent with {} products.", products.length());

        } catch (Exception e) {
            LOG.error("Error executing SQL2 query", e);
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Error executing query\"}");
        }
    }
}
