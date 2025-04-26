package com.media.dao_impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.media.HibernateUtil.HibernateUtil;
import com.media.dao.PostsDao;
import com.media.entity.Posts;

public class PostsDao_impl implements PostsDao {

	@Override
	public Posts createPost(Posts posts) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(posts);
			session.getTransaction().commit();
			return posts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posts;
	}

	@Override
	public List<Posts> getAllPosts(List<Posts> postsId) {
		try (Session session = HibernateUtil.getSession()) {
			Query<Posts> query = session.createQuery("FROM Posts", Posts.class);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return postsId;
	}

	@Override
	public Posts getPosts(String postsId) {
		try (Session session = HibernateUtil.getSession()) {
			return session.get(Posts.class, postsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Posts updatePosts(String postsId, Posts updatedPosts) {
		try (Session session = HibernateUtil.getSession()) {
			Posts posts = session.get(Posts.class, postsId);
			if (posts != null) {
				session.beginTransaction();
				posts.setContent(updatedPosts.getContent());
				posts.setLikes_count(updatedPosts.getLikes_count());
				posts.setComments(updatedPosts.getComments());
				session.saveOrUpdate(posts);
				session.getTransaction().commit();
			}
			return posts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updatedPosts;
	}

	@Override
	public String deletePosts(String postsId) {
		try (Session session = HibernateUtil.getSession()) {
			Posts posts = session.get(Posts.class, postsId);
			if (posts != null) {
				session.beginTransaction();
				session.delete(posts);
				session.getTransaction().commit();
				return "Post deleted successfully";
			}
			return "Post not found";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error deleting post";
	}

	@Override
	public String likePost(String postsId) {
		Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        Posts post = session.get(Posts.class, postsId);
        post.setLikes_count(post.getLikes_count() + 1);

        session.update(post);
        tx.commit();
        session.close();
		return postsId;
		}
	
}
