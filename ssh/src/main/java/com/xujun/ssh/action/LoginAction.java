package com.xujun.ssh.action;

import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.xujun.ssh.commons.annotation.Permission;
import com.xujun.ssh.commons.annotation.Permissions;
import com.xujun.ssh.pojo.Role;
import com.xujun.ssh.pojo.Users;
import com.xujun.ssh.service.RoleService;
import com.xujun.ssh.service.UsersService;

@Controller
@Scope("prototype")
@Permissions(Permission.WITHOUT)
public class LoginAction {

    private static Logger logger = Logger.getLogger(LoginAction.class);
    // 用户名
    private String username;
    // 密码
    private String password;
    // 验证码
    private String valicode;
    // 错误信息
    private String error;

    private Integer roleId;

    @Autowired
    private UsersService usersService;

    @Autowired
    private RoleService roleService;

    /**
     * 登录
     * 
     * @return
     */
    public String login() {
        logger.info("login start.");
        Map<String, Object> session = ActionContext.getContext().getSession();
        Object rand = session.get("rand");
        logger.info("rand : " + rand.toString());
        if (rand != null) {
            if (rand.toString().equalsIgnoreCase(valicode)) {
                // 登录 当登录不成功的时候 则返回 登录界面
                if (StringUtils.hasLength(username)) {
                    Users users = this.usersService.findByUname(username);
                    if (users != null) {
                        boolean have = false;
                        Set<Role> role = users.getRoles();
                        for (Role r : role) {
                            if (r.getRoleId() == roleId) {
                                have = true;
                                break;
                            }
                        }
                        if (have && users.getPwd() != null && users.getPwd().equals(password)) {
                            session.put("admin", users);
                            session.put("menus", this.roleService.findMenuByRoleId(roleId));
                            session.put("powers", this.roleService.findPermissionByRoleId(roleId));
                            return "main";
                        }
                        this.error = "角色错误,请重试!";
                        return "login";
                    }
                }
                this.error = "用户名或密码错误,请重试!";
                return "login";
            } else {
                this.error = "验证码错误,请重试!";
                return "login";
            }
        }
        this.error = "验证码已过期,请刷新重试!";
        return "login";
    }

    /**
     * 退出
     * 
     * @return
     */
    public String logout() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.invalidate();
        return "logout";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValicode() {
        return valicode;
    }

    public void setValicode(String valicode) {
        this.valicode = valicode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
