package com.everis.products.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.everis.products.dto.UpdateStockRequestDto;
import com.everis.products.entity.Stock;
import com.everis.products.repository.StockRepository;
import com.everis.products.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<Stock> findByProductId(Long id) throws Exception {
		List<Stock> list = stockRepository.findByProductId(id);
		if (CollectionUtils.isEmpty(list)) {
			throw new Exception("Product not found");
		}
		return list;
	}

	@Override
	public List<Stock> save(List<Stock> stocks) throws Exception {
		for (Stock stock : stocks) {
			if (stock == null || stock.getQuantity() == 0) {
				throw new Exception("Quantity cannot be 0 or less");
			}
		}
		return stockRepository.saveAll(stocks);
	}

	@Override
	public List<Stock> update(UpdateStockRequestDto updateStockRequestDto) throws Exception {
		Integer quotient = 0;
		Integer module = 0;
		Integer total = updateStockRequestDto.getQuantity();
		if (updateStockRequestDto.getQuantity() <= 0) {
			throw new Exception("Quantity cannot be 0 or less");
		}
		List<Stock> stockList = stockRepository.findByProductId(updateStockRequestDto.getProductId());

		quotient = total / stockList.size();
		module = total % stockList.size();

		if (quotient != 0) {
			for (Stock stock : stockList) {
				stock.setQuantity(stock.getQuantity() + quotient);
			}
		}
		if (module != 0) {
			for (int i = 0; i < module; i++) {
				stockList.get(i).setQuantity(stockList.get(i).getQuantity() + 1);
			}
		}

		return stockRepository.saveAll(stockList);

	}
}
