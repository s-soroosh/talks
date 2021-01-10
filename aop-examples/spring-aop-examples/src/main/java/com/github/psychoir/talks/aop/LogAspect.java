package com.github.psychoir.talks.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

  @Around("execution(* getHome(..))")
  public Object beforeEndpointCalls(ProceedingJoinPoint pjp) throws Throwable {
    String response = (String) pjp.proceed();
    final String newResponse = response +"<br/>"+ "Trial version watermark";
    return newResponse;
  }
}
