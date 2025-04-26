package com.media.service;

import java.util.List;

import com.media.entity.SocialGrps;
import com.media.entity.User;

public interface GroupsService {
	SocialGrps createGroup(SocialGrps Groups);
	SocialGrps getGroup(String grp_Id);
	SocialGrps updateGroup(String grp_Id, SocialGrps updatedGroups);
	String deleteGroup(String grp_Id);
	String removeMember(String grp_Id, String memberName);
	List<SocialGrps> getAllGroups();
	String addMember(String grp_Id, String memberName);
	 	
}

