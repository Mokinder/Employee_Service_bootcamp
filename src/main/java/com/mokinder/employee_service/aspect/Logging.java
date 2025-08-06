package com.mokinder.employee_service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class Logging {

    private static final Logger log = LoggerFactory.getLogger(Logging.class);

    @Pointcut("execution(* com.mokinder.employee-service.Service.*.*(..))")
    private void anyOldTransfer() {}

    @Around("anyOldTransfer()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("");
        Object result = joinPoint.proceed();
        log.info("");
        return result;
    }

}
