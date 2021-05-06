package com.everis.products.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindByProductoIdDto {
	private Long productId;
	private int total;
}
