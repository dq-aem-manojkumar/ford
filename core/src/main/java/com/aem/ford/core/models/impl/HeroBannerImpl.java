package com.aem.ford.core.models.impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.factory.ModelFactory;
import com.adobe.cq.wcm.core.components.models.Image;
import com.aem.ford.core.models.HeroBanner;


@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {HeroBanner.class},
        resourceType = {HeroBannerImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeroBannerImpl implements HeroBanner {
    protected static final String RESOURCE_TYPE = "wknd/components/byline";

    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private ModelFactory modelFactory;

    @ValueMapValue
    private String name;

    @ValueMapValue
    private List<String> occupations;

    private Image image;

    /**
    * @PostConstruct is immediately called after the class has been initialized
    * but BEFORE any of the other public methods.
    * It is a good method to initialize variables that is used by methods in the rest of the model
    *
    */
    @PostConstruct
    private void init() {
        // set the image object
        image = modelFactory.getModelFromWrappedRequest(request, request.getResource(), Image.class);
        if(StringUtils.isBlank(name)) {
            name = ""; // Set a default name if none is provided
        }
        if (occupations == null || occupations.isEmpty()) {
            occupations = new ArrayList<>();
            occupations.add(""); // Set a default occupation if none is provided
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getOccupations() {
        if (occupations != null) {
            Collections.sort(occupations);
            return new ArrayList<String>(occupations);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean isEmpty() {
        final Image componentImage = getImage();

        if (StringUtils.isBlank(name)) {
            // Name is missing, but required
            return true;
        } else if (occupations == null || occupations.isEmpty()) {
            // At least one occupation is required
            return true;
        } else if (componentImage == null || StringUtils.isBlank(componentImage.getSrc())) {
            // A valid image is required
            return true;
        } else {
            // Everything is populated, so this component is not considered empty
            return false;
        }
    }

    /**
    * @return the Image Sling Model of this resource, or null if the resource cannot create a valid Image Sling Model.
    */
    private Image getImage() {
        return image;
    }
}
