package com.aem.ford.core.models.impl;

import com.aem.ford.core.models.Dto.Product;
import com.aem.ford.core.models.ProductListing;
import com.day.cq.wcm.api.Page;

import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.ford.core.models.ProductListing;
import com.day.cq.wcm.api.Page;


@Model(
        adaptables = Resource.class,
        adapters = ProductListing.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ProductListingImpl implements ProductListing {

    @ValueMapValue
    @Named("productPagePath")
    private String productPagePath;

    @Self
    private Resource currentResource;



    private List<Page> childPages = new ArrayList<>();

    private List<Product> productList = new ArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(ProductListingImpl.class);
    

    @PostConstruct
    public void init(){
        LOG.info("Initializing ListingModel for resource: {}", currentResource.getPath());
        ResourceResolver resourceResolver = currentResource.getResourceResolver();
        Resource parentResource = resourceResolver.getResource(productPagePath);
        if (parentResource != null) {
            LOG.info("Found parent resource at path: {}", productPagePath);
            for (Resource child : parentResource.getChildren()) {
                Page page = child.adaptTo(Page.class);
                if (page != null) {
                    childPages.add(page);
                    Resource contentResource = page.getContentResource();
                    ValueMap valueMap = contentResource.getValueMap();
                    Product p1 = new Product();
                    p1.setProductName(valueMap.get("productName",""));
                    p1.setProductCategory(valueMap.get("category",""));
                    p1.setPrice(valueMap.get("price",0));
                    boolean flag ="true".equals(valueMap.get("availability", "false"));
                    LOG.info("Product availability flag: {}", flag);
                    p1.setInStock(valueMap.get("availability",false));
                    LOG.info("Product in stock: {}", p1.isInStock());
                    p1.setProductDescription(valueMap.get("description",""));
                    p1.setProductImagePath(valueMap.get("fileReference",""));
                    LOG.info("valiue map value", valueMap.get("availability",false));
                    productList.add(p1);

                    LOG.info("Added Product : {}", p1);
                    LOG.info("Added child page: {}", child.getPath());
                }
            }
            LOG.info("Total child pages found: {}", childPages.size());
        } else {
            LOG.info("Parent resource not found at path: {}", productPagePath);
        }
    }

    @Override
    public List<Page> getChildPages() {
        return childPages != null ? childPages : Collections.emptyList();
    }

    @Override
    public List<Product> getProducts() {
        LOG.info("Returning all products. Total: {}", productList != null ? productList.size() : 0);
        return productList;
    }

    @Override
    public List<Product> getInStockProducts() {
        if (productList == null) {
            LOG.info("Product list is null. Returning empty list for in-stock products.");
            return Collections.emptyList();
        }
        List<Product> inStock = productList.stream().filter(Product::isInStock).collect(Collectors.toList());
        LOG.info("Returning in-stock products. Total: {}", inStock.size());
        return inStock;
    }


}







