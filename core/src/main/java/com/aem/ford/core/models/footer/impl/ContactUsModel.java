package com.aem.ford.core.models.footer.impl;

import com.aem.ford.core.models.footer.ContactUs;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.List;

@Model(
    adaptables = Resource.class,
    adapters = ContactUs.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ContactUsModel implements ContactUs {

    // Injecting the "updatePath" field
    @ValueMapValue
    private String updatePath;

    // Injecting the "mailIconPath" field
    @ValueMapValue
    private String mailIconPath;

    // Injecting the "socialLinks" multifield
    @ChildResource
    private List<Resource> socialLinks;

    @Override
    public String getUpdatePath() {
        return updatePath;
    }

    @Override
    public String getMailIconPath() {
        return mailIconPath;
    }

    @Override
    public List<SocialIcon> getSocialLinks() {
        List<SocialIcon> links = new ArrayList<>();
        if (socialLinks != null) {
            for (Resource link : socialLinks) {
                String url = link.getValueMap().get("url", String.class);
                String icon = link.getValueMap().get("icon", String.class);
                links.add(new SocialIconImpl(url, icon));
            }
        }
        return links;
    }

    private static class SocialIconImpl implements SocialIcon {
        private final String url;
        private final String icon;

        public SocialIconImpl(String url, String icon) {
            this.url = url;
            this.icon = icon;
        }

        @Override
        public String getUrl() {
            return url;
        }

        @Override
        public String getIcon() {
            return icon;
        }
    }
}
