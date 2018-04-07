package com.xujun.ssh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.xujun.ssh.dao.ModuleDAO;
import com.xujun.ssh.dao.RoleDAO;
import com.xujun.ssh.dao.RoleModuleDAO;
import com.xujun.ssh.pojo.RoleModule;
import com.xujun.ssh.service.RoleModuleService;

@Service
@Transactional(readOnly = true)
public class RoleModuleServiceImpl implements RoleModuleService {
	
	@Autowired
	private RoleModuleDAO roleModuleDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private ModuleDAO moduleDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updatePermission(Integer roleId, Integer moduleId,
			Integer powerCode) {
		// TODO Auto-generated method stub
		/**
		 * 进行授权码的计算
		 * 
		 * 
		 * 首先  根据roleId和moduleId在中间表中去查询  如果有相应的记录  则进行修改（包含更新和删除）
		 * 
		 * 进行位运算
		 * 
		 * 判断以前是否包含该权限   如果已经包含 需要 去除   如果不包含  则添加进去
		 * 
		 */
		RoleModule rm = this.roleModuleDAO.queryRoleModuleByRoleIdAndModuleId(roleId, moduleId);
		
		if(rm==null){
			rm = new RoleModule();
			rm.setRole(this.roleDAO.get(roleId));
			rm.setModule(this.moduleDAO.get(moduleId));
			rm.setPowerCode(powerCode);
			
		}else{
			//判断权限是否存在
			Integer power = rm.getPowerCode();
			if((power&powerCode) == powerCode){
				//需要移除权限
				if((power^powerCode) == 0){
					//如果是最后一个权限  则移除该记录
					
					//否则更新
					this.roleModuleDAO.delete(rm);
					return;
				}else{
					rm.setPowerCode(power^powerCode);
				}
			}else{
				rm.setPowerCode(power|powerCode);
			}
		}
		this.roleModuleDAO.saveOrUpdate(rm);
	}

	@Override
	public Map<Integer, Integer> findPermissionInRole(Integer roleId) {
		
		@SuppressWarnings("unchecked")
		List<RoleModule> rms = this.roleModuleDAO.buildQuery("from RoleModule rm where rm.role.roleId=:roleId").setParameter("roleId", roleId).list();
		
		Map<Integer, Integer> permission = new HashMap<Integer, Integer>();
		for(RoleModule rm:rms){
			permission.put(rm.getModule().getModuleId(), rm.getPowerCode());
		}
		return permission;
	}
}
