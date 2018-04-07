package com.xujun.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.xujun.ssh.commons.annotation.Permission;
import com.xujun.ssh.commons.annotation.Permissions;
import com.xujun.ssh.pojo.Menu;
import com.xujun.ssh.service.MenuService;
import com.xujun.ssh.service.RoleService;
import com.xujun.ssh.vo.MenuVo;

@Controller
@Scope("prototype")
public class MenuAction {
	
	private List<Menu> menus;
	
	private List<MenuVo> menuVos = new ArrayList<MenuVo>();
	
	private Integer roleId;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private RoleService roleService;
	
	//查询全部
	@Permissions(Permission.QUERY)
	public String findAll(){
		this.menus = this.menuService.findAll(); 
		return "findAll";
	}
	
	/**
	 * 查询全部  并返回json数据
	 * @return
	 */
	@Permissions(Permission.WITHOUT)
	@SuppressWarnings("unchecked")
    public String findAllInRoleToJson(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		//得到已有的菜单
		this.menus = (List<Menu>) session.get("menus");
		for(Menu menu:menus){
			int parent = 0;
			if(menu.getParent()!=null){
				parent = menu.getParent().getMenuId();
			}
			MenuVo menuVo = new MenuVo(menu.getMenuId(),parent,menu.getMenuName(),menu.getPrompt());
			menuVo.setMenuUrl(menu.getMenuUrl());
			menuVos.add(menuVo);
		}
		return "findAllInRoleToJson";
	}
	
	/**
	 * 查询所有菜单  用于在角色里面分配菜单使用
	 * @return
	 */
	@Permissions(Permission.QUERY)
	public String findAllOfDistributeToJson(){
		//得到已有的菜单
		findAll();
		List<Menu> ms = this.roleService.findMenuByRoleId(roleId);
		for(Menu menu:menus){
			int parent = 0;
			if(menu.getParent()!=null){
				parent = menu.getParent().getMenuId();
			}
			MenuVo menuVo = new MenuVo(menu.getMenuId(),parent,menu.getMenuName(),menu.getPrompt());
			for(Menu m:ms){
				if(m.getMenuId() == menu.getMenuId()){
					menuVo.setChecked(true);
				}
			}
			menuVos.add(menuVo);
		}
		return "findAllOfDistributeToJson";
	}
	
	//用于返回分配页面
	@Permissions(Permission.QUERY)
	public String findAllOfDistribute(){
		return "findAllOfDistribute";
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<MenuVo> getMenuVos() {
		return menuVos;
	}

	public void setMenuVos(List<MenuVo> menuVos) {
		this.menuVos = menuVos;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
