package com.aem.ford.core.models.impl;

import com.aem.ford.core.models.FordTitle;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { FordTitle.class }, resourceType = {
        FordTitleImpl.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FordTitleImpl implements FordTitle {

    protected static final String RESOURCE_TYPE = "ford/components/content/fordtitle";

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String margin;

    @ValueMapValue
    private String padding;

    @ValueMapValue
    private String titleFontSize;

    @ValueMapValue
    private String titleFontWeight;

    @ValueMapValue
    private String titleColor;

    @ValueMapValue
    private String descriptionFontSize;

    @ValueMapValue
    private String descriptionFontWeight;

    @ValueMapValue
    private String descriptionWidth;

    @ValueMapValue
    private String descriptionColor;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getMargin() {
        return margin != null ? margin : "0px";
    }

    @Override
    public String getPadding() {
        return padding != null ? padding : "0px";
    }

    @Override
    public String getTitleFontSize() {
        return titleFontSize != null ? titleFontSize : "16px";
    }

    @Override
    public String getTitleFontWeight() {
        return titleFontWeight != null ? titleFontWeight : "400";
    }

    @Override
    public String getTitleColor() {
        return titleColor != null ? titleColor : "#000000";
    }

    @Override
    public String getDescriptionFontSize() {
        return descriptionFontSize != null ? descriptionFontSize : "14px";
    }

    @Override
    public String getDescriptionFontWeight() {
        return descriptionFontWeight != null ? descriptionFontWeight : "400";
    }

    @Override
    public String getDescriptionColor() {
        return descriptionColor != null ? descriptionColor : "#000000";
    }

    @Override
    public boolean isEmpty() {
        return (title == null || title.isEmpty()) && (description == null || description.isEmpty());
    }

    @Override
    public String getDescriptionWidth() {
      return descriptionWidth;
    }
}
