package com.aem.ford.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import com.aem.ford.core.models.VehicleCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(
    adaptables = Resource.class,
    adapters = VehicleCard.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class VehicleCardImpl implements VehicleCard {

    @ChildResource
    private List<Resource> cards;

    @Override
    public List<CardItem> getCards() {
        if (cards == null) {
            return Collections.emptyList();
        }
        List<CardItem> cardItems = new ArrayList<>();
        for (Resource card : cards) {
            cardItems.add(new CardItemImpl(card));
        }
        return cardItems;
    }

    public static class CardItemImpl implements CardItem {

        private final Resource resource;

        public CardItemImpl(Resource resource) {
            this.resource = resource;
        }

        private String getValue(String key) {
            return resource.getValueMap().get(key, "");
        }

        @Override public String getImagePath() { return getValue("image"); }
        @Override public String getShownPriceLabel() { return getValue("overlayText"); }
        @Override public String getOverlayLink() { return getValue("overlayLink"); }
        @Override public String getTitle() { return getValue("title"); }
        @Override public String getPrice() { return getValue("price"); }
        @Override public String getDescription() { return getValue("description"); }
        @Override public String getCta1Text() { return getValue("cta1Text"); }
        @Override public String getCta1Link() { return getValue("cta1Link"); }
        @Override public String getCta2Text() { return getValue("cta2Text"); }
        @Override public String getCta2Link() { return getValue("cta2Link"); }
    }
}
