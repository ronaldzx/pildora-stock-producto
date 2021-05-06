package com.everis.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.products.entity.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
	ProductType findProductTypeByCode(String code);
}
