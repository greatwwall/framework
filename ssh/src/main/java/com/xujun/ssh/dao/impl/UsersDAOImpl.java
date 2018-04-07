package com.xujun.ssh.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;
import com.xujun.ssh.base.impl.BaseDAOImpl;
import com.xujun.ssh.dao.UsersDAO;
import com.xujun.ssh.pojo.Role;
import com.xujun.ssh.pojo.Users;


@Repository
public class UsersDAOImpl extends BaseDAOImpl<Users, Integer> implements UsersDAO {

	@Override
	public Users queryByUname(String uname) {
		String hql = "from Users u where u.uname=:uname";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uname", uname);
		return get(hql, params);
	}

	@Override
	public List<Role> queryRoleInUser(Integer userId) {
		Users users = get(userId);
		Set<Role> roles = users.getRoles();
		return new ArrayList<Role>(roles);
	}

}
