package com.aem.ford.core.models;

import java.util.List;


public interface AccordionList {
    List<AccordionItem> getItems();

    
    interface AccordionItem {
        String getQuestion();
        String getAnswer();
    }
}
