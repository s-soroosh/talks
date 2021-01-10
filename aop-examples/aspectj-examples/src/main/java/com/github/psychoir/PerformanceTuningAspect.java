package com.github.psychoir;

import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PerformanceTuningAspect {

  private Map<Signature, Long> methodDurations = new HashMap<>();

  public PerformanceTuningAspect() {
    Runtime.getRuntime().addShutdownHook(new Thread(
        () ->
            System.out.println("Method durations are: " + methodDurations))
    );
  }

  @Pointcut("execution(* com.github.psychoir.Calculator.*(..))")
  public void aroundAllCalculatorMethods() {
  }

  @Around("aroundAllCalculatorMethods()")
  public Object measureExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
    final var start = System.nanoTime();
    final var result = pjp.proceed();
    final var end = System.nanoTime();
    final var duration = end - start;
    methodDurations.computeIfPresent(pjp.getSignature(), (s, d) -> d + duration);
    methodDurations.putIfAbsent(pjp.getSignature(), duration);
    return result;
  }
}
