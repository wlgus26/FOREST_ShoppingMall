package com.hm.forest.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.product.model.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productmapper;

	@Override
	@Transactional
	public List<Product> getlistProduct(String type) {
		
		
		return productmapper.listProduct(getlistProduct(Product));
	}


}
