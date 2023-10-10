package com.hm.forest.admin.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.forest.admin.model.mapper.AdminMapper;
import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.common.util.PageInfo;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	

	// 관리자_제품 등록, 수정
	@Override
	@Transactional
	public int save(Product product) {
		int result = 0;
		
		if (product.getNo() > 0) {
			// update
			result = adminMapper.updateProduct(product);
		} else {
			// insert
			result = adminMapper.insertProduct(product);
		}

		return result;
	}


	// 관리자_제품목록 리스트 
	@Override
	public int getProductBoardCount() {
		
		
		return adminMapper.selectProductBoardCount();
	}

	
	// 관리자_제품 전체 목록 조회
	@Override
	public List<Product> getProductBoardList(PageInfo pageInfo) {
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return adminMapper.selectAll(rowBounds);
	}

	// 관리자_특정 제품 조회
	@Override
	public Product getProductBoardByNo(int no) {
		
		return adminMapper.selectProductBoardByNo(no);
	}


	// 관리자_제품삭제
	@Override
	public int delete(int no) {
		
		return adminMapper.updateProductStatus(no, "N");
	}



	// 제품 리스트 카테고리별로 전체 목록 조회
	@Override
	public List<Product> getProductBoardList(String category, PageInfo pageInfo) {
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return adminMapper.selectProductListByCategory(category ,rowBounds);
		
	}

    
	// 제품 목록 카테고리별 리스트 전체 개수
	@Override
	public int getProductBoardCountByCategory(String category) {
		
		return adminMapper.selectProductCountByCategory(category);
	}


}
