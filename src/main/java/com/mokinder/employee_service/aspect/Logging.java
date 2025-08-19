package com.mokinder.employee_service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    private static final Logger log = LoggerFactory.getLogger(Logging.class);

    @Pointcut("execution(* com.mokinder.employee_service.*.*.*(..))")
    private void logserviceMethods() {}

    @Around("logserviceMethods()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Entering method: {}", joinPoint.getSignature().toShortString());
        Object result = null;
        try {
            result = joinPoint.proceed();
            log.info("Exiting method: {} with result: {}", joinPoint.getSignature().toShortString(), result);
        } catch (Exception e) {
            log.error("Exception in method: {}", joinPoint.getSignature().toShortString(), e);
            throw e;
        }
        return result;
    }

}
