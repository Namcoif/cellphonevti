package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.dto.ProductsDTO;
import com.vti.entity.Products;
import com.vti.form.product.ProductsFilterForm;

public interface IProductsService {
	Page<Products> getListProducts(Pageable pageable, String search, ProductsFilterForm pdFF);
	
	List<Products> getListProducts();
	
	void creatProducts(ProductsDTO pdDTO);

}
