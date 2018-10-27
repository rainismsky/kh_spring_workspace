package spring.anno;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainAnno {
public static void main(String args[]) {

	AbstractApplicationContext context = new GenericXmlApplicationContext("annoTest.xml");
	Bar b = context.getBean("bar",Bar.class);
	b.doBar();
	
	context.registerShutdownHook(); //종료시켜주는 메서드
	
}
}
