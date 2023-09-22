package com.hm.forest.admin.model.service;

import com.hm.forest.admin.model.vo.Product;

public interface AdminService {
	
	int save(Product product);

	int delete(Product product);

}
