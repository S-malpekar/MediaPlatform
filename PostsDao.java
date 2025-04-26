package com.media.dao;

import java.util.List;
import com.media.entity.Posts;

public interface PostsDao {
	Posts createPost(Posts posts);
	List<Posts> getAllPosts(List<Posts> postsId);
	Posts getPosts(String postsId);
	Posts updatePosts(String postsId, Posts updatedPosts);
	String deletePosts(String postsId);
	String likePost (String postsId);
}
