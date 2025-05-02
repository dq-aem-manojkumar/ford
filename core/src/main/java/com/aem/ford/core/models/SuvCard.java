package com.aem.ford.core.models;

import java.util.List;

public interface SuvCard {

   
    List<SuvcardItem> getSuvCards();
    boolean isEmpty();
    interface SuvcardItem {
        String getImage(); 
        String getTitle();
        String getPriceDescription();
        String getEmployeePriceDescription();
        String getCta1Text();
        String getCta1Link();      
        String getCta2Text();
        String getCta2Link(); 
    
    }

   
    
}

