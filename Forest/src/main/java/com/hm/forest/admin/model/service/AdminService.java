package com.hm.forest.admin.model.service;

import java.util.List;

import com.hm.forest.admin.model.vo.Product;

public interface AdminService {
	
	int save(Product product);

	int delete(Product product);

	List<Product> getProductLists();

}
