package com.aem.ford.core.models.impl;

import com.aem.ford.core.models.FordTitle;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    adapters = {FordTitle.class},
    resourceType = {FordTitleImpl.RESOURCE_TYPE},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FordTitleImpl implements FordTitle {


protected static final String RESOURCE_TYPE = "ford/components/content/fordtitle";


    @ValueMapValue
    private String title;

    @ValueMapValue
    private String content;

    @ValueMapValue
    private String backgroundColor;

    @ValueMapValue
    private String titleColor;

    @ValueMapValue
    private String titleSize;

    @ValueMapValue
    private String contentColor;

    @Override
    public String getTitle() {
        return title != null ? title : "Default Title";
    }

    @Override
    public String getContent() {
        return content != null ? content : "Default Content";
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor != null ? backgroundColor : "transparent"; 
    }

    @Override
    public String getTitleColor() {
        return titleColor != null ? titleColor : "#000000";
    }

    @Override
    public String getTitleSize() {
        return titleSize != null ? titleSize : "h1"; 
    }

    @Override
    public String getContentColor() {
        return contentColor != null ? contentColor : "#000000"; 
    }
}
