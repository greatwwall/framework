package com.xujun.ssh.service;

import java.util.List;
import com.xujun.ssh.pojo.Role;
import com.xujun.ssh.pojo.Users;

public interface UsersService {

	Users findByUname(String uname);
	List<Users> findAll();
	List<Role> findAllRoleInUser(Integer userId);
	void distributeRole(Integer userId, Integer[] roleIds);

}
