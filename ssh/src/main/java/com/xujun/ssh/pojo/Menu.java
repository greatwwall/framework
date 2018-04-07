package com.xujun.ssh.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "crm_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = -1667692571643862249L;

    private Integer menuId;

    private String menuName;

    private String menuUrl;

    private String prompt;

    private Integer menuLevel;

    private Menu parent;

    private Set<Menu> children;

    private Set<Role> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Column(name = "menu_name")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Column(name = "menu_url")
    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Column(name = "prompt")
    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    @Column(name = "menu_level")
    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id")
    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent")
    public Set<Menu> getChildren() {
        return children;
    }

    public void setChildren(Set<Menu> children) {
        this.children = children;
    }

    @ManyToMany(mappedBy = "menus")
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
