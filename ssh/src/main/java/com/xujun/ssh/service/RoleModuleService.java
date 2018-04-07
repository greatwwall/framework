package com.xujun.ssh.service;

import java.util.Map;

public interface RoleModuleService {

	void updatePermission(Integer roleId, Integer moduleId, Integer powerCode);

	Map<Integer, Integer> findPermissionInRole(Integer roleId);
}
