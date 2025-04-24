package com.aem.ford.core.models.footer.impl;

import com.aem.ford.core.models.footer.FooterSearch;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.List;

@Model(
    adaptables = Resource.class,
    adapters = FooterSearch.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FooterSearchModel implements FooterSearch {

    @ValueMapValue
    private String linkLabel;

    @ChildResource
    private List<Resource> links;

    @Override
    public String getLinkLabel() {
        return linkLabel;
    }

    @Override
    public List<linkItems> getLinks() {
        List<linkItems> linkItemsList = new ArrayList<>();
        if (links != null) {
            for (Resource link : links) {
                String label = link.getValueMap().get("label", String.class);
                String linkPath = link.getValueMap().get("link", String.class);
                linkItemsList.add(new LinkItemImpl(label, linkPath));
            }
        }
        return linkItemsList;
    }

    private static class LinkItemImpl implements linkItems {
        private final String label;
        private final String link;

        public LinkItemImpl(String label, String link) {
            this.label = label;
            this.link = link;
        }

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