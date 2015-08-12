package com.shequ2.xms.authority;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.shequ2.xms.entity.SystemUser;
import com.shequ2.xms.entity.UserBase;
import com.shequ2.xms.service.AuthorityService;
import com.shequ2.xms.service.PasswordService;
import com.shequ2.xms.service.SystemUserService;
import com.shequ2.xms.unit.Result;

public class UserRealm extends AuthorizingRealm {
	@Autowired private SystemUserService systemUserService;
	@Autowired private AuthorityService authorityService;
	@Autowired private PasswordService passwordService;
	
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(authorityService.getRoles(username));
        authorizationInfo.setStringPermissions(authorityService.getPermissions(username));
//        System.out.println(authorityService.getPermissions(username));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char [])token.getCredentials());
        UserBase user;
        // 先尝试后台登录
        Result<SystemUser> userResult = systemUserService.getSystemUser(username);
        user = userResult.success() ? userResult.getObject() : null;

        if (user == null) {
            throw new UnknownAccountException();//没找到帐号或账号已删除，通常还需要检查用户状态阻止禁用的用户登录
        }
        
        // 验证密码
        if(!user.getPassword().equals(passwordService.encryptPassword(password, username, user.getSalt()))){
        	throw new IncorrectCredentialsException();
        }
        
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", user);
//        session.setAttribute("userRoles", authorityService.getRoles(username));
        
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getLoginName(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getLoginName() + user.getSalt()),//salt=username+salt, 与PasswordHelper.encryptPassword对应
                getName()  //realm name
        );
        
        return authenticationInfo;
    }
}
