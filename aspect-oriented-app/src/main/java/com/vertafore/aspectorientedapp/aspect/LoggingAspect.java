package com.vertafore.aspectorientedapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("within(com.vertafore.aspectorientedapp.service.*)")
    public void logService() {
        LOGGER.info("Service is being called");
    }

    @Around("execution(* com.vertafore.aspectorientedapp.model.Triangle.*(..))")
    public Object logTriangle(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("Triangle is about to be called...");

        Object result = joinPoint.proceed();

        LOGGER.info("Triangle has finished being called");

        return result;
    }

    @After("this(com.vertafore.aspectorientedapp.model.Hexagon)")
    public void logHexagon() {
        LOGGER.info("Hexagon has been called");
    }
}
