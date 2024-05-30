package fr.formation.pocAOP.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	@Pointcut("execution(public * fr.formation.pocAOP.service.*.*(..))")
	private void publicMethodsFromLoggingPackage() {
	}
	
	@Around(value = "publicMethodsFromLoggingPackage()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
	    Object[] args = joinPoint.getArgs();
	    String methodName = joinPoint.getSignature().getName();
	    System.out.println(">Methode lancée :> "+ methodName+ Arrays.toString(args));
	    Object result = joinPoint.proceed();
	    System.out.println("<Résultat de la méthode < "+ methodName +":"+ result);
	    return result;
	}
}
