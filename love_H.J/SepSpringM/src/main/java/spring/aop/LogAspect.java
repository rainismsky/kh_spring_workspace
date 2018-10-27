package spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	@Pointcut("execution(public * *(..))")
	public void publicMethod() {
	}

	@Before("execution(public * *(..))")
	public void beforeLogging(JoinPoint j) {
		System.out.println(j.getSignature().getName());
		System.out.println("**메소드 호출 전**");
	}

	@AfterReturning(pointcut = "publicMethod()", returning = "returnValue")
	public void afterLogging(Object returnValue) {
		System.out.println("**메소드 호출 후**");
	}

	@AfterThrowing(pointcut = "publicMethod()", throwing = "ex")
	public void throwingLogging(Exception ex) {
		System.out.println("**예외 발생:" + ex.getMessage() + "**");
	}
	@After("publicMethod()")
	public void alwaysLogging() {
		System.out.println("**항상 실행**");
	}
}
