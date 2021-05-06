package com.everis.products.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStockRequestDto {
    private Long productId;
    private Integer quantity;
}
