package com.vti.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.dto.ProductsDTO;
import com.vti.entity.Products;
import com.vti.repository.ProductsRepository;

@Service
public class ProductsService implements IProductsService{

	@Autowired
	private ProductsRepository pdRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Products> getListProducts() {
		return pdRepository.findAll();
	}


	@Override
	@Transactional
	public void creatProducts(ProductsDTO pdDTO) {
		Products pds = modelMapper.map(pdDTO, Products.class);
		Products product = pdRepository.save(pds);
	}

}
