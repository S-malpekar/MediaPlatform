package com.media.service_impl;

import java.util.List;
import com.media.dao.*;
import com.media.dao_impl.*;
import com.media.entity.Posts;
import com.media.service.PostsService;

public class PostsService_impl implements PostsService {
    PostsDao postsDao = new PostsDao_impl();

    @Override
    public Posts createPost(Posts posts) {
        return postsDao.createPost(posts);
    }

    @Override
    public List<Posts> getAllPosts(List<Posts> postsId) {
        return postsDao.getAllPosts(postsId);
    }

    @Override
    public Posts getPost(String postsId) {
        return postsDao.getPosts(postsId);
    }

    @Override
    public Posts updatePost(String postsId, Posts updatedPosts) {
        return postsDao.updatePosts(postsId, updatedPosts);
    }

    @Override
    public String deletePost(String postsId) {
        return postsDao.deletePosts(postsId);
    }
}
