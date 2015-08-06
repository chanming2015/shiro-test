/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.shequ2.xms.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * Project:shiro-test
 * Package:com.shequ2.xms.test
 * FileName:MyRealm1.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年8月6日 上午11:07:52
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public class MyRealm2 implements Realm {

	/** @author XuMaoSen 
	 */
	public String getName() {

		return "myRealm2";
	}

	/** @author XuMaoSen 
	 */
	public boolean supports(AuthenticationToken token) {

		return token instanceof UsernamePasswordToken;
	}

	/** @author XuMaoSen 
	 */
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		
		String username = (String) token.getPrincipal();
		String password = new String((char [])token.getCredentials()) ;
		if(!"wang".equals(username)){
			throw new UnknownAccountException();
		}
		if(!"123".equals(password)){
			throw new IncorrectCredentialsException();
		}
		return new SimpleAccount(username, password, getName());
	}

}
