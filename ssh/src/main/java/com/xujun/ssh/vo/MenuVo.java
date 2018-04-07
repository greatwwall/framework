package com.xujun.ssh.vo;

public class MenuVo {
	
	private Integer menuId;
	private Integer parentId;
	private String menuName;
	private String prompt;
	private String menuUrl;
	private Boolean checked = false;
	public MenuVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuVo(Integer menuId, Integer parentId, String menuName,
			String prompt) {
		super();
		this.menuId = menuId;
		this.parentId = parentId;
		this.menuName = menuName;
		this.prompt = prompt;
	}
	public MenuVo(Integer menuId, Integer parentId, String menuName,
			String prompt,String menuUrl) {
		super();
		this.menuId = menuId;
		this.parentId = parentId;
		this.menuName = menuName;
		this.prompt = prompt;
		this.menuUrl = menuUrl;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
}
