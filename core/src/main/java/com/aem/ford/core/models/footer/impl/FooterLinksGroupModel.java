package com.aem.ford.core.models.footer.impl;



import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FooterLinksGroupModel {

    @ValueMapValue
    private String group;

    @ChildResource(name = "footerItems")
    private List<FooterItems> footerItems;

    public String getGroup() {
        return group;
    }

    public List<FooterItems> getFooterItems() {
        return footerItems;
    }
}
