package spring.aop;

import org.springframework.stereotype.Component;

@Component("greetingTarget")
public class GreetingServiceImpl implements GreetingService{
	
	private String greeting;
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public void sayHello(String name) {
		System.out.println("sayHello:" + greeting + ":" + name);
	}
	public void sayGoodbye(String name) {
		System.out.println("sayGoodbye:"+ greeting + ":" + name);
	}
}
