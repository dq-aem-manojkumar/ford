package com.aem.ford.core.models.impl;

import com.aem.ford.core.models.ProductTile;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

/**
 * Implementation of the ProductTile Sling Model.
 * <p>
 * This model adapts from {@link SlingHttpServletRequest} and provides product
 * details
 * such as name, price, category, availability, image, and description by
 * reading from
 * the current page's content resource.
 * 
 * @author ManojKumar
 * @since 11/06/2025
 * @version 1.0
 */
@Model(adaptables = SlingHttpServletRequest.class, adapters = ProductTile.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProductTileImpl implements ProductTile {

    private static final Logger LOG = LoggerFactory.getLogger(ProductTileImpl.class);

    @Self
    private SlingHttpServletRequest request;
    
    private String productName;
    private String price;
    private String category;
    private String availability;
    private String image;
    private String description;

    /**
     * Initializes the model by extracting product properties from the current
     * page's content resource.
     */
    @PostConstruct
    protected void init() {
        LOG.info("Product_Tile: Initializing ProductTileImpl model");
        PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
        if (pageManager != null) {
            LOG.info("Product_Tile: PageManager found");
            Page currentPage = pageManager.getContainingPage(request.getResource());
            if (currentPage != null && currentPage.getContentResource() != null) {
                LOG.info("Product_Tile: Current page and content resource found: {}", currentPage.getPath());
                Resource content = currentPage.getContentResource();
                // Retrieve product properties from the content resource's value map
                productName = content.getValueMap().get("productName", "");
                price = content.getValueMap().get("price", "");
                category = content.getValueMap().get("category", "");
                availability = content.getValueMap().get("availability", "");
                LOG.info("Product_Tile: Loaded productName='{}', price='{}', category='{}', availability='{}'",
                        productName, price, category, availability);
                image = content.getValueMap().get("fileReference", "");
                description = content.getValueMap().get("description", "");
                LOG.info("Product_Tile: Loaded description='{}'", description);
            } else {
                LOG.info("Product_Tile: Current page or content resource is null");
            }
        } else {
            LOG.info("Product_Tile: PageManager is null");
        }
    }

    /**
     * @return the product name
     */
    @Override
    public String getProductName() {
        return productName;
    }

    /**
     * @return the product price
     */
    @Override
    public String getPrice() {
        return price;
    }

    /**
     * @return the product category
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * @return the product availability
     */
    @Override
    public String getAvailability() {
        return availability;
    }

    /**
     * @return the product image file reference
     */
    @Override
    public String getImage() {
        return image;
    }

    /**
     * @return the product description
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Checks if all product properties are empty.
     * 
     * @return true if all properties are empty or null, false otherwise
     */
    @Override
    public boolean isEmpty() {
        boolean empty = (productName == null || productName.trim().isEmpty()) &&
                (price == null || price.trim().isEmpty()) &&
                (category == null || category.trim().isEmpty()) &&
                (availability == null || availability.trim().isEmpty()) &&
                (image == null || image.trim().isEmpty()) &&
                (description == null || description.trim().isEmpty());
        LOG.info("Product_Tile: isEmpty evaluated to {}", empty);
        return empty;
    }

}