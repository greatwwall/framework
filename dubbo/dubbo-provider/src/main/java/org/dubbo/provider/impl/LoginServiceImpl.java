package org.dubbo.provider.impl;

import java.util.ArrayList;
import java.util.List;

import org.dubbo.api.service.LoginService;

/**
 * @author xujun
 * @date 2018年9月4日 下午2:21:56
 */
public class LoginServiceImpl implements LoginService {

	@Override
	public List<String> getPremissions(Long id) {
		List<String> result = new ArrayList<>();
		result.add(String.format("Permission_%d", id - 1));
		result.add(String.format("Permission_%d", id));
		result.add(String.format("Permission_%d", id + 1));
		return result;
	}

	@Override
	public String validate(String input) {
		return input + " validated.";
	}

}
