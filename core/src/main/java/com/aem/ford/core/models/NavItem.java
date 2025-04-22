package com.aem.ford.core.models;

/**
 * The NavItem interface defines the structure for a navigation item.
 * It provides methods to retrieve the label and path for a navigation link.
 */
public interface NavItem {

    /**
     * Retrieves the label of the navigation item.
     *
     * @return the label as a String.
     */
    String getLabel();

    /**
     * Retrieves the path of the navigation item.
     *
     * @return the path as a String.
     */
    String getPath();
}