package com.hm.forest.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import com.hm.forest.board.model.vo.Board;
import com.hm.forest.common.util.PageInfo;

@Mapper
public interface BoardMapper {

	// 게시판 타입별 게시글 전체 개수
	int selectBoardCountByType(@Param("type") String type);

	// 게시판 타입별 게시글 전체 목록 조회
	List<Board> selectBoardListsByType(@Param("type") String type, RowBounds bounds);
	
	// [검색값 o] 게시판 타입별 게시글 전체 개수
	int selectBoardCountBySearchValue(@Param("type") String type, @Param("searchType") String searchType,@Param("keyWord") String keyWord);
	
	// [검색값 o] 게시판 타입별 게시글 전체 목록 조회
	List<Board> selectBoardListsBySearchValue(@Param("type") String type, RowBounds bounds, @Param("searchType") String searchType, @Param("keyWord") String keyWord);

	// 특정 게시글 조회
	Board selectBoardByNo(@Param("no") int no);

	// 게시글 등록
	int insertBoard(Board board);

	// 게시글 수정 
	int updateBoard(Board board);

	// 게시글 삭제
	int updateStatus(@Param("no") int no,@Param("status") String status);

	// 게시글 조회수 업데이트
	int updateReadCount(@Param("no") int no);

	// faq 게시판 글 목록 조회
	List<Board> selectFAQListsByType(@Param("type") String type);





}
