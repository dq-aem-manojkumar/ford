package com.aem.ford.core.models.impl;

import com.aem.ford.core.models.LinkList;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(adaptables = Resource.class, adapters = LinkList.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinkListImpl implements LinkList {

    @ChildResource(name = "links")
    private List<Resource> links;

    @ValueMapValue(name = "cssClass")
    private String cssClass; 

    @Override
    public List<Link> getLinks() {
        if (links == null) {
            return Collections.emptyList();
        }

        List<Link> linkList = new ArrayList<>();
        for (Resource linkResource : links) {
            linkList.add(new LinkImpl(linkResource));
        }
        return linkList;
    }

    @Override
    public String getCssClass() {
        return cssClass; 
    }

    @Override
    public boolean isEmpty() {
        boolean linksEmpty = (links == null || links.isEmpty());
        boolean cssClassEmpty = (cssClass == null || cssClass.trim().isEmpty());
        return linksEmpty && cssClassEmpty;
    }

    private static class LinkImpl implements Link {
        
        private final String text;
        private final String path;

        LinkImpl(Resource resource) {
            this.text = resource.getValueMap().get("text", String.class);
            this.path = resource.getValueMap().get("path", String.class);
        }

        @Override
        public String getText() {
            return text;
        }

        @Override
        public String getPath() {
            return path+".html";
        }
    }

    
}
