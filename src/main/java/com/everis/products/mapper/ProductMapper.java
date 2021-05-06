package com.everis.products.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.everis.products.dto.ProductDto;
import com.everis.products.dto.ProductFindByPriceDto;
import com.everis.products.dto.ProductSaveRequestDto;
import com.everis.products.dto.ProductSaveResponseDto;
import com.everis.products.dto.ProductTypeDto;
import com.everis.products.entity.Product;
import com.everis.products.entity.ProductType;



@Mapper(componentModel = "spring")
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	public ProductDto map(Product product);

	@Mapping(source = "product.name", target = "nombre")
	@Mapping(source = "product.description", target = "descripcion")
	@Mapping(source = "product.price", target = "precio")
	public ProductFindByPriceDto toProductFindByPriceDto(Product product);
	
	public List<ProductDto> map (List<Product> products);

	public ProductTypeDto toProductTypeDto (ProductType productType);
	
	public List<ProductFindByPriceDto> toProductFindByPriceDto(List<Product> products);

	@Mapping(target="productType",ignore=true)
	public Product toEntity(ProductSaveRequestDto productSaveRequestDto);

	public ProductSaveResponseDto toProductSaveResponseDto(Product product);

	@AfterMapping
	default void setRemainingValues(Product product, @MappingTarget ProductDto productoDto) {
		productoDto.setStatus(Boolean.TRUE.equals(product.getActive()) ? "Active" : "Inactive");
	}
	
	@AfterMapping
	default void setEstadoActivo(Product product, @MappingTarget ProductFindByPriceDto productoDto) {
		productoDto.setEstado(Boolean.TRUE.equals(product.getActive()) ? "Habilitado" : "Inhabilitado");
	}
}
