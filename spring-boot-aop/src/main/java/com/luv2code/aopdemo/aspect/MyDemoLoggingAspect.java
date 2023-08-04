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

    // create a pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter() {}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter() {}

    // create a pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}

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
    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method");

    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }

}
