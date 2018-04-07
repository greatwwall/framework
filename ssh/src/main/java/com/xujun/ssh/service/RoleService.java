package com.xujun.ssh.service;

import java.util.List;
import java.util.Map;
import com.xujun.ssh.pojo.Menu;
import com.xujun.ssh.pojo.Role;


public interface RoleService {

	List<Role> findAll();

	void distributeMenu(Integer roleId, Integer[] _ids);
	
	List<Menu> findMenuByRoleId(Integer roleId);
	
	Map<String, Integer> findPermissionByRoleId(Integer roleId);

    List<Role> findAllOfLoginToJson();
}
