package com.everis.products.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStockResponseDto {
    private Long productId;
    private int quantity;
}
