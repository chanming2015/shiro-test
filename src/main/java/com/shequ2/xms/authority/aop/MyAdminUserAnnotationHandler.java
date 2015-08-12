package com.shequ2.xms.authority.aop;

import java.lang.annotation.Annotation;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.aop.AuthorizingAnnotationHandler;

import com.shequ2.xms.authority.RequiresAdminUser;
import com.shequ2.xms.authority.ShiroTool;


public class MyAdminUserAnnotationHandler extends AuthorizingAnnotationHandler {
    public MyAdminUserAnnotationHandler() {
        super(RequiresAdminUser.class);
    }
    public void assertAuthorized(Annotation a) throws AuthorizationException {
        if(!(a instanceof RequiresAdminUser)) return;
        
        if(ShiroTool.isAdminAuthenticated()==false)
        	throw new UnauthorizedException("user does not have an admin role");
    }
}
