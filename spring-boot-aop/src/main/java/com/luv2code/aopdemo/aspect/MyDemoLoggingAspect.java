package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    /*
        Pointcut are used to reuse pointcut expressions

        The method name is the pointcut expression. In this case 'forDaoPackage'.
     */
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

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
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method");

    }



}
