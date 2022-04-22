package app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Aspect
public class MyLoggingAspect {

@Around("execution( * app.dao.*.*(..)) ")
  public Object aroundAllRepositoryMethodsAdvice (ProceedingJoinPoint joinPoint) throws Throwable {
  MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

  String methodName = methodSignature.getName();
  System.out.println("Begin of "+ methodName);
   Object targetMethodResult = joinPoint.proceed();
  System.out.println("End of "+ methodName);
   return  targetMethodResult;
      
  }

}
