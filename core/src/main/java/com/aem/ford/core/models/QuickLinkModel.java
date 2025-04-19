package com.aem.ford.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class QuickLinkModel {

    @ValueMapValue
    private String iconPath;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String titleLink;

    @ValueMapValue
    private String description;

    public String getIconPath() {
        return iconPath != null ? iconPath : "default-icon-path";
    }

    public String getTitle() {
        return title != null ? title : "Default Title";
    }

    public String getTitleLink() {
        return titleLink != null ? titleLink : "#";
    }

    public String getDescription() {
        return description != null ? description : "Default Description";
    }
}
