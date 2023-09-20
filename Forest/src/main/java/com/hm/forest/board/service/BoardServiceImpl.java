package com.hm.forest.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.forest.board.model.mapper.BoardMapper;
import com.hm.forest.board.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<Board> getBoardLists(String type) {
		return boardMapper.findAll(type);
	}
	

}
