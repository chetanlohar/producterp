package com.bitwise.producterp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by chetanlo on 8/8/2016.
 */

@Entity
@Table(name = "tbl_product")
public class ProductEntity implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "productid")
    private Long productId;
    @Column(name = "productname")
    private String productName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productEntity")
    private Set<ProductCategoryEntity> productCategoryEntityList;

    public ProductEntity() {
    }

    public ProductEntity(Long productId, String productName) {
        this.productName = productName;
        this.productId = productId;
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
    public Set<ProductCategoryEntity> getProductCategoryEntityList() {
        return productCategoryEntityList;
    }
    public void setProductCategoryEntityList(Set<ProductCategoryEntity> productCategoryEntityList) {
        this.productCategoryEntityList = productCategoryEntityList;
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
                ", productCategoryEntityList=" + productCategoryEntityList +
                '}';
    }
}
