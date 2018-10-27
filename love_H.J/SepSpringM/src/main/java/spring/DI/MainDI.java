package spring.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainDI {
	public static void main(String args[]) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("DITest.xml");
		Foo f = context.getBean("foo",Foo.class); //getBean객체로 푸를 꺼내옴 ,class명.class로 호출을 하면 해당타입으로 꺼내오게 된다.(Foo.class)
		f.doFoo();
		//Foo f1 = context.getBean("foo",Foo.class);
		
		context.registerShutdownHook();
		/*System.out.println(f== f1);*/
		
		/*CollEx c = context.getBean("coll",CollEx.class);
		c.printColl();*/
	}
}
