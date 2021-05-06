package com.everis.products.service;

import java.util.List;

import com.everis.products.entity.Product;

public interface ProductService {
	public List<Product> listAll();
	
	public List<Product> findByPriceLessThan(Double price);
	
	public List<Product> customFindByPrice(Double price, String character);

	public Product findById(Long id) throws Exception;

	public Product save(Product product,String code) throws Exception;
}
