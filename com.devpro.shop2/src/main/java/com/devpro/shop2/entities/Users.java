package com.devpro.shop2.entities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="tbl_users")
public class Users extends BaseEntity implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3482246771970621918L;

	@Column(name="username", length = 45, nullable = false)
	private String username;
	
	@Column(name="password",length=100,nullable=false)
	private String password;
	
	@Column(name="email",length=45,nullable=false)
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	private Set<Saleorder> saleorder = new HashSet<Saleorder>() ;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")
	private List<Roles> roles = new ArrayList<Roles>();
	
	public void addSaleOrder(Saleorder saleOrder) {
		saleorder.add(saleOrder);
		saleOrder.setUser(this);
	}
	
	public void deleteSaleOrder(Saleorder saleOrder) {
		saleorder.remove(saleOrder);
		saleOrder.setUser(null);
	}
	public void addRoles(Roles role) {
		role.getUsers().add(this);
		roles.add(role);
	}
	
	public void deleteRole(Roles role) {
		roles.remove(role);
		role.setUsers(null);
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	//danh sách role của user
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Set<Saleorder> getSaleorder() {
		return saleorder;
	}

	public void setSaleorder(Set<Saleorder> saleorder) {
		this.saleorder = saleorder;
	}
	
	
}
