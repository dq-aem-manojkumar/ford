package com.aem.ford.core.models;

import java.util.List;

public interface LinkList {
    List<Link> getLinks();
    String getCssClass(); 
    boolean isEmpty();

    interface Link {
        String getText();
        String getPath();
    }
}
