package com.everis.products.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveStockResponseDto {
	private Long id;
	private Long productId;
	private Long wareHouseId;
	private Integer quainty;
}
