package com.xujun.ssh.dao;

import java.util.List;
import com.xujun.ssh.base.BaseDAO;
import com.xujun.ssh.pojo.Role;
import com.xujun.ssh.pojo.Users;

public interface UsersDAO extends BaseDAO<Users, Integer> {

	Users queryByUname(String uname);
	
	List<Role> queryRoleInUser(Integer userId);

}
