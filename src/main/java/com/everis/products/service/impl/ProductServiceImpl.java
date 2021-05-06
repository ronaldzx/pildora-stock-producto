package com.everis.products.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.products.entity.Product;
import com.everis.products.entity.ProductType;
import com.everis.products.repository.ProductRepository;
import com.everis.products.repository.ProductTypeRepository;
import com.everis.products.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Override
	public List<Product> listAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public List<Product> findByPriceLessThan(Double price) {
		return productRepository.findByPriceLessThan(price);
	}

	@Override
	public List<Product> customFindByPrice(Double price, String character) {
		return productRepository.findProductByPriceLessThanAndNameStartingWith(price, character);
	}

	@Override
	public Product findById(Long id) throws Exception {
		return productRepository.findById(id)
				.orElseThrow(() -> new Exception());
	}

	@Override
	public Product save(Product product,String code) throws Exception {
		ProductType result=productTypeRepository.findProductTypeByCode(code);
		if(result==null){
			throw new Exception("This product type is not registered");
		}
		if(product.getPrice() <= 0D) {
			throw new Exception("Product price cannot be 0 or less");
		}
		product.setActive(Boolean.TRUE);
		product.setProductType(result);
		return productRepository.save(product);
	}
}
