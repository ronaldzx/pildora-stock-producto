package com.everis.products.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSaveResponseDto {
	private Long id;
	private String name;
	private String description;
	private Double price;
	private ProductTypeDto productType;
}