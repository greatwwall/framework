package com.xujun.ssh.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.xujun.ssh.commons.annotation.Permission;
import com.xujun.ssh.commons.annotation.Permissions;
import com.xujun.ssh.pojo.Module;
import com.xujun.ssh.service.ModuleService;
import com.xujun.ssh.service.RoleModuleService;

@Controller
@Scope("prototype")
public class ModuleAction {

	
	private List<Module> modules;
	private Integer roleId;
	
	private Map<Integer,Integer> permission = new HashMap<Integer,Integer>();
	
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private RoleModuleService roleModuleService;
	
	/**
	 * 查询所有
	 * @return
	 */
	@Permissions(Permission.QUERY)
	public String findAll(){
		this.modules = this.moduleService.findAll();
		return "findAll";
	}

	//查询所有  用于角色里面分配模块
	@Permissions(Permission.QUERY)
	public String findAllOfDistribute(){
		findAll();
		this.permission = this.roleModuleService.findPermissionInRole(roleId);
		return "findAllOfDistribute";
	}
	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Map<Integer, Integer> getPermission() {
		return permission;
	}

	public void setPermission(Map<Integer, Integer> permission) {
		this.permission = permission;
	}
	
}
