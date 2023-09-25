package com.hm.forest.board.service;

import java.util.List;

import com.hm.forest.board.model.vo.Board;
import com.hm.forest.common.util.PageInfo;

public interface BoardService {

	// 게시글 전체 목록 조회(게시판 타입별로)
	List<Board> getBoardLists(String type, PageInfo pageInfo);

	// 게시글 개수(게시판 타입별로)
	int selectBoardCountByType(String type);

	// 특정 게시글 조회
	Board getBoardByNo(int no);

	// 게시글 등록
	int save(Board board);

	// 게시글 삭제
	int delete(int no);

}
