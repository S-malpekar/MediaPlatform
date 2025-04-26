package com.media.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity

public class SocialGrps {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Grp_Id", length = 10)
	private String Grp_Id;

	@Column(name = "Grp_name", length = 10)
	private String Grp_name;

	@Column(name = "Created_by", length = 10)
	private String Create_by;

	@Column(name = "description", length = 50)
	private String desc;

	@Column(name = "Members", length = 10)
	private String Members;

	@ManyToMany(mappedBy = "groups")
	private List<User> users;

	@ManyToOne
	@JoinColumn(name = "Created_by")
	private User creator;

	@ManyToMany
	@JoinTable(
	    name = "group_members",
	    joinColumns = @JoinColumn(name = "Grp_Id"),
	    inverseJoinColumns = @JoinColumn(name = "User_Id"))
	private List<User> members;




	public String getGrp_Id() {
		return Grp_Id;
	}

	public void setGrp_Id(String grp_Id) {
		Grp_Id = grp_Id;
	}

	public String getGrp_name() {
		return Grp_name;
	}

	public void setGrp_name(String grp_name) {
		Grp_name = grp_name;
	}

	public String getCreate_by() {
		return Create_by;
	}

	public void setCreate_by(String create_by) {
		Create_by = create_by;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMembers() {
		return Members;
	}

	public void setMembers(String members) {
		Members = members;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}



	public SocialGrps(String grp_Id, String grp_name, String create_by, String desc, String members) {
		super();
		Grp_Id = grp_Id;
		Grp_name = grp_name;
		Create_by = create_by;
		this.desc = desc;
		Members = members;
	}



	public SocialGrps() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SocialGrps [Grp_Id=" + Grp_Id + ", Grp_name=" + Grp_name + ", Create_by=" + Create_by + ", desc=" + desc
				+ ", Members=" + Members + "]";
	}

}


