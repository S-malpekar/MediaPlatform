package com.media.dao;

import java.util.List;
import com.media.entity.SocialGrps;


public interface GroupsDao {
	SocialGrps createGroup(SocialGrps Groups);
	List<SocialGrps> getAllGroups();
	SocialGrps getGroup(String grp_Id);
	SocialGrps updateGroup(String grp_Id, SocialGrps updatedGroups);
	String deleteGroup(String grp_Id);
    String addMember(String grp_Id, String memberName);
	String removeMember(String grp_Id, String memberName);
}
