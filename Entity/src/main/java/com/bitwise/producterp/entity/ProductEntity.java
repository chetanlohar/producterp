package com.bitwise.producterp.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "product_category_details", joinColumns = {
			@JoinColumn(name = "product_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "category_id",
					nullable = false, updatable = false) })
    private Set<CategoryEntity> categories = new HashSet<CategoryEntity>(0);

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
    
    
    public Set<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryEntity> categories) {
		this.categories = categories;
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
		return "ProductEntity [productId=" + productId + ", productName=" + productName + "]";
	}
    
}
