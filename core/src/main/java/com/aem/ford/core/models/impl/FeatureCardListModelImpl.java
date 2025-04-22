package com.aem.ford.core.models.impl;

import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import com.aem.ford.core.models.FeatureCardList;


@Model(
    adaptables = {SlingHttpServletRequest.class},
    adapters = {FeatureCardList.class},
    resourceType = {FeatureCardListModelImpl.RESOURCE_TYPE},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FeatureCardListModelImpl implements FeatureCardList {
        protected static final String RESOURCE_TYPE = "ford/components/content/featurecardlist";

        @ChildResource(name = "featureCardList")
        private List<FeatureCardImpl> featureCard;


        @Override
        public List<FeatureCardImpl> getFeatureCard() {
        
            return featureCard!=null? featureCard : null;

        }

}
