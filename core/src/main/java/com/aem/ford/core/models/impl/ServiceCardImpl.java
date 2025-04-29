package com.aem.ford.core.models.impl;

import com.aem.ford.core.models.ServiceCard;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.List;

@Model(
    adaptables = Resource.class,
    adapters = ServiceCard.class,
    resourceType = "ford/components/content/servicecard",
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ServiceCardImpl implements ServiceCard {

    @ChildResource(name = "serviceCards")
    private List<Resource> serviceCardResources;

    @Override
    public List<ServiceCardItem> getServiceCards() {
        List<ServiceCardItem> serviceCards = new ArrayList<>();
        if (serviceCardResources != null) {
            for (Resource resource : serviceCardResources) {
                serviceCards.add(new ServiceCardItemImpl(resource));
            }
        }
        return serviceCards;
    }

    /**
     * Implementation of the ServiceCardItem interface.
     */
    private static class ServiceCardItemImpl implements ServiceCardItem {
        private final String serviceCardIcon;
        private final String serviceCardTitle;
        private final String serviceCardDescription;
        private final String serviceCardPath;

        public ServiceCardItemImpl(Resource resource) {
            this.serviceCardIcon = resource.getValueMap().get("serviceCardIcon", String.class);
            this.serviceCardTitle = resource.getValueMap().get("serviceCardTitle", String.class);
            this.serviceCardDescription = resource.getValueMap().get("serviceCardDescription", String.class);
            this.serviceCardPath = resource.getValueMap().get("serviceCardPath", String.class);
        }

        @Override
        public String getServiceCardIcon() {
            return serviceCardIcon;
        }

        @Override
        public String getServiceCardTitle() {
            return serviceCardTitle;
        }

        @Override
        public String getServiceCardDescription() {
            return serviceCardDescription;
        }

        @Override
        public String getServiceCardPath() {
            return serviceCardPath;
        }
    }
}

