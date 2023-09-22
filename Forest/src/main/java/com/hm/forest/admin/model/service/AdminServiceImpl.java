package com.hm.forest.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.forest.admin.model.mapper.AdminMapper;
import com.hm.forest.admin.model.vo.Product;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;

	@Override
	@Transactional
	public int save(Product product) {
		int result = 0;
		
		result = adminMapper.insertProduct(product);

		
		return result;
	}

	@Override
	public int delete(Product product) {
		int result = 0;
		
		result = adminMapper.deleteProduct(product);
		return 0;
	}

	@Override
	public List<Product> getProductLists() {
		
		return adminMapper.selectAll();
	}

}
