package com.media.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Posts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "posts_Id", length = 10)
	private String postsId;

	@Column(name = "User_Id", length = 10)
	private String UserId;

	@Column(name = "Content", length = 500)
	private String Content;

	@Column(name = "Comments", length = 100)
	private String Comments;

	@Column(name = "Views", length = 10)
	private int Views;

	@Column(name = "Likes_count", length = 10)
	private int Likes_count;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;





	public String getPosts_Id() {
		return postsId;
	}

	public void setPosts_Id(String posts_Id) {
		this.postsId = posts_Id;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public int getViews() {
		return Views;
	}

	public void setViews(int views) {
		Views = views;
	}

	public int getLikes_count() {
		return Likes_count;
	}

	public void setLikes_count(int likes_count) {
		Likes_count = likes_count;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

	public Posts(String posts_Id, String userId, String content, String comments, int views, int likes_count) {
		super();
		postsId = posts_Id ;
		UserId = userId;
		Content = content;
		Comments = comments;
		Views = views;
		Likes_count = likes_count;
	}

	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Posts [posts_Id=" + postsId + ", UserId=" + UserId + ", Content=" + Content + ", Comments=" + Comments
				+ ", Views=" + Views + ", Likes_count=" + Likes_count + "]";
	}




}
