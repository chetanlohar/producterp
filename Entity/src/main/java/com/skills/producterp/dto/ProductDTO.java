package com.skills.producterp.dto;

/**
 * Created by chetanlo on 8/10/2016.
 */
public class ProductDTO {
    private Long productId;
    private String productName;
    public ProductDTO() {
    }
    public ProductDTO(Long productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
}
