package com.xujun.ssh.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.xujun.ssh.commons.annotation.Permission;
import com.xujun.ssh.commons.annotation.Permissions;
import com.xujun.ssh.pojo.Role;
import com.xujun.ssh.pojo.Users;
import com.xujun.ssh.service.UsersService;

@Controller
@Scope("prototype")
public class UsersAction {

	private List<Users> users;
	private List<Role> roles = new ArrayList<Role>();
	
	private Integer []roleIds;
	
	private Users user;
	
	@Autowired
	private UsersService usersService;
	
	/**
	 * 查询所有
	 * @return
	 */
	@Permissions(Permission.QUERY)
	public String findAll(){
		this.users = this.usersService.findAll();
		return "findAll";
	}
	//根据用户查询该用户所持有的角色
	@Permissions(Permission.QUERY)
	public String findAllRoleInUserToJson(){
		if(user!=null && user.getUserId()!=null){
			this.roles = this.usersService.findAllRoleInUser(user.getUserId());
		}
		return "findAllRoleInUserToJson";
	}
	
	//分配角色  拥有更新权限
	@Permissions(Permission.UPDATE)
	public String distributeRole(){
		this.usersService.distributeRole(user.getUserId(),roleIds);
		return "distributeRole";
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Integer[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Integer[] roleIds) {
		this.roleIds = roleIds;
	}
}
