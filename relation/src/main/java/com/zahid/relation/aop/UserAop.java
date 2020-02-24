package com.zahid.relation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
//@EnableAspectJAutoProxy()
public class UserAop {

    @Before(value = "execution(* com.zahid.relation.service.UserService.createUser()) && args(name)")
    public void beforeUserCreate(JoinPoint joinPoint, String name) {
        System.out.println("Before method:" + joinPoint.getSignature());
        System.out.println("Creating user with name: "+ name);
    }

    @After(value = "execution(* com.zahid.relation.service.UserService.createUser()) && args(name)")
    public void AfterUserCreate(JoinPoint joinPoint, String name) {
        System.out.println("After method:" + joinPoint.getSignature());
        System.out.println("Created user with name: "+ name);
    }
}
