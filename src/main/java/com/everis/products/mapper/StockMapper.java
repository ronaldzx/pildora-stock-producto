package com.everis.products.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.everis.products.dto.SaveStockRequestDto;
import com.everis.products.dto.SaveStockResponseDto;
import com.everis.products.entity.Stock;

@Mapper(componentModel = "spring")
public interface StockMapper {

	StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

	public SaveStockResponseDto toDto(Stock source);

	public Stock toEntity(SaveStockRequestDto source);

	public List<SaveStockResponseDto> toDto(List<Stock> source);

	public List<Stock> toEntity(List<SaveStockRequestDto> source);
}
