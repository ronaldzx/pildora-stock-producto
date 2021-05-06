package com.everis.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.products.dto.ProductDto;
import com.everis.products.dto.ProductFindByPriceDto;
import com.everis.products.dto.ProductSaveRequestDto;
import com.everis.products.dto.ProductSaveResponseDto;
import com.everis.products.mapper.ProductMapper;
import com.everis.products.service.ProductService;

@RestController
public class ProductController {

	@Autowired 
	private ProductService productService;

	@GetMapping("product/list")
	public List<ProductDto> list() {
		return ProductMapper.INSTANCE.map(productService.listAll());
	}

	@GetMapping("product/{id}")
	public ProductDto findById(@PathVariable("id") Long id) throws Exception {
		return ProductMapper.INSTANCE.map(productService.findById(id));
	}

	@PostMapping("product/save")
	public ProductSaveResponseDto save(@RequestBody ProductSaveRequestDto productSaveRequestDto) throws Exception {
		return ProductMapper.INSTANCE
				.toProductSaveResponseDto(productService.save(ProductMapper.INSTANCE.toEntity(productSaveRequestDto ),productSaveRequestDto.getProductType()));
	}
	
	@GetMapping("product/customPriceLessThan10")
	public List<ProductFindByPriceDto> listProductWithPriceLessThan10(){
		return ProductMapper.INSTANCE.toProductFindByPriceDto(productService.customFindByPrice(10D, "G"));
	}
}
