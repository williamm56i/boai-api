package org.boai.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PimsAop {

    @Pointcut("@annotation(org.boai.annotation.Pims)")
    public void controllerPointCut() {}

    @Around("controllerPointCut()")
    public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object retObj = joinPoint.proceed();
        log.info("personal data record.");
        return retObj;
    }
}
