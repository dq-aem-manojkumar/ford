package com.aem.ford.core.models.footer.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import com.aem.ford.core.models.footer.FooterModel;

import java.util.List;

@Model(
    adaptables = Resource.class,
    adapters = FooterModel.class, // Specify the interface here
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FooterModelMain implements FooterModel {

    @ChildResource(name = "groupNames")
    private List<FooterLinksGroupModel> groups;

    @Override
    public List<FooterLinksGroupModel> getGroups() {
        return groups;
    }
}