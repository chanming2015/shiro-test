package com.shequ2.xms.entity;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * 系统用户
 */

@Entity
public class SystemUser extends UserBase {
	
	private static final long serialVersionUID = -1819900863679785803L;
	
	private String realName;			// 真实名
	private String mobile;				// 手机号
	private String memo;				// 备注
	private String status;				// 状态
	private String storeCode;			// 所属门店
	
	@Transient private List<Long> roleIds;									// 包含角色ID
	@Transient private List<SystemRole> roles;								// 包含角色
	@Transient private Set<Long> functionIds = new LinkedHashSet<Long>();	// 功能ID集合
	@Transient private List<SystemFunction> functions;						// 功能权限集
	@Transient private String createAtHead;
	@Transient private String createAtTail;
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateAtHead() {
		return createAtHead;
	}
	public void setCreateAtHead(String createAtHead) {
		this.createAtHead = createAtHead;
	}
	public String getCreateAtTail() {
		return createAtTail;
	}
	public void setCreateAtTail(String createAtTail) {
		this.createAtTail = createAtTail;
	}
	public List<SystemRole> getRoles() {
		return roles;
	}
	public void setRoles(List<SystemRole> roles) {
		this.roles = roles;
	}
	public Set<Long> getFunctionIds() {
		return functionIds;
	}
	public void setFunctionIds(Set<Long> functionIds) {
		this.functionIds = functionIds;
	}
	public List<SystemFunction> getFunctions() {
		return functions;
	}
	public void setFunctions(List<SystemFunction> functions) {
		this.functions = functions;
	}
	public List<Long> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
}
