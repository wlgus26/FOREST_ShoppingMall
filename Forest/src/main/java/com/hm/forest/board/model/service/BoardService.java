package com.hm.forest.board.model.service;

import java.util.List;

import com.hm.forest.board.model.vo.Board;
import com.hm.forest.board.model.vo.Reply;
import com.hm.forest.common.util.PageInfo;

public interface BoardService {

	// 게시판 타입별 게시글 전체 목록 조회
	List<Board> getBoardLists(String type, PageInfo pageInfo);

	// 게시판 타입별 게시글 전체 개수
	int selectBoardCountByType(String type);

	// [검색값 o] 게시판 타입별 게시글 전체 목록 조회
	List<Board> getBoardListsBySearchValue(String type, PageInfo pageInfo, String searchType, String keyWord);

	// [검색값 o] 게시판 타입별 게시글 전체 개수
	int selectBoardCountBySearchValue(String type, String searchType, String keyWord);

	// 특정 게시글 조회
	Board getBoardByNo(int no);

	// 게시글 등록
	int save(Board board);

	// 게시글 삭제
	int delete(int no);

	// 게시글 조회수 업데이트
	int updateReadCount(int no);

	// 댓글 등록
	int save(Reply reply);

	// 댓글 조회
	List<Reply> getRepliesByBoardNo(int boardNo);

	// 댓글 수
	int selectReplyCountByBoardNo(int boardNo);

	// 특정 댓글 조회
	Reply getReplyByNo(int no);

	// 댓글 삭제
	int deleteReply(int no);




}
