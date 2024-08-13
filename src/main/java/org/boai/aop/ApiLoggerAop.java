package org.boai.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class ApiLoggerAop {

    @Around("execution(public * org.boai.controller..*.*(..))")
    public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Object retObj;
        String hostName = request.getHeader("host");
        String url = request.getRequestURL().toString();
        log.info("{} : {}", hostName, url);
        retObj = joinPoint.proceed();
        log.info("{} completed, now={}", url, new Date());
        return retObj;
    }
}
