package com.vti.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.dto.InforUpDateDTO;
import com.vti.dto.ProductsDTO;
import com.vti.entity.Products;
import com.vti.form.product.ProductsFilterForm;
import com.vti.repository.ProductsRepository;
import com.vti.specification.ProductsSpecification;

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


	@Override
	public Page<Products> getListProducts(Pageable pageable, String search, ProductsFilterForm pdFF) {
		Specification<Products> where = ProductsSpecification.buildWhere(search, pdFF);
		return pdRepository.findAll(where,pageable);
	}


	@Override
	public void deleteProducts(int id) {
		pdRepository.deleteById(id);
	}


	@Override
	public void deleteMultipleProducts(List<Integer> ids) {
		pdRepository.deleteMultilProducts(ids);
	}

	@Override
	public void updateProducts(InforUpDateDTO ifDTO) {
		Products pd = modelMapper.map(ifDTO, Products.class);
		pdRepository.save(pd);
		
	}


	

}
