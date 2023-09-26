package com.hm.forest.member.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Member {
	
	private int no;
	
	@NonNull
	private String id;
	
	@NonNull
	private String password;
	
	@NonNull
	private String name;
	
	private String phone;
	
	private String email;
	
	private String pcode;

	private String address1;
	
	private String address2;
	
	private String status;
	
	private Date createDate;
	
	private Date updateDate;
}