package com.lifeisbeautiful.shareyourthoughts.api;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CommentEntity {

	@Id @GeneratedValue
	private long commentId;
	
	private String content;
	
	private UserEntity user;
	
	private Date createTime;

}
