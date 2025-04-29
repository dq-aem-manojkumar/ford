package com.aem.ford.core.models;

import java.util.List;

public interface ServiceCard {

    /**
     * Returns a list of service card items.
     *
     * @return List of ServiceCardItem
     */
    List<ServiceCardItem> getServiceCards();

    /**
     * Represents a single service card item.
     */
    interface ServiceCardItem {
        String getServiceCardIcon();

        String getServiceCardTitle();

        String getServiceCardDescription();

        String getServiceCardPath();
    }
}
