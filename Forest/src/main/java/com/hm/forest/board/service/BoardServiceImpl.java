package com.hm.forest.board.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.forest.board.model.mapper.BoardMapper;
import com.hm.forest.board.model.vo.Board;
import com.hm.forest.common.util.PageInfo;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;

	// 게시글 목록 조회
	@Override
	public List<Board> getBoardLists(String type, PageInfo pageInfo) {
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		
		RowBounds bounds = new RowBounds(offset, limit);
		
		return boardMapper.selectBoardListsByType(type, bounds);
	}

	// 게시글 개수
	@Override
	public int selectBoardCountByType(String type) {
		return boardMapper.selectBoardCountByType(type);
	}
	

}
