package com.aem.ford.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;


@Model(adaptables = Resource.class, resourceType = "ford/components/content/navvehicle",
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class NavVehicle {

    @ValueMapValue
    private String vehicleImage;

    @ValueMapValue
    private String vehicleTitle;

    @ValueMapValue
    private String priceDescription;

    @ValueMapValue
    private String vehicleCategory;

    @ValueMapValue
    private String path;

    public String getVehicleImage() {
        return vehicleImage;
    }

    public String getVehicleTitle() {
        return vehicleTitle;
    }

    public String getPriceDescription() {
        return priceDescription;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public String getPath() {
        return path;
    }
}
