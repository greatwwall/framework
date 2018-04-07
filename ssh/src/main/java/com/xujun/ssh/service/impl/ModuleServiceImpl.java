package com.xujun.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xujun.ssh.dao.ModuleDAO;
import com.xujun.ssh.pojo.Module;
import com.xujun.ssh.service.ModuleService;

@Service
@Transactional(readOnly=true)
public class ModuleServiceImpl implements ModuleService {

	
	@Autowired
	private ModuleDAO moduleDAO;
	
	@Override
	public List<Module> findAll() {
		return this.moduleDAO.find();
	}

}
