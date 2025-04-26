package com.media.service;

import java.util.List;
import com.media.entity.Posts;

public interface PostsService {
	Posts createPost(Posts posts);
	List<Posts> getAllPosts(List<Posts> postsId);
	Posts getPost(String postsId);
	Posts updatePost(String postsId, Posts updatedPosts);
	String deletePost(String postsId);
}