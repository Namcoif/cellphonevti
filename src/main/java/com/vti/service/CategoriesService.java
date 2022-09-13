package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Categories;
import com.vti.repository.CategoriesRepository;

@Service
public class CategoriesService implements ICategoriesService{
	
	@Autowired
	private CategoriesRepository csRepository;
	
	
	@Override
	public List<Categories> getListCategories() {
		
		return csRepository.findAll();
	}
	
}
