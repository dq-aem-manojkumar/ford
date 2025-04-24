package com.aem.ford.core.models.footer;

import java.util.List;

public interface FooterSearch {
    String getLinkLabel();
    List<linkItems> getLinks();
    interface linkItems {
        String getLabel();
        String getLink();
    }
    
}
