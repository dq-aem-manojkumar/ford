package com.aem.ford.core.models;

import java.util.List;

public interface VehicleCard {

    List<CardItem> getCards();

    interface CardItem {
        String getImagePath();
        String getShownPriceLabel();
        String getOverlayLink();
        String getTitle();
        String getPrice();
        String getDescription();
        String getCta1Text();
        String getCta1Link();
        String getCta2Text();
        String getCta2Link();
        
    }
}
