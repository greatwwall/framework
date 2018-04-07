package com.xujun.ssh.intercepter;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.xujun.ssh.commons.annotation.Permission;
import com.xujun.ssh.commons.annotation.Permissions;

@Component
public class PowerIntercepter extends AbstractInterceptor{

	private static final long serialVersionUID = -539842505618662622L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//得到目标 action
		Object target = invocation.getAction();
		//得到目标类的class
		Class<?> clazz = target.getClass();
		//得到代理类
		ActionProxy proxy = invocation.getProxy();
		//得到目标的方法
		String methodName = proxy.getMethod();
		//得到 名空间
		//得到action的访问路径
		String uri = this.getUri(proxy);
		
		//得到session
		Map<String,Object> session = ActionContext.getContext().getSession();
		//得到登录后的授权
		@SuppressWarnings("unchecked")
		Map<String,Integer> powers = (Map<String, Integer>) session.get("powers");
		//得到授权码
		Integer keyCode = powers==null?null:powers.get(uri);
		
		//得到方法
		Method method = clazz.getDeclaredMethod(methodName);
		
		//判断该action上是否有权限注解
		if(hasAnnotation(clazz,Permissions.class)){
			Permissions permissions = clazz.getAnnotation(Permissions.class);
			Permission permission = permissions.value();
			//判断方法上面的注解
			if(hasAnnotation(method, Permissions.class)){
				permissions = method.getAnnotation(Permissions.class);
				permission = permissions.value();
				
			}
			//判断执行权限
			if(hasPermission(permission, keyCode)){
				invocation.invoke();
			}else{
				return "nopower";
			}
		}else{
			if(hasAnnotation(method, Permissions.class)){
				Permissions permissions = method.getAnnotation(Permissions.class);
				Permission permission = permissions.value();
				if(hasPermission(permission, keyCode)){
					invocation.invoke();
				}else{
					return "nopower";
				}
			}else{
				return "nopower";
			}
		}
		return null;
	}

	
	private boolean hasPermission(Permission permission,Integer code){
		boolean hasPermission = false;
		int powercode = permission.getCode();
		switch (powercode) {
		case -1:
			hasPermission = true;
			break;
		case 0:
			hasPermission = false;
			break;
		default:
			if(code!=null){
				hasPermission = ((powercode & code) == powercode)?true:false;
			}else{
				hasPermission = false;
			}
			break;
		}
		return hasPermission;
	}
	
	private boolean hasAnnotation(AnnotatedElement ae,Class<? extends Annotation> annotation){
		return ae.isAnnotationPresent(annotation);
	}
	
	private String getUri(ActionProxy proxy){
		String namespace = proxy.getNamespace();
		String actionName = proxy.getActionName();
		if(StringUtils.hasLength(namespace)){
			namespace = namespace.substring(1)+"/";
		}
		return namespace+actionName;
		
	}
}
