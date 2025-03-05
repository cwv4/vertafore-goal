package com.vertafore.aspectorientedapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfilingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilingAspect.class);

    @Pointcut("@annotation(Profilable)")
    public void executeProfiling() {
    }

    @Around(value = "executeProfiling()")
    public Object profileMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        Object returnValue = joinPoint.proceed();
        long totalTime = System.nanoTime() - startTime;

        String message = "Total time to run method [" + joinPoint.getSignature().getName() + "] was: " + totalTime + " nanoseconds.";
        LOGGER.info(message);

        return returnValue;
    }

}
