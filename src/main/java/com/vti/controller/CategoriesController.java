package com.vti.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.CategoriesDTO;
import com.vti.entity.Categories;
import com.vti.repository.CategoriesRepository;
import com.vti.service.CategoriesService;

@RestController
@RequestMapping(value = "/api/manager/categories")
public class CategoriesController {
	
	@Autowired
	private CategoriesService csService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping()
	public List<CategoriesDTO> getListCategories() {
		List<Categories> listCategories = csService.getListCategories();
		
		List<CategoriesDTO> listCategoriesDTO = modelMapper.map(listCategories, new TypeToken< List<CategoriesDTO> >(){}.getType());
		
		return listCategoriesDTO;
	}
}
