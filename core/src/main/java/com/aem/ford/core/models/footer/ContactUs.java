package com.aem.ford.core.models.footer;

import java.util.List;

public interface ContactUs {
    String getUpdatePath();
    String getMailIconPath();
    List<SocialIcon> getSocialLinks();

    interface SocialIcon {
        String getIcon();
        String getUrl();
    }
}
