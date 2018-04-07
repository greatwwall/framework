package com.xujun.ssh.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.xujun.ssh.base.impl.BaseDAOImpl;
import com.xujun.ssh.dao.RoleModuleDAO;
import com.xujun.ssh.pojo.RoleModule;


@Repository
public class RoleModuleDAOImpl extends BaseDAOImpl<RoleModule, Integer> implements RoleModuleDAO {

	@Override
	public RoleModule queryRoleModuleByRoleIdAndModuleId(Integer roleId,Integer moduleId) {
		// TODO Auto-generated method stub
		Query query = this.buildQuery("from RoleModule rm where rm.role.roleId=:roleId and rm.module.moduleId=:moduleId");
		query.setParameter("roleId", roleId);
		query.setParameter("moduleId", moduleId);
		return (RoleModule)query.uniqueResult();
	}

	

}
