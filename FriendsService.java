package com.media.service;

import java.util.List;
import com.media.entity.Friends;

public interface FriendsService {
	Friends createFriend(Friends friend);
    List<Friends> getAllFriends(String userId);
	String removeFriend(String friendId);
	Friends updateFriend(String friendId, String friend ,Friends updatedFriend);
}

