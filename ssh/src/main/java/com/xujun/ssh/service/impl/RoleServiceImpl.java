package com.xujun.ssh.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.xujun.ssh.dao.MenuDAO;
import com.xujun.ssh.dao.RoleDAO;
import com.xujun.ssh.dao.RoleModuleDAO;
import com.xujun.ssh.pojo.Menu;
import com.xujun.ssh.pojo.Role;
import com.xujun.ssh.pojo.RoleModule;
import com.xujun.ssh.service.RoleService;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private MenuDAO menuDAO;
    @Autowired
    private RoleModuleDAO roleModuleDAO;

    @Override
    public List<Role> findAll() {
        return this.roleDAO.find();
    }

    @Override
    public List<Role> findAllOfLoginToJson() {
        return this.roleDAO.find();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void distributeMenu(Integer roleId, Integer[] _ids) {
        Role role = this.roleDAO.get(roleId);
        role.getMenus().clear();
        if (_ids.length > 0) {
            @SuppressWarnings("unchecked")
            List<Menu> menus = this.menuDAO.buildQuery("from Menu m where m.menuId in (:ids)")
                    .setParameterList("ids", _ids).list();
            role.getMenus().addAll(menus);
        }
        this.roleDAO.update(role);
    }

    @Override
    public List<Menu> findMenuByRoleId(Integer roleId) {
        Role role = this.roleDAO.get(roleId);
        return new ArrayList<Menu>(role.getMenus());
    }

    @Override
    public Map<String, Integer> findPermissionByRoleId(Integer roleId) {
        @SuppressWarnings("unchecked")
        List<RoleModule> rms =
                this.roleModuleDAO.buildQuery("from RoleModule rm where rm.role.roleId=:roleId")
                        .setParameter("roleId", roleId).list();
        Map<String, Integer> powers = new HashMap<String, Integer>();
        for (RoleModule rm : rms) {
            powers.put(rm.getModule().getModuleUrl(), rm.getPowerCode());
        }
        return powers;
    }

}
