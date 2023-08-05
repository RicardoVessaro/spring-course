package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/*
    Pointcut util class.

    If you only have poincuts then @Aspect is optional.
    Only required if you add advices in this class:
        @Before, @After, etc

    You can add just in case you add advices to this class in the future
 */
/*
    Public pointcut expressions are decorations accessed by advices
 */
@Aspect
public class LuvAopExpressions {

    /*
        Pointcut are used to reuse pointcut expressions

        The method name is the pointcut expression. In this case 'forDaoPackage'.
     */
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    public void getter() {}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // create a pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
