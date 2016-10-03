package com.bitwise.producterp.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chetanlo on 10/3/2016.
 */

@Entity
@Table(name = "tbl_product_category")
public class CategoryEntity implements Serializable{

    @Id
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "category_name")
    private String categoryName;

    public CategoryEntity() {
    }

    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryEntity)) return false;
        CategoryEntity that = (CategoryEntity) o;
        if (!categoryId.equals(that.categoryId)) return false;
        return categoryName.equals(that.categoryName);
    }

    @Override
    public int hashCode() {
        int result = categoryId.hashCode();
        result = 31 * result + categoryName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
