package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
    @Order: Defines the execution order of the aspects, starting by the lowest order
*/
@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with a @Before advice
    /*
        pointcut expression example:
            "execution(public void addAccount())"

        Run this code BEFORE - target object method: "public void addAccount()"

        It matches addAccount() method in any class
     */
    /*
        using forDaoPackage pointcut.
     */
    /*
        Use the fully qualified class name (package + class) to access pointcuts declared in other classes
     */
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method");

    }

}
