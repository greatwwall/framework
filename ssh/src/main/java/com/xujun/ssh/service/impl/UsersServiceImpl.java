package com.xujun.ssh.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.xujun.ssh.dao.RoleDAO;
import com.xujun.ssh.dao.UsersDAO;
import com.xujun.ssh.pojo.Role;
import com.xujun.ssh.pojo.Users;
import com.xujun.ssh.service.UsersService;

@Service
@Transactional(readOnly = true)
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private RoleDAO roleDAO;

	@Override
	public Users findByUname(String uname) {
		return this.usersDAO.queryByUname(uname);
	}

	@Override
	public List<Users> findAll() {
		return this.usersDAO.find();
	}

	@Override
	public List<Role> findAllRoleInUser(Integer userId) {
		return this.usersDAO.queryRoleInUser(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void distributeRole(Integer userId, Integer[] roleIds) {
		// TODO Auto-generated method stub
		
		//去后台得到  当前要改变的用户
		
		//然后 将原有的角色数据 清空
		
		//将roleIds所对应的role赋值给该对象
		
		Users users = this.usersDAO.get(userId);
		users.getRoles().clear();
		if(roleIds!=null && roleIds.length>0){
			Query query = roleDAO.buildQuery("from Role r where r.roleId in( :roleIds )");
			query.setParameterList("roleIds", roleIds);
			@SuppressWarnings("unchecked")
			List<Role> roles= (List<Role>)query.list();
			users.getRoles().addAll(roles);
		}
		this.usersDAO.update(users);
	}

}
