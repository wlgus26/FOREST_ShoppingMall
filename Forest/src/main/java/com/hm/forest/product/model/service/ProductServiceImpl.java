package com.hm.forest.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.common.util.PageInfo;
import com.hm.forest.product.model.mapper.ProductMapper;
import com.hm.forest.product.model.vo.Products;

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
	public Products getProductByNo1(int no) {
		// TODO Auto-generated method stub
		return productmapper.selectProductByNo(no);
	}
	
	
	@Override
	public Products selectProductByNo(int no) {
		
		return productmapper.selectProductByNo(no);
	}



	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productmapper.getAllProducts();
	}	
	
	
	






//	    @Override
//	    public Products getProductByNo(int no) {
//	        return dao.getProductByNo(no);
//	    }
	
	
	


	
//	public List<Products> selectProductByNo(int no) {
//		
//		return productmapper.selectProductByNo();
//	}



	
	
	// ------------------------
	

//
//	@Override
//	public Products getProductsById(int no) {
//
//		return productmapper.findById(no);
//	}

}
