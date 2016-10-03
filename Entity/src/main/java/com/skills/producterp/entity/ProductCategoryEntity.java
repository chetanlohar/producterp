package com.skills.producterp.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chetanlo on 10/3/2016.
 */
@Entity
@Table(name = "product_category_det")
public class ProductCategoryEntity implements Serializable{

    @Id
    @Column(name = "product_cat_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer productCatId;

    @ManyToOne(targetEntity=ProductEntity.class,fetch=FetchType.EAGER)
    @JoinColumn(name="productId")
    private ProductEntity productEntity;

    @ManyToOne(targetEntity=CategoryEntity.class,fetch=FetchType.EAGER)
    @JoinColumn(name="categoryId")
    private CategoryEntity categoryEntity;
    public Integer getProductCatId() {
        return productCatId;
    }
    public void setProductCatId(Integer productCatId) {
        this.productCatId = productCatId;
    }
    public ProductEntity getProductEntity() {
        return productEntity;
    }
    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }
    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCategoryEntity)) return false;

        ProductCategoryEntity that = (ProductCategoryEntity) o;

        if (productCatId != null ? !productCatId.equals(that.productCatId) : that.productCatId != null) return false;
        if (!productEntity.equals(that.productEntity)) return false;
        return categoryEntity.equals(that.categoryEntity);

    }
    @Override
    public int hashCode() {
        int result = productCatId != null ? productCatId.hashCode() : 0;
        result = 31 * result + productEntity.hashCode();
        result = 31 * result + categoryEntity.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProductCategoryEntity{" +
                "productCatId=" + productCatId +
                ", productEntity=" + productEntity +
                ", categoryEntity=" + categoryEntity +
                '}';
    }
}
