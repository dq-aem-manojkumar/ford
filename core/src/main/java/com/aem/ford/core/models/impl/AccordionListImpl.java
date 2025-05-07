package com.aem.ford.core.models.impl;

import com.aem.ford.core.models.AccordionList;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model(
    adaptables = Resource.class,
    adapters = AccordionList.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class AccordionListImpl implements AccordionList {

    @Inject
    private Resource items;

    private List<AccordionItem> accordionItems = new ArrayList<>();

    @PostConstruct
    protected void init() {
        if (items != null) {
            for (Resource child : items.getChildren()) {
                AccordionItem item = child.adaptTo(AccordionItemImpl.class);
                if (item != null) {
                    accordionItems.add(item);
                }
            }
        }
    }

    @Override
    public List<AccordionItem> getItems() {
        return accordionItems;
    }

    @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    public static class AccordionItemImpl implements AccordionItem {

        @ValueMapValue
        private String question;

        @ValueMapValue
        private String answer;

        @Override
        public String getQuestion() {
            return question;
        }

        @Override
        public String getAnswer() {
            return answer;
        }
    }
}
