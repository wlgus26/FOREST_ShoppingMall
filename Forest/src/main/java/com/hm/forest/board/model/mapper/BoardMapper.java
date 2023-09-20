package com.hm.forest.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hm.forest.board.model.vo.Board;

@Mapper
public interface BoardMapper {

	List<Board> findAll(@Param("type") String type);

}
