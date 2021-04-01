package com.hr.hrserver.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("com.hr.hrserver.aop.PointCuts.inController()")
    public Object controllerExeTimeAdvice(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        String className = pjp.getSignature().getDeclaringTypeName();
        String methodName = pjp.getSignature().getName();
        Object result = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("ClassName: "+className);
        System.out.println("MethodName: "+methodName);
        System.out.println("Result: "+result);

        System.out.println(className+"."+methodName+" execution time: "+elapsedTime+" ms");
        return result;

    }

    @Around("com.hr.hrserver.aop.PointCuts.executionDan()")
    public Object daoExeTimeAdvice(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        String className = pjp.getSignature().getDeclaringTypeName();
        String methodName = pjp.getSignature().getName();
        Object result = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("ClassName: "+className);
        System.out.println("MethodName: "+methodName);
        System.out.println("Result: "+result);

        System.out.println(className+"."+methodName+" execution time: "+elapsedTime+" ms");
        return result;

    }

    @AfterReturning(value = "bean(houseController)", returning = "res")
    public void afterReturningAdvice(Object res){
        System.out.println("After Returning: " + res.toString());
    }
}



//    @Before
//    try{
//        return res;
//        @AfterReturning
//    }
//    catch(){
//        @AfterThrowing
//    }finally(){
//        @After
//    }
