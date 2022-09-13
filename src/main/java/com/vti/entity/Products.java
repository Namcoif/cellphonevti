package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
@Entity
@Table(name = "products", uniqueConstraints = { @UniqueConstraint(columnNames = "productName") })
public class Products {
    
	@Column(name = "ProductID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Size(max = 50)
	private String productName;

	private Float price;

	private Float salePrice;

	private String imgLink;

	@ManyToOne
	@JoinColumn(name = "CategoryID", nullable = false)
	private Categories categories;

	public Products() {

	}

	public Products(int id, @NotBlank @Size(max = 50) String productName, Float price, Float salePrice, String imgLink,
			Categories categories) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.salePrice = salePrice;
		this.imgLink = imgLink;
		this.categories = categories;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	
//	public void setCategoriesId(int categoiesId) {
//		this.categories.setId(categoiesId);
//	}
}
