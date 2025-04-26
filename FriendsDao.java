package com.media.dao;

import java.util.List;
import com.media.entity.Friends;


public interface FriendsDao {
	Friends createFriends(Friends Friends);
	List<Friends> getAllFriends(String userId); // Fetch all friends of a specific user
	String removeFriend(String friendId);
	Friends updateFriend(String friendId, String friend ,Friends updatedFriend);
	
}
