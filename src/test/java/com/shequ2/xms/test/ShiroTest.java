/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.shequ2.xms.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Project:shiro-test
 * Package:com.shequ2.xms.shiro_test
 * FileName:ShiroTest.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年8月6日 上午9:47:52
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public class ShiroTest {

	@Test
	public void testHelloworld() {
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<SecurityManager> factory = new  IniSecurityManagerFactory("classpath:shiro.properties");
		//2、得到SecurityManager实例 并绑定给SecurityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		try {
			//4、登录，即身份验证
			subject.login(new UsernamePasswordToken("zhang", "123"));
		} catch (AuthenticationException e) {
			//5、身份验证失败 
			e.printStackTrace();
		}
		Assert.assertTrue(subject.hasRole("role1")); //断言用户是否拥有角色
		Assert.assertTrue(subject.isPermitted("user:select")); //断言用户是否拥有权限
		Assert.assertEquals(1, subject.getPrincipals().asList().size());// //得到一个身份集合，其包含了Realm验证成功的身份信息 
		Assert.assertTrue(subject.isAuthenticated()); //断言用户已经登录  
		String str = "hello";
		Assert.assertEquals(str, Base64.decodeToString(Base64.encode(str.getBytes())));
		//6、退出  
		subject.logout();
	}

}
