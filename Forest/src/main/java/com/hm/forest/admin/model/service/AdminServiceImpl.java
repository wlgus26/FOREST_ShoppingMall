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

	@Override
	@Transactional
	public int save(Product product) {
		int result = 0;
		
		result = adminMapper.insertProduct(product);

		
		return result;
	}

//	@Override
//	public int delete(Product product) {
//		int result = 0;
//		
//		result = adminMapper.deleteProduct(product);
//		return 0;
//	}


	@Override
	public int delete(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getProductBoardCount() {
		
		
		return adminMapper.selectProductBoardCount();
	}

	@Override
	public List<Product> getProductBoardList(PageInfo pageInfo) {
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return adminMapper.selectAll(rowBounds);
	}

	@Override
	public Product getProductBoardByNo(int no) {
		
		return adminMapper.selectProductBoardByNo(no);
	}


}
