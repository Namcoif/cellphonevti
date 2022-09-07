package com.vti.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.entity.Products;
import com.vti.form.product.ProductsFilterForm;

public class ProductsSpecification {
	public static Specification<Products> buildWhere(String search, ProductsFilterForm pdFF){
		Specification<Products> where = null;
		
		if (!StringUtils.isEmpty(search)) {
			search = search.trim();
			CustomSpecificationProducts name = new CustomSpecificationProducts("name", search);
			where = Specification.where(name);	
		}
		
		return where;
	}
}
