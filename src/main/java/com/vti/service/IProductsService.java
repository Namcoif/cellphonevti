package com.vti.service;

import java.util.List;

import com.vti.dto.ProductsDTO;
import com.vti.entity.Products;

public interface IProductsService {
	
	
	List<Products> getListProducts();
	
	void creatProducts(ProductsDTO pdDTO);

}
