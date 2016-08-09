package com.bitwise.producterp.entity;

/**
 * Created by chetanlo on 8/8/2016.
 */

public class ProductEntity {

    private Integer productId;
    private String productName;

    public ProductEntity() {
    }

    public ProductEntity(Integer productId, String productName) {
        this.productName = productName;
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        return productName != null ? productName.equals(that.productName) : that.productName == null;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "ProductEntity{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                '}';
    }
}
