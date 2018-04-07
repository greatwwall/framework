package com.xujun.ssh.action;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.xujun.ssh.commons.annotation.Permission;
import com.xujun.ssh.commons.annotation.Permissions;
import com.xujun.ssh.pojo.Role;
import com.xujun.ssh.service.RoleModuleService;
import com.xujun.ssh.service.RoleService;

@Controller
@Scope("prototype")
public class RoleAction {

    private List<Role> roles = new ArrayList<Role>();

    private Role role;

    private Integer userId;

    private Integer[] menuIds;

    private Integer moduleId;

    private Integer powerCode;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleModuleService roleModuleService;

    /**
     * 查询所有角色
     * 
     * @return
     */
    @Permissions(Permission.QUERY)
    public String findAll() {
        this.roles = this.roleService.findAll();
        return "findAll";
    }

    /**
     * 查询所有角色 并返回json数据 用于登录页面
     * 
     * @return
     */
    @Permissions(Permission.WITHOUT)
    public String findAllOfLoginToJson() {
        this.roles = this.roleService.findAllOfLoginToJson();
        return "findAllOfLoginToJson";
    }

    /**
     * 查询所有角色 用于用户管理里面分配角色
     * 
     * @return
     */
    @Permissions(Permission.QUERY)
    public String findAllOfDistribute() {
        findAll();
        return "findAllOfDistribute";
    }

    // 分配菜单
    @Permissions(Permission.UPDATE)
    public String distributeMenu() {
        this.roleService.distributeMenu(role.getRoleId(), menuIds);
        return "distributeMenu";
    }

    // 分配模块
    @Permissions(Permission.UPDATE)
    public void distributeModule() {
        this.roleModuleService.updatePermission(role.getRoleId(), moduleId, powerCode);
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(Integer[] menuIds) {
        this.menuIds = menuIds;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getPowerCode() {
        return powerCode;
    }

    public void setPowerCode(Integer powerCode) {
        this.powerCode = powerCode;
    }
}
