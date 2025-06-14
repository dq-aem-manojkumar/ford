package com.aem.ford.core.models;

import java.util.List;

import com.aem.ford.core.models.Dto.Product;
import com.day.cq.wcm.api.Page;

public interface ProductListing {
    public List<Page> getChildPages();

    public List<Product> getProducts();

    public List<Product> getInStockProducts();
}

