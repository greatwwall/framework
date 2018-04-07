package com.xujun.ssh.commons.annotation;

/**
 * 权限枚举类
 * @author Administrator
 *
 */
public enum Permission {

	WITHOUT(-1),	//不需要权限
	NONE(0),		//没有权限
	QUERY(1),		//查询权限
	CREATE(2),		//创建权限
	UPDATE(4),		//更新权限
	DELETE(8);		//删除权限
	
	private int code;
	
	private Permission(int code){
		this.code = code;
	}
	
	public int getCode(){
		return this.code;
	}
}
