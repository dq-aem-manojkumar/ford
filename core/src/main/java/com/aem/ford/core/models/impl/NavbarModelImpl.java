package com.aem.ford.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.ford.core.models.Navbar;

import java.util.List;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    adapters = {Navbar.class},
    resourceType = {NavbarModelImpl.RESOURCE_TYPE},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavbarModelImpl implements Navbar {

    protected static final String RESOURCE_TYPE = "ford/components/content/navbar";


    @ChildResource(name = "navItems")
    private List<NavItemImpl> navItems;

    @ValueMapValue
    private String searchPath;

    @ValueMapValue
    private String userPath;

    @ValueMapValue
    private String globePath;

    @ValueMapValue
    private String imagePath;


    @Override
    public String getImagePath() {
        return imagePath !=null ? imagePath :"Default Image";
    }

    @Override
    public String getSearchPath() {
        return searchPath !=null ? searchPath :"Default Search Logo";
    }
    @Override
    public String getUserPath() {
        return userPath !=null ? userPath :"Default User Logo";
    }

    @Override
    public String getGlobePath() {
        return globePath !=null ? globePath  :"Default Globe Logo";
    }


    @Override
    public List<NavItemImpl> getNavItems() {
        return navItems !=null ? navItems:null;
    }
}

