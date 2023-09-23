package com.hm.forest.product.model.service;

import java.util.List;

import com.hm.forest.product.model.vo.Products;
import com.hm.forest.common.util.PageInfo;

public interface ProductService {


	List<Products> getProducts();


	int datailProduct(Products products);


	List<Products> datailProduct();

}
