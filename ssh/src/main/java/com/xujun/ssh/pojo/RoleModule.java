package com.xujun.ssh.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "crm_role_module")
public class RoleModule {

    private Integer rmId;

    private Role role;

    private Module module;

    private Integer powerCode;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rm_id")
    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToOne
    @JoinColumn(name = "module_id")
    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Column(name = "power_code")
    public Integer getPowerCode() {
        return powerCode;
    }

    public void setPowerCode(Integer powerCode) {
        this.powerCode = powerCode;
    }
}
