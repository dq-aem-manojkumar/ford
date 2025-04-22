package com.aem.ford.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.ford.core.models.FeatureCard;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FeatureCardImpl implements FeatureCard{
 
@ValueMapValue
private String imagePath;

@ValueMapValue
private String description;

@ValueMapValue
private String title;

@ValueMapValue
private String buttonText;

@ValueMapValue
private String buttonLink;

@ValueMapValue
private String vehicleText;

@ValueMapValue
private String vehiclLink;


@Override
public String getImagePath() {
    return imagePath != null ? imagePath : "Deafutl Image";
}

@Override
public String getDescription() {
    return description != null ? description : "Deafutl description";
}

@Override
public String getTitle() {
    return title != null ? title : "Deafutl title";
}

@Override
public String getButtonText() {
    return buttonText != null ? buttonText : "Deafutl buttonText";
}

@Override
public String getButtonLink() {
    return buttonLink != null ? buttonLink :"Deafutl buttonLink";
}

@Override
public String getVehicleText() {
    return vehicleText != null ? vehicleText :"Deafutl vehicleText";
}

@Override
public String getVehiclLink() {
    return vehiclLink != null ? vehiclLink :"Deafutl vehiclLink";
}



}