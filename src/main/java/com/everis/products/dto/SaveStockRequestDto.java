package com.everis.products.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveStockRequestDto {
	private Long productId;
	private Long wareHouseId;
	private Integer quantity;

}
