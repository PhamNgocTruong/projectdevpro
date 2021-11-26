package com.devpro.shop2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="tbl_roles")
public class Roles extends BaseEntity implements GrantedAuthority{
	@Column(name="name",length=45,nullable=false)
	private String name;
	
	@Column(name="description",length=45,nullable=false)
	private String description;

	@ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_users_roles", 
			   joinColumns = @JoinColumn(name = "role_id"), 
			   inverseJoinColumns = @JoinColumn(name = "user_id"))	
	private List<Users> users = new ArrayList<Users>(); 
	
	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getAuthority() {
		return name;
	}

	
	
	
}
