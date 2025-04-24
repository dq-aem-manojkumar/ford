package com.aem.ford.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.aem.ford.core.models.Card;

import javax.inject.Inject;

@Model(
    adaptables = Resource.class,
    adapters = Card.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CardImpl implements com.aem.ford.core.models.Card {

    @Inject private String image;
    @Inject private String imageAlt;
    @Inject private String overlayText;
    @Inject private String overlayLink;
    @Inject private String title;
    @Inject private String description;
    @Inject private String buttonText;
    @Inject private String buttonLink;

    @Override public String getImage() { return image; }
    @Override public String getImageAlt() { return imageAlt; }
    @Override public String getOverlayText() { return overlayText; }
    @Override public String getOverlayLink() { return overlayLink; }
    @Override public String getTitle() { return title; }
    @Override public String getDescription() { return description; }
    @Override public String getButtonText() { return buttonText; }
    @Override public String getButtonLink() { return buttonLink; }
}