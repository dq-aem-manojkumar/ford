package com.aem.ford.core.models.impl;

import com.aem.ford.core.models.FeatureCard;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(
    adaptables = Resource.class,
    adapters = FeatureCard.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FeatureCardImpl implements FeatureCard {

    @ChildResource(name = "cards")
    private List<Resource> cards;

    @Override
    public List<FeatureCardItem> getCards() {
        if (cards == null) {
            return Collections.emptyList();
        }
        List<FeatureCardItem> cardItems = new ArrayList<>();
        for (Resource card : cards) {
            cardItems.add(new FeatureCardItemImpl(card));
        }
        return cardItems;
    }

    @Override
    public boolean isEmpty() {
       
        return cards == null || cards.isEmpty();
    }

    
    public static class FeatureCardItemImpl implements FeatureCardItem {

        private final Resource resource;

        public FeatureCardItemImpl(Resource resource) {
            this.resource = resource;
        }

        @ValueMapValue(name = "imagePath")
        private String imagePath;

        @ValueMapValue(name = "title")
        private String title;

        @ValueMapValue(name = "description")
        private String description;

        @ValueMapValue(name = "showButton")
        private boolean showButton;

        @Override
        public String getImagePath() {
            return resource.getValueMap().get("imagePath", String.class);
        }

        @Override
        public String getTitle() {
            return resource.getValueMap().get("title", String.class);
        }

        @Override
        public String getDescription() {
            return resource.getValueMap().get("description", String.class);
        }

        @Override
        public boolean isShowButton()  {
            return resource.getValueMap().get("showButton", Boolean.class);
        }
    }

    
}


