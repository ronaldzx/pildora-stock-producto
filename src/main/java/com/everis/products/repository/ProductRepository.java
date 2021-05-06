package com.everis.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.products.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByPriceLessThan(Double price);

	List<Product> findProductByPriceLessThanAndNameStartingWith(Double price, String character);
}
