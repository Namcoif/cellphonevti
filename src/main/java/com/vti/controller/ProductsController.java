package com.vti.controller;

import java.util.List;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.ProductsDTO;
import com.vti.entity.Products;
import com.vti.form.product.ProductsFilterForm;
import com.vti.service.ProductsService;

@RestController
@RequestMapping(value = "/api/manager/products")
public class ProductsController {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductsService pdService;
	
	@GetMapping
	public List<ProductsDTO> getListProducts(){
		List<Products> listProduct = pdService.getListProducts();
		
		List<ProductsDTO> listProductsDTO = modelMapper.map(listProduct, new TypeToken< List<ProductsDTO> >(){}.getType());
		
		return listProductsDTO;
	}
	
	@GetMapping(value = "/paging")
	public Page<ProductsDTO> getListProducts(Pageable pageable,
			@RequestParam(value = "search",required = false) String search, ProductsFilterForm pdFF){
		Page<Products> pageProducts = pdService.getListProducts(pageable, search, pdFF);
		List<ProductsDTO> listProductsDTO = modelMapper.map(pageProducts.getContent(), new TypeToken< List<ProductsDTO> >(){}.getType());
		Page<ProductsDTO> pageProductsDTO = new PageImpl(listProductsDTO, pageable, pageProducts.getTotalElements());
		return pageProductsDTO;
	}
	
	@PostMapping()
	public ResponseEntity<?> createProducts(@RequestBody ProductsDTO pdDTO){
		pdService.creatProducts(pdDTO);;
		JSONObject message = new JSONObject();
		message.put("rusultText", "Products inserted successfully");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
		
	}
}
