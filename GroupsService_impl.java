package com.media.service_impl;

import java.util.List;
import com.media.dao.*;
import com.media.dao_impl.*;
import com.media.entity.SocialGrps;
import com.media.service.GroupsService;

public class GroupsService_impl implements GroupsService {
    GroupsDao groupsDao = new GroupsDao_impl();

    @Override
    public SocialGrps createGroup(SocialGrps Groups) {
        return groupsDao.createGroup(Groups);
    }

    @Override
    public List<SocialGrps> getAllGroups() {
        return groupsDao.getAllGroups();
    }

    @Override
    public SocialGrps getGroup(String grp_Id) {
        return groupsDao.getGroup(grp_Id);
    }

    @Override
    public SocialGrps updateGroup(String groupId, SocialGrps updatedGroups) {
        return groupsDao.updateGroup(groupId, updatedGroups);
    }

    @Override
    public String deleteGroup(String grp_Id) {
        return groupsDao.deleteGroup(grp_Id);
    }

    @Override
    public String addMember(String grp_Id, String memberName) {
        return groupsDao.addMember(grp_Id, memberName);
    }

    @Override
    public String removeMember(String grp_Id, String memberName) {
        return groupsDao.removeMember(grp_Id, memberName);
    }
}
   

