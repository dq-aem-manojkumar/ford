package com.aem.ford.core.models;

import java.util.List;

import com.aem.ford.core.models.impl.NavItemImpl;

/**
 * The Navbar interface defines the structure for the navigation bar model.
 * It provides methods to retrieve paths for various icons and a list of navigation items.
 */
public interface Navbar {

    /**
     * Retrieves the path to the logo image.
     *
     * @return the image path as a String.
     */
    String getImagePath();

    /**
     * Retrieves the path to the search icon.
     *
     * @return the search icon path as a String.
     */
    String getSearchPath();

    /**
     * Retrieves the path to the user icon.
     *
     * @return the user icon path as a String.
     */
    String getUserPath();

    /**
     * Retrieves the path to the globe icon.
     *
     * @return the globe icon path as a String.
     */
    String getGlobePath();

    /**
     * Retrieves the list of navigation items.
     *
     * @return a list of {@link NavItemImpl} objects representing the navigation items.
     */
    List<NavItemImpl> getNavItems();
}
