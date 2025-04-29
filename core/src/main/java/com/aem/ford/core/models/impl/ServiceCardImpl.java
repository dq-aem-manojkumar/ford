    package com.aem.ford.core.models.impl;    
    import com.aem.ford.core.models.ServiceCard;
    import org.apache.sling.api.resource.Resource;
    import org.apache.sling.models.annotations.DefaultInjectionStrategy;
    import org.apache.sling.models.annotations.Model;
    import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
    
    import javax.annotation.PostConstruct;
    
    @Model(
        adaptables = Resource.class,
        adapters = ServiceCard.class,
        resourceType = "ford/components/content/servicecard",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
    )
    public class ServiceCardImpl implements ServiceCard {
    
        @ValueMapValue
        private String serviceCardIcon;
    
        @ValueMapValue
        private String serviceCardTitle;
    
        @ValueMapValue
        private String serviceCardDescription;
    
        @ValueMapValue
        private String serviceCardPath;
    
        @PostConstruct
        protected void init() {
            // Any additional initialization logic can go here
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

