package com.hm.forest.board.service;

import java.util.List;

import com.hm.forest.board.model.vo.Board;

public interface BoardService {

	List<Board> getBoardLists(String type);

}
