package com.media.service_impl;

import java.util.List;
import com.media.dao.*;
import com.media.dao_impl.*;
import com.media.entity.*;
import com.media.service.*;

// FriendsService Implementation
public class FriendsService_impl implements FriendsService {
    FriendsDao friendsDao = new FriendsDao_impl();

    @Override
    public Friends createFriend(Friends friend) {
        return friendsDao.createFriends(friend);
    }

    @Override
    public List<Friends> getAllFriends(String userId) {
        return friendsDao.getAllFriends(userId);
    }
    
    @Override
    public String removeFriend(String friendId) {
        return friendsDao.removeFriend(friendId);
    }

	@Override
	public Friends updateFriend(String friendId, String friend ,Friends updatedFriend) {
		// TODO Auto-generated method stub
		return friendsDao.updateFriend( friendId, friend, updatedFriend);
	}
}
