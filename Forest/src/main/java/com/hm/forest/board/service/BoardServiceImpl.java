package com.hm.forest.board.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.forest.board.model.mapper.BoardMapper;
import com.hm.forest.board.model.vo.Board;
import com.hm.forest.common.util.PageInfo;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	// 게시판 타입별 게시글 전체 개수
	@Override
	public int selectBoardCountByType(String type) {
		return boardMapper.selectBoardCountByType(type);
	}

	// 게시판 타입별 게시글 전체 목록 조회
	@Override
	public List<Board> getBoardLists(String type, PageInfo pageInfo) {
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		
		RowBounds bounds = new RowBounds(offset, limit);
		
		return boardMapper.selectBoardListsByType(type, bounds);
	}
	
	// [검색값 o] 게시판 타입별 게시글 전체 개수
	@Override
	public int selectBoardCountBySearchValue(String type, String searchType, String keyWord) {
		return boardMapper.selectBoardCountBySearchValue(type, searchType, keyWord);
	}
	
	// [검색값 o] 게시판 타입별 게시글 전체 목록 조회
	@Override
	public List<Board> getBoardListsBySearchValue(String type, PageInfo pageInfo, String searchType, String keyWord) {
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		
		RowBounds bounds = new RowBounds(offset, limit);
		
		return boardMapper.selectBoardListsBySearchValue(type, bounds, searchType, keyWord);
	}

	// 특정 게시글 조회
	@Override
	public Board getBoardByNo(int no) {
		return boardMapper.selectBoardByNo(no);
	}

	// 게시글 등록
	@Override
	@Transactional
	public int save(Board board) {
		int result = 0;
		
		if (board.getNo() > 0) {
			// update
			result = boardMapper.updateBoard(board);
		} else {
			// insert
			result = boardMapper.insertBoard(board);
		}	
		return result;
	}

	// 게시글 삭제
	@Override
	@Transactional
	public int delete(int no) {
		return boardMapper.updateStatus(no, "N");
	}

	// 게시글 조회수 업데이트
	@Override
	@Transactional
	public int updateReadCount(int no) {
		return boardMapper.updateReadCount(no);
	}




}
