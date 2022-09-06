package com.vti.dto;

import com.vti.entity.Categories;

import lombok.Data;

@Data
public class ProductsDTO {
	private int id;
	
	private String productName;
	
	private  Float price;
	
	private Float salePrice;
	
	private String imgLink;
	
	private int categoriesId;
}
