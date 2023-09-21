package com.hm.forest.product.service;

import java.util.List;

import com.hm.forest.admin.model.vo.Product;

public interface ProductService {

	com.hm.forest.product.model.vo.Product getlistProduct(String type);

	List<Product> getlistProduct(String type, String product);
}
