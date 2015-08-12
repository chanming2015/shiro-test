package com.shequ2.xms.authority.aop;

import org.apache.shiro.aop.AnnotationResolver;
import org.apache.shiro.authz.aop.AuthorizingAnnotationMethodInterceptor;

public class MyAdminUserAnnotationMethodInterceptor extends AuthorizingAnnotationMethodInterceptor {

    public MyAdminUserAnnotationMethodInterceptor() {
        super( new MyAdminUserAnnotationHandler() );
    }

    public MyAdminUserAnnotationMethodInterceptor(AnnotationResolver resolver) {
        super(new MyAdminUserAnnotationHandler(), resolver);
    }
}
