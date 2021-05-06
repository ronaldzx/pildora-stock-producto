package com.everis.products.service;

import java.util.List;

import com.everis.products.dto.UpdateStockRequestDto;
import com.everis.products.entity.Stock;

public interface StockService {

	public List<Stock> findByProductId(Long id) throws Exception;

	public List<Stock> save(List<Stock> stock) throws Exception;

	public List<Stock> update(UpdateStockRequestDto updateStockRequestDto) throws Exception;

}
