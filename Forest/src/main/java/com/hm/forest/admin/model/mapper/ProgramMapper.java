package com.hm.forest.admin.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.hm.forest.admin.model.vo.Program;

@Mapper
public interface ProgramMapper {

	// 관리자_클래스 수정
	int updateProgram(Program program);

	// 관리자_클래스 등록 
	int insertProgram(Program program);

	// 관리자_클래스 리스트
	int selectProgramBoardCount();

	// 관리자_클래스 리스트
	List<Program> selectAll(RowBounds rowBounds);

}
