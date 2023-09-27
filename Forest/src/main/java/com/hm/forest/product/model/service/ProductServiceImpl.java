package com.hm.forest.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.forest.product.model.vo.Products;
import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.common.util.PageInfo;
import com.hm.forest.product.model.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productmapper;

	@Override
	public List<Products> getProducts() {
		
		return productmapper.listProduct();
	}



	@Override
	public List<Products> getProductList(PageInfo pageInfo) {
		
		return productmapper.selectAll();
	}


	@Override
	public List<Products> datailProduct(int no) {
		
		return productmapper.listProduct();
	}



	@Override
	public List<Products> selectProductByNo(int no) {
		
		return ProductMapper.selectProductByNo( no);
	}



	
	
	// ------------------------
	

//
//	@Override
//	public Products getProductsById(int no) {
//
//		return productmapper.findById(no);
//	}

}
