package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect{

	
@Pointcut("execution(public * spring.aop..*sayHello(..))")
public void pointCut() {}

@Around("pointCut()") //어노테이션에 직접 포인트컷 표현식 넣어도 됨.
public Object trace(ProceedingJoinPoint joinPoint)throws Throwable{
	Signature s = joinPoint.getSignature();
	String methodName = s.getName();
	long startTime = System.nanoTime(); //나노단위에 시간을 가져오고
	System.out.println("[Log]METHOD before --> " + methodName+" time check start");//
	Object o = null;
	
	try {
		o=joinPoint.proceed(); //핵심로직을 호출한다.
	}catch(Exception e) {
		System.out.println("[Log]METHOD error --> "+ methodName);
	}
	long endTime= System.nanoTime();
	System.out.println("[Log]METHOD After --> " + methodName+" time check end");
	System.out.println("[Log] "+ methodName + "Processing time is" +(endTime-startTime)+"ns");
	return o;
}
}