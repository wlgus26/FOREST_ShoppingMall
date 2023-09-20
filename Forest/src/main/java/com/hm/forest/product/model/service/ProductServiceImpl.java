package com.hm.forest.product.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.forest.product.model.mapper.ProductMapper;
import com.hm.forest.product.model.vo.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	@Override
	@Transactional
	public int save(Product product) {
		int result = 0;
		
		result = productMapper.insertproduct(product);

		
		return result;
	}

}
