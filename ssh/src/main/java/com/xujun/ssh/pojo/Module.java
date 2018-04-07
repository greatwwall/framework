package com.xujun.ssh.pojo;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "crm_module")
public class Module {

    private Integer moduleId;

    private String moduleName;

    private String moduleUrl;

    private Set<RoleModule> rms;

    @OneToMany(mappedBy = "module")
    public Set<RoleModule> getRms() {
        return rms;
    }

    public void setRms(Set<RoleModule> rms) {
        this.rms = rms;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "module_id")
    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    @Column(name = "module_name")
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Column(name = "module_url")
    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

}
