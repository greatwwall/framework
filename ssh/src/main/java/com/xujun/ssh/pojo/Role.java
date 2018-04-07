package com.xujun.ssh.pojo;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.struts2.json.annotations.JSON;


@Entity
@Table(name = "crm_role")
public class Role {

    private Integer roleId;

    private String roleName;

    private Set<Users> users;

    private Set<Menu> menus;

    private Set<RoleModule> rms;

    @OneToMany(mappedBy = "role")
    public Set<RoleModule> getRms() {
        return rms;
    }

    public void setRms(Set<RoleModule> rms) {
        this.rms = rms;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @ManyToMany(mappedBy = "roles")
    @JSON(serialize = false)
    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    @ManyToMany
    @JoinTable(name = "crm_role_menu", joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_id")})
    @JSON(serialize = false)
    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
