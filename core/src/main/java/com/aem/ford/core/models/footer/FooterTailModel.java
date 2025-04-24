package com.aem.ford.core.models.footer;

import java.util.List;

public interface FooterTailModel {
    String getLanguagePath();
    String getIconPhotoLan();
    String getHomePath();
    String getIconPhotoHome();
    List<SocialLink> getSocialLinks();

    interface SocialLink {
        String getLabel();
        String getLink();
    }
    

    
}
