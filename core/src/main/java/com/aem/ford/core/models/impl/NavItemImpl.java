package com.aem.ford.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.aem.ford.core.models.NavItem;
@Model(adaptables = Resource.class, 
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavItemImpl implements NavItem {
    @ValueMapValue
    private String label;

    // @ValueMapValue
    // private String path;

    @Override
    public String getLabel() {
        return label;
    }

   
}


