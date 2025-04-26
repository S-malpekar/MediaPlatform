package com.media.dao_impl;

import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.media.HibernateUtil.HibernateUtil;
import com.media.dao.GroupsDao;
import com.media.entity.SocialGrps;

public class GroupsDao_impl implements GroupsDao {

	@Override
	public SocialGrps createGroup(SocialGrps groups) {
	    try (Session session = HibernateUtil.getSession()) {
	        session.beginTransaction();
	        session.save(groups);
	        session.flush(); // Ensure changes go to DB
	        session.getTransaction().commit();
	        System.out.println("Group successfully created: " + groups);
	        return groups;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null; // Return null if creation fails
	}


	@Override
	public List<SocialGrps> getAllGroups() {
	    try (Session session = HibernateUtil.getSession()) {
	        Query<SocialGrps> query = session.createQuery("FROM SocialGrps", SocialGrps.class);
	        return query.list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return Collections.emptyList(); // Return an empty list instead of null
	}


	@Override
	public SocialGrps getGroup(String grp_Id) {
		try (Session session = HibernateUtil.getSession()) {
			return session.get(SocialGrps.class, grp_Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SocialGrps updateGroup(String grp_Id, SocialGrps updatedGroups) {
		try (Session session = HibernateUtil.getSession()) {
			SocialGrps group = session.get(SocialGrps.class, grp_Id);
			if (group != null) {
				session.beginTransaction();
				group.setGrp_name(updatedGroups.getGrp_name());
				group.setCreate_by(updatedGroups.getCreate_by());
				group.setDesc(updatedGroups.getDesc());
				group.setMembers(updatedGroups.getMembers());
				session.saveOrUpdate(group);
				session.getTransaction().commit();
			}
			return group;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updatedGroups;
	}

	@Override
	public String deleteGroup(String grp_Id) {
		try (Session session = HibernateUtil.getSession()) {
			SocialGrps group = session.get(SocialGrps.class, grp_Id);
			if (group != null) {
				session.beginTransaction();
				session.delete(group);
				session.getTransaction().commit();
				return "Group deleted successfully";
			}
			return "Group not found";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error deleting group";
	}

	
	
	 @Override
	    public String addMember(String grp_Id, String memberName) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSession()) {
	        	SocialGrps group = session.get(SocialGrps.class, grp_Id);
	            if (group == null) {
	                return "Group not found.";
	            }
	            session.beginTransaction();
	            String currentMembers = group.getMembers();
	            if (currentMembers != null && currentMembers.contains(memberName)) {
	                return "Member already exists in the group.";
	            }
	            // Append new member (Using comma as separator)
	            String updatedMembers = (currentMembers == null || currentMembers.isEmpty()) 
	                                      ? memberName 
	                                      : currentMembers + "," + memberName;
	            group.setMembers(updatedMembers);
	            session.update(group);
	            session.getTransaction().commit();
	            return "Member added successfully.";
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	            return "Error adding member.";
	        }
	    }

	    @Override
	    public String removeMember(String grp_Id, String memberName) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSession()) {
	        	SocialGrps group = session.get(SocialGrps.class, grp_Id);
	            if (group == null) {
	                return "Group not found.";
	            }
	            session.beginTransaction();
	            String currentMembers = group.getMembers();
	            if (currentMembers == null || !currentMembers.contains(memberName)) {
	                return "Member not found in the group.";
	            }
	            // Remove member using comma separation
	            String updatedMembers = String.join(",", currentMembers.split(","))
	                    .replace(memberName, "")
	                    .replaceAll(",+", ",")
	                    .replaceAll("^,|,$", "");
	            group.setMembers(updatedMembers);
	            session.update(group);
	            session.getTransaction().commit();
	            return "Member removed successfully.";
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	            return "Error removing member.";
	        }
	    }
}
