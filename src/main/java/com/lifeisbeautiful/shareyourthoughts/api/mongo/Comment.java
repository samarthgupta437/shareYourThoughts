package com.lifeisbeautiful.shareyourthoughts.api.mongo;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Comment {
	
	@Id
	private String id;
	private User commentAuthor;
	private String commentDate;
	private String commentContent;
	
	//Getter Setter Start
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getCommentAuthor() {
		return commentAuthor;
	}
	public void setCommentAuthor(User commentAuthor) {
		this.commentAuthor = commentAuthor;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	//Getter Setter Ends


}
