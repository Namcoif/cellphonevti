package com.vti.service.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Products;
import com.vti.form.product.CreateProductFrom;
import com.vti.repository.ICategoriesRepository;
import com.vti.repository.IProductRepository;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepository productRepository;
	
	@Autowired
	private ICategoriesRepository cateRepository;

	@Override
	public List<Products> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void createAccount(CreateProductFrom form) {
		
		
	}

}
