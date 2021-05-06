package com.everis.products.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFindByPriceDto {
	private String nombre;
	private String descripcion;
	private Double precio;
	private String estado;
}