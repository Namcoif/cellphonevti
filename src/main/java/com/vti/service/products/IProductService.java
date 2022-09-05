package com.vti.service.products;

import java.util.List;

import com.vti.entity.Products;
import com.vti.form.product.CreateProductFrom;

public interface IProductService {

	public List<Products> getAllProducts();
	
	public void createAccount(CreateProductFrom form);
}
