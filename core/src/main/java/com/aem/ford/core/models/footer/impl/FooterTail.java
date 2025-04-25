package com.aem.ford.core.models.footer.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.ford.core.models.footer.FooterTailModel;

import java.util.List;

@Model(
    adaptables = Resource.class,
    adapters = FooterTailModel.class, // Specify the interface here
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FooterTail implements FooterTailModel {

    @ValueMapValue
    private String languagePath;

    @ValueMapValue
    private String iconPhotoLan;

    @ValueMapValue
    private String homePath;

    @ValueMapValue
    private String iconPhotoHome;

    @ChildResource(name = "socialLinks")
    private List<SocialLinkImpl> socialLinks;

    @Override
    public String getLanguagePath() {
        return languagePath;
    }

    @Override
    public String getIconPhotoLan() {
        return iconPhotoLan;
    }

    @Override
    public String getHomePath() {
        return homePath;
    }

    @Override
    public String getIconPhotoHome() {
        return iconPhotoHome;
    }

    @Override
    public List<SocialLink> getSocialLinks() {
        return (List<SocialLink>) (List<?>) socialLinks; // Cast to match the interface
    }

    @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    public static class SocialLinkImpl implements SocialLink {

        @ValueMapValue(name = "label")
        private String label;

        @ValueMapValue(name = "Link")
        private String link;

        @Override
        public String getLabel() {
            return label;
        }

        @Override
        public String getLink() {
            return link;
        }
    }
}