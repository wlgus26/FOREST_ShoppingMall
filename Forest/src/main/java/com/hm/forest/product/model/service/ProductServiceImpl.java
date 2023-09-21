package com.hm.forest.product.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hm.forest.product.model.mapper.ProductMapper;
import com.hm.forest.product.model.vo.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductMapper productMapper;
	
	@Override
	public List<Product> getProductsByNo(String no) {
		
		return productMapper.selectAllNo(no);
	}

}
