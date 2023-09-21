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

	// 오류 없애려고 일단 넣어둠 삭제해도 됨
	@Override
	public List<Product> getProductsByNo(String no) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
