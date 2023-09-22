package com.hm.forest.product.model.service;

import java.util.List;

import com.hm.forest.product.model.vo.Product;

public interface ProductService {
	
	List<Product> getProductsByNo(String no);
}
