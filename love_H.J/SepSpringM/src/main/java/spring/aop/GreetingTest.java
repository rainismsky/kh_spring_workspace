package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
	public static void main(String args[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
		GreetingService bean = (GreetingService) ctx.getBean("greetingTarget");
		bean.sayHello("은효구");
		bean.sayGoodbye("은효댕");
	}
}
