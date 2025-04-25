package com.aem.ford.core.models;

import java.util.List;

import com.aem.ford.core.models.impl.NavItemImpl;


public interface Navbar {

    
    String getImagePath();

   
    String getSearchPath();

    
    String getUserPath();

    
    String getGlobePath();

    
    List<NavItemImpl> getNavItems();
}
