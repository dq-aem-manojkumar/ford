package com.aem.ford.core.models;

import java.util.List;

public interface PowertrainCarouselCard {

    List<PowerTrainCardItem> getPowerTrainCards();

    boolean isEmpty();

    interface PowerTrainCardItem {
        String getImage();
        String getTitle();
        String getDescription();
    }
}
