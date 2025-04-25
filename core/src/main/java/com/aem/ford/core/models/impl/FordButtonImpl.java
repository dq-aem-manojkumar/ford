package com.aem.ford.core.models.impl;

import com.aem.ford.core.models.FordButton;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    adapters = {FordButton.class},
    resourceType = {FordButtonImpl.RESOURCE_TYPE},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FordButtonImpl implements FordButton {

    protected static final String RESOURCE_TYPE = "ford/components/content/fordbutton";

    @Self
    private SlingHttpServletRequest request;

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String link;

    @ValueMapValue
    private String backgroundColor;

    @ValueMapValue
    private String textColor;

    @ValueMapValue
    private String padding;

    @ValueMapValue
    private String margin;

    @ValueMapValue
    private String width;

    @ValueMapValue
    private String height;

    @ValueMapValue
    private String borderColor;

    @ValueMapValue
    private String borderSize;

    @ValueMapValue
    private String borderRadius;

    @PostConstruct
    protected void init() {
        // Set default values if properties are not configured
        if (StringUtils.isBlank(text)) {
            text = "Click Me";
        }
        if (StringUtils.isBlank(backgroundColor)) {
            backgroundColor = "transparent";
        }
        if (StringUtils.isBlank(textColor)) {
            textColor = "#000000";
        }
        if (StringUtils.isBlank(padding)) {
            padding = "10px 20px";
        }
        if (StringUtils.isBlank(width)) {
            width = "auto";
        }
        if (StringUtils.isBlank(height)) {
            height = "auto";
        }
        if (StringUtils.isBlank(borderSize)) {
            borderSize = "1px"; // Default border size
        }
        if (StringUtils.isBlank(borderRadius)) {
            borderRadius = "0px"; // Default to no border radius
        }
        if (StringUtils.isBlank(margin)) {
            margin = "0px"; // Default to no margin
        }
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getLink() {
        return link+".html";
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String getTextColor() {
        return textColor;
    }

    @Override
    public String getPadding() {
        return padding;
    }
    @Override
    public String getMargin() {
        return margin;
    }

    @Override
    public String getWidth() {
        return width;
    }

    @Override
    public String getHeight() {
        return height;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public String getBorderSize() {
        return borderSize;
    }

    @Override
    public String getBorderRadius() {
        return borderRadius;
    }

    @Override
    public boolean isEmpty() {
        return StringUtils.isBlank(text) || StringUtils.isBlank(link);
    }
}
