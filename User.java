package com.media.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "user")
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_Id", length = 10)
	private String UserId;

	@Column(name = "Username", length = 10)
	private String Username;

	@Column(name = "Email", length = 30)
	private String Email;

	@Column(name = "Password", length = 16)
	private String Password;

	@Column(name = "full_name", length = 30)
	private String full_name;

	@Column(name = "Age", length = 3)
	private int age;

	@Column(name = "Gender", length = 7)
	private String gender;

	@Column(name = "Location", length = 20)
	private String location;

	@Column(name = "Post_count", length = 7)
	private int post_count;

	@OneToMany(mappedBy = "user")
	private List<Posts> posts;

	@ManyToMany
	@JoinTable(
			name = "user_group_map",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "group_id")
			)
	private List<SocialGrps> groups;
	
	@OneToMany(mappedBy = "creator")
	private List<SocialGrps> createdGroups;

	@ManyToMany(mappedBy = "members")
	private List<SocialGrps> memberGroups;


	@OneToMany(mappedBy = "sender")
	private List<Messages> sentMessages;

	@OneToMany(mappedBy = "receiver")
	private List<Messages> receivedMessages;


	@ManyToMany
	@JoinTable(
			name = "user_friends",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "friend_id")
			)
	private List<User> friends;





	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPost_count() {
		return post_count;
	}

	public void setPost_count(int post_count) {
		this.post_count = post_count;
	}

	// add getter & setter for posts
	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}

	public List<SocialGrps> getGroups() {
		return groups;
	}

	public void setGroups(List<SocialGrps> groups) {
		this.groups = groups;
	}

	public List<Messages> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<Messages> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public List<Messages> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(List<Messages> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}




	public User(String userId, String username, String email, String password, String full_name, int age, String gender,
			String location, int post_count) {
		super();
		UserId = userId;
		Username = username;
		Email = email;
		Password = password;
		this.full_name = full_name;
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.post_count = post_count;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", Username=" + Username + ", Email=" + Email + ", Password=" + Password
				+ ", full_name=" + full_name + ", age=" + age + ", gender=" + gender + ", location=" + location
				+ ", post_count=" + post_count + "]";
	}




}
