package com.hm.forest.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.forest.product.model.vo.Products;
import com.hm.forest.product.model.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productmapper;

	@Override
	public List<Products> getProducts() {
		
		return productmapper.listProduct();
	}

	
	
	
}
