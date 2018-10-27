package spring.anno;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Foo {
	//@Value(value="scott")
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	public void doFoo() {
		System.out.println("Foo.doFoo");
		System.out.println("name::"+name);
	}
	@PostConstruct
	public void start() {
		System.out.println("Foo.start");
	}
	@PreDestroy
	public void stop() {
		System.out.println("Foo.stop");
	}
}
