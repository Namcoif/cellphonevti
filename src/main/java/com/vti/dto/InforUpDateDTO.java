package com.vti.dto;

import lombok.Data;

@Data
public class InforUpDateDTO {
	private int id;

	private String productName;

	private Float price;

	private Float salePrice;

//	private String imgLink;

	private int categoriesId;
}
