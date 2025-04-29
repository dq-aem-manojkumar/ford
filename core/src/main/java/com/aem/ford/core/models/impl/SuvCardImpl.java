package com.aem.ford.core.models.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.ford.core.models.SuvCard;

@Model(
    adaptables = Resource.class,
    adapters = SuvCard.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class SuvCardImpl implements SuvCard {

    @ChildResource(name = "suvCards")
    private List<Resource> suvCards;

    @Override
    public List<SuvcardItem> getSuvCards() {
        if (suvCards == null) {
            return Collections.emptyList();
        }
        List<SuvcardItem> items = new ArrayList<>();
        for (Resource card : suvCards) {
            items.add(new SuvcardItemImpl(card));
        }
        return items;
    }


    @Override
    public boolean isEmpty() {
       
        return suvCards == null || suvCards.isEmpty();
    }

    // Inner class implementing SuvcardItem
    public static class SuvcardItemImpl implements SuvcardItem {

        private final Resource resource;

        public SuvcardItemImpl(Resource resource) {
            this.resource = resource;
        }


@ValueMapValue(name = "imagePath")
        private String imagePath;

        @ValueMapValue(name = "title")
        private String title;

        @ValueMapValue(name = "priceDescription")
        private String priceDescription;

        @ValueMapValue(name = "employeePriceDescription")
        private String employeePriceDescription;

        @ValueMapValue(name="cta1Text")
        private String cta1Text;

        @ValueMapValue(name="cta1Link")
        private String cta1Link;

        @ValueMapValue(name="cta2Text")
        private String cta2Text;
        
        @ValueMapValue(name="cta2Link")
        private String cta2Link;


        @Override
        public String getImage() {
            return resource.getValueMap().get("imagePath", String.class);
        }

        @Override
        public String getTitle() {
            return resource.getValueMap().get("title", String.class);
        }

        @Override
        public String getPriceDescription() {
            return resource.getValueMap().get("priceDescription", String.class);
        }

        @Override
        public String getEmployeePriceDescription() {
            return resource.getValueMap().get("employeePriceDescription", String.class);
        }

        @Override
        public String getCta1Text() {
            return resource.getValueMap().get("cta1Text", String.class);

        }

        @Override
        public String getCta1Link() {
            return resource.getValueMap().get("cta1Link", String.class);

        }

        @Override
        public String getCta2Text() {
            return resource.getValueMap().get("cta2Text", String.class);

        }

        @Override
        public String getCta2Link() {
            return resource.getValueMap().get("cta2Link", String.class);

        }
    }


}
