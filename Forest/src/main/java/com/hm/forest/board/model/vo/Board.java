package com.hm.forest.board.model.vo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@Builder // SQL 사용시 파라미터에 값을 쉽게 넣어주는 @
@ToString // 객체의 값 확인을 위한 @
@Entity(name = "board")
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	private int rowNum;
	
	private String type;
	
	private int writerNo;
	
	private String writerId;
	
	private String title;
	
	private String content;
	
	private String content2;
	
	private String originalFilename; 
	
	private String renamedFilename;
	
	private int readCount;
	
	private String status;
	
	private List<Reply> replies;
	
	private Date createDate;
	
	private Date modifyDate;
	
}

