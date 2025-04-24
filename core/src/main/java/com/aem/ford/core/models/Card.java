package com.aem.ford.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface Card {
    String getImage();
    String getImageAlt();
    String getOverlayText();
    String getOverlayLink();
    String getTitle();
    String getDescription();
    String getButtonText();
    String getButtonLink();
}