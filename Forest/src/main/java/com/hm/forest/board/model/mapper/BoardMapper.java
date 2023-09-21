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

	// 게시글 목록 수 카운트
	int selectBoardCountByType(@Param("type") String type);

	// 게시글 전체 목록 조회
	List<Board> selectBoardListsByType(@Param("type") String type, RowBounds bounds);


}
