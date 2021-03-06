package com.everis.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.products.entity.Stock;


@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	List<Stock> findByProductId(Long idProducto);

}
