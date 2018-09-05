package org.dubbo.api.service;

import java.util.List;

/**
 * @author xujun
 * @date 2018年9月4日 下午2:19:09
 */
public interface LoginService {

	List<String> getPremissions(Long id);

	String validate(String input);
}
