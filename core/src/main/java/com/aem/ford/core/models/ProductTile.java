package com.aem.ford.core.models;

/**
 * ProductTile interface defines the contract for accessing product details
 * such as name, price, category, availability, image, and description.
 * Implementations should provide logic to retrieve these properties.
 * 
 * @author Manojkumar
 * @since 11/06/2025
 * @version 1.0
 */
public interface ProductTile {

    /**
     * Gets the product name.
     * @return the product name as a String
     */
    String getProductName();

    /**
     * Gets the product price.
     * @return the product price as a String
     */
    String getPrice();

    /**
     * Gets the product category.
     * @return the product category as a String
     */
    String getCategory();

    /**
     * Gets the product availability status.
     * @return the product availability as a String
     */
    String getAvailability();

    /**
     * Gets the product image file reference.
     * @return the image file reference as a String
     */
    String getImage();

    /**
     * Gets the product description.
     * @return the product description as a String
     */
    String getDescription();

    /**
     * Checks if all product properties are empty or null.
     * @return true if all properties are empty or null, false otherwise
     */
    boolean isEmpty();

}