package com.everis.products.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSaveRequestDto {
	private String name;
	private String description;
	private Double price;
	private String productType;
}