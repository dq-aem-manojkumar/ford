package com.aem.ford.core.models.impl;

import com.aem.ford.core.models.HeroAward;


import org.apache.sling.api.SlingHttpServletRequest;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;

import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(
    adaptables = {SlingHttpServletRequest.class},
    adapters = {HeroAward.class},
    resourceType = {HeroAwardImpl.RESOURCE_TYPE},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeroAwardImpl implements HeroAward {

    protected static final String RESOURCE_TYPE = "ford/components/content/heroaward";
    
    @ValueMapValue
    private String imagePath;

    @Override
    public String getImagePath() {
        return imagePath;
    }

    
}
