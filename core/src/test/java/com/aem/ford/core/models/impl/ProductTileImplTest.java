package com.aem.ford.core.models.impl;

import com.aem.ford.core.models.ProductTile;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link ProductTileImpl}.
 * Tests the ProductTile Sling Model for correct property mapping and empty state.
 * 
 * @author Manojkumar
 * @since 11/06/2025
 * @version 1.0
 */
@ExtendWith(AemContextExtension.class)
public class ProductTileImplTest {

    private final AemContext context = new AemContext();

    /**
     * Sets up the test context by registering the ProductTile model and loading test JSON content.
     */
    @BeforeEach
    void setUp() {
        context.addModelsForClasses(ProductTile.class);
        context.load().json("/product-tile/product-tile.json", "/content");
    }

    /**
     * Tests that the ProductTile model correctly adapts and returns expected product properties.
     */
    @Test
    void testProductTileModel() {
        context.currentResource("/content/Product-Page"); 
        ProductTile productTile = context.request().adaptTo(ProductTile.class);
        assertNotNull(productTile, "ProductTile should not be null");
        assertEquals("Ford Mustang", productTile.getProductName(), "Product name should match");
        assertEquals("$55,000", productTile.getPrice(), "Product price should match");
        assertEquals("Performance", productTile.getCategory(), "Product category should match");
        assertEquals("In Stock", productTile.getAvailability(), "Product availability should match");
        assertEquals("/content/dam/ford/mustang.jpg", productTile.getImage(), "Product image should match");
        assertEquals("A classic American muscle car with modern features.", productTile.getDescription(), "Product description should match");
        assertFalse(productTile.isEmpty(), "ProductTile should not be empty");
    }

    /**
     * Tests that the ProductTile model returns empty when resource has no product properties.
     */
    @Test
    void testEmptyProductTile() {
        // Point to an empty or non-existing resource
        context.currentResource("/content/empty");
        ProductTile productTile = context.request().adaptTo(ProductTile.class);
        assertNotNull(productTile, "ProductTile should not be null for empty resource");
        assertTrue(productTile.isEmpty(), "ProductTile should be empty for missing properties");

    }
}