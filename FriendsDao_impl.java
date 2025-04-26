package com.media.dao_impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.media.HibernateUtil.HibernateUtil;
import com.media.dao.FriendsDao;
import com.media.entity.Friends;
import com.media.entity.User;

public class FriendsDao_impl implements FriendsDao {

	@Override
	public Friends createFriends(Friends friend) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(friend);
			session.getTransaction().commit();
			return friend;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return friend;
	}

	@Override
	public List<Friends> getAllFriends(String userId) {
	    List<Friends> friendList = new ArrayList<>();

	    try (Session session = HibernateUtil.getSession()) {
	        Query<Friends> query = session.createQuery(
	            "FROM Friends f WHERE f.user_Id1 = :userId OR f.user_Id2 = :userId", Friends.class);
	        query.setParameter("userId", userId);
	        friendList = query.list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return friendList;
	}

	@Override
	public Friends updateFriend(String friendId, String friend ,Friends updatedFriend) {
		try (Session session = HibernateUtil.getSession()) {
			Friends friend1 = session.get(Friends.class, friendId);
			if (friend1 != null) {
				session.beginTransaction();
				friend1.setStatus(updatedFriend.getStatus());
				friend1.setFollow(updatedFriend.getFollow());
				session.saveOrUpdate(friend1);
				session.getTransaction().commit();
			}
			return friend1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updatedFriend;
	}

		
	 @Override
	    public String removeFriend(String friendId) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSession()) {
	            transaction = session.beginTransaction();
	            
	            Friends friendship = session.createQuery("FROM Friends f WHERE f.friendId = :friendId", Friends.class)
	                    .setParameter("friendId", friendId)
	                    .uniqueResult();
	            
	            if (friendship != null) {
	                session.delete(friendship);
	                transaction.commit();
	                return "Friend removed successfully.";
	            } else {
	                return "Friendship not found.";
	            }
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	            return "Error removing friend.";
	        }
	    }
	

		  
		}



