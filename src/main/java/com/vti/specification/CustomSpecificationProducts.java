package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Categories;
import com.vti.entity.Products;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("serial")
@RequiredArgsConstructor
public class CustomSpecificationProducts implements Specification<Products>{
	
	@NonNull
	private String field;
	
	@NonNull
	private Object value;

	@Override
	public Predicate toPredicate(Root<Products> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (field.equalsIgnoreCase("name")) {
			return criteriaBuilder.like(root.get("productName"), "%" + value + "%");
	}
		else if(field.equalsIgnoreCase("categoriesName")) {
			return criteriaBuilder.equal(root.get("categoriesName"),null);
		}
			
		return null;
	}
}
