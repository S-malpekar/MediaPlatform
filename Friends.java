package com.media.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Friends {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Friend_Id", length = 10)
	private String friend_Id;

	@Column(name = "User_Id1", length = 10)
	private String UserId1;

	@Column(name = "User_Id2", length = 10)
	private String UserId2;

	@Column(name = "Status", length = 10)
	private String status;

	@Column(name = "Follow", length = 10)
	private String follow;
	
	@ManyToOne
	@JoinColumn(name = "User_Id")
	private User user1;

	@ManyToOne
	@JoinColumn(name = "User_Id")
	private User user2;





	public String getFriend_Id() {
		return friend_Id;
	}

	public void setFriend_Id(String friend_Id) {
		this.friend_Id = friend_Id;
	}

	public String getUserId1() {
		return UserId1;
	}

	public void setUserId1(String userId1) {
		UserId1 = userId1;
	}

	public String getUserId2() {
		return UserId2;
	}

	public void setUserId2(String userId2) {
		UserId2 = userId2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFollow() {
		return follow;
	}

	public void setFollow(String follow) {
		this.follow = follow;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}
	
	

	public Friends(String friend_Id, String userId1, String userId2, String status, String follow) {
		super();
		this.friend_Id = friend_Id;
		UserId1 = userId1;
		UserId2 = userId2;
		this.status = status;
		this.follow = follow;
	}



	public Friends() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Friends [friend_Id=" + friend_Id + ", UserId1=" + UserId1 + ", UserId2=" + UserId2 + ", status="
				+ status + ", follow=" + follow + "]";
	}





}
