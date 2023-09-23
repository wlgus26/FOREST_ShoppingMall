package com.hm.forest.board.service;

import java.util.List;

import com.hm.forest.board.model.vo.Board;
import com.hm.forest.common.util.PageInfo;

public interface BoardService {

	List<Board> getBoardLists(String bType, PageInfo pageInfo);

	int selectBoardCountByType(String bType);

	Board getBoardByNo(int no);

	int save(Board board);

}
