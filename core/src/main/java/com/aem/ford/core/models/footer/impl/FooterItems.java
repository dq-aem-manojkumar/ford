package com.aem.ford.core.models.footer.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FooterItems{
    @ValueMapValue
    private String label;
    @ValueMapValue
    private String path;

    public String getLabel() {
        return label;
    }

    public String getPath() {
        return path + ".html";
    }
}