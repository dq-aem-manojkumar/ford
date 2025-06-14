package com.aem.ford.core.models.Dto;

public class Product {

    private String productName;

    private String productDescription;

    private double price;

    private boolean inStock;

    private String productCategory;

    private String productImagePath;


    public Product(boolean inStock, double price, String productCategory, String productImagePath, String productName, String productDescription) {
        this.inStock = inStock;
        this.price = price;
        this.productCategory = productCategory;
        this.productImagePath = productImagePath;
        this.productName = productName;
        this.productDescription = productDescription;
    }

    public Product() {
    }

    public boolean isInStock() {
        return inStock;
    }

    public double getPrice() {
        return price;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    @Override
    public String toString() {
        return "Product{" +
                "inStock=" + inStock +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price='" + price + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productImagePath='" + productImagePath + '\'' +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
