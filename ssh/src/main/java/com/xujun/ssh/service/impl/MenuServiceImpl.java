package com.xujun.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xujun.ssh.dao.MenuDAO;
import com.xujun.ssh.pojo.Menu;
import com.xujun.ssh.service.MenuService;

@Service
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDAO menuDAO;
	
	@Override
	public List<Menu> findAll() {
		return this.menuDAO.find();
	}

}
