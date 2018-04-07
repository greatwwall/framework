package com.xujun.ssh.dao;

import com.xujun.ssh.base.BaseDAO;
import com.xujun.ssh.pojo.RoleModule;

public interface RoleModuleDAO extends BaseDAO<RoleModule, Integer>{

	RoleModule queryRoleModuleByRoleIdAndModuleId(Integer roleId,Integer moduleId);
}
