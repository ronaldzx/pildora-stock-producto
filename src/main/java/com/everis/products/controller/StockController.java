package com.everis.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.products.dto.FindByProductoIdDto;
import com.everis.products.dto.SaveStockRequestDto;
import com.everis.products.dto.SaveStockResponseDto;
import com.everis.products.dto.UpdateStockRequestDto;
import com.everis.products.dto.UpdateStockResponseDto;
import com.everis.products.entity.Stock;
import com.everis.products.mapper.StockMapper;
import com.everis.products.service.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockService;

	@PutMapping("stock/update")
	public UpdateStockResponseDto update(@RequestBody UpdateStockRequestDto updateStockRequestDto)
			throws Exception {
		List<Stock> stockList = stockService.update(updateStockRequestDto);
		UpdateStockResponseDto responseDto = new UpdateStockResponseDto();
		stockList.forEach(stock -> {
			responseDto.setQuantity(responseDto.getQuantity() + stock.getQuantity());
		});
		responseDto.setProductId(updateStockRequestDto.getProductId());
		return responseDto;
	}

	@GetMapping("stock/{productId}")
	public FindByProductoIdDto findById(@PathVariable("productId") Long productId) throws Exception {
		List<Stock> stockList = stockService.findByProductId(productId);
		FindByProductoIdDto response = new FindByProductoIdDto();
		response.setProductId(productId);
		stockList.forEach(stock -> {
			response.setTotal(response.getTotal() + stock.getQuantity());
		});
		return response;
	}

	@PostMapping("stock/")
	public List<SaveStockResponseDto> save(@RequestBody List<SaveStockRequestDto> listRequestDto)
			throws Exception {
		return StockMapper.INSTANCE.toDto(stockService.save(StockMapper.INSTANCE.toEntity(listRequestDto)));
	}
}
