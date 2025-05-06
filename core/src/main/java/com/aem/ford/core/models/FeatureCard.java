
package com.aem.ford.core.models;

import java.util.List;

public interface FeatureCard {

    List<FeatureCardItem> getCards();
    boolean isEmpty();
    interface FeatureCardItem {
        String getImagePath();
        String getTitle();
        String getDescription(); 
        boolean isShowButton(); 
        
    }

}