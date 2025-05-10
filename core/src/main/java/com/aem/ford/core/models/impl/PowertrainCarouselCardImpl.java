package com.aem.ford.core.models.impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.ford.core.models.PowertrainCarouselCard;
@Model(
    adaptables = Resource.class,
    adapters = PowertrainCarouselCard.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class PowertrainCarouselCardImpl implements PowertrainCarouselCard {


    @ChildResource(name = "powerTrainCards")
    private List<Resource> powerTrainCards;

    @Override
    public List<PowerTrainCardItem> getPowerTrainCards() {
        if (powerTrainCards == null) {
            return Collections.emptyList();
        }
        List<PowerTrainCardItem> items = new ArrayList<>();
        for (Resource card : powerTrainCards) {
            items.add(new PowerTrainCardItemImpl(card));
        }
        return items;
    }


    @Override
    public boolean isEmpty() {
       
        return powerTrainCards == null || powerTrainCards.isEmpty();
    }

    @Model(adaptables = Resource.class)
    public static class PowerTrainCardItemImpl implements PowerTrainCardItem {

        private final Resource resource;

        public PowerTrainCardItemImpl(Resource resource) {
            this.resource = resource;
        }


@ValueMapValue(name = "image")
        private String image;

        @ValueMapValue(name = "title")
        private String title;

        @ValueMapValue(name = "description")
        private String description;

    

        @Override
        public String getImage() {
            return resource.getValueMap().get("image", String.class);
        }

        @Override
        public String getTitle() {
            return resource.getValueMap().get("title", String.class);
        }

        @Override
        public String getDescription() {
            return resource.getValueMap().get("description", String.class);
        }

       

        
    }

}
