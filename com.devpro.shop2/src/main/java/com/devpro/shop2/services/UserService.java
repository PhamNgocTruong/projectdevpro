package com.devpro.shop2.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devpro.shop2.entities.Category;
import com.devpro.shop2.entities.Users;

@Service
public class UserService extends BaseServices<Users>{
	
	
	@Override
	protected Class<Users> clazz() {
		return Users.class;
	}
	
	public Users loadUserByUsername(String userName) {
		String sql = "select*from tbl_users u where u.username= '" + userName + "'";
		List<Users> users = this.executeNativeSql(sql, -1);
		if(users == null||users.size()<=0) return null;
		return  users.get(0);
	}
	
	public List<Users> findAll(){
		String sql ="select*from tbl_users where status =1";
		return super.executeNativeSql(sql,-1);
	}
	
	@Transactional
	public  Users edit(Users users) throws Exception {
		//lay category tu database
		Users userOnDb= super.getById(users.getId());
		
		return super.saveOrUpdate(users);
	}
	
	@Transactional
	public  Users save(Users users) throws Exception {
		
		return super.saveOrUpdate(users);
	}

}
