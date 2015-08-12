/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.shequ2.xms.entity;

import javax.persistence.MappedSuperclass;

/**
 * Project:c2-domain
 * Package:com.qingbo.c2.entity
 * FileName:UserBase.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年8月6日 下午3:37:36
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@MappedSuperclass
@SuppressWarnings("serial")
public class UserBase extends BaseEntity {

	protected String loginName;			// 登录名
	protected String password;			// 密码
	protected String salt;				// 盐
	
	/**
	 * Author XuMaoSen
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * Author XuMaoSen
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * Author XuMaoSen
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Author XuMaoSen
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Author XuMaoSen
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * Author XuMaoSen
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

}
