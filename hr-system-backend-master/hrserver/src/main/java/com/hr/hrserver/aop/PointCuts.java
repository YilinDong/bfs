package com.hr.hrserver.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCuts {

    @Pointcut("within(com.hr.hrserver.controller..*)")
    public void inController() {}

    @Pointcut("execution(* com.hr.hrserver.dao.*..*(..))")
    public void executionDan() {}

}
