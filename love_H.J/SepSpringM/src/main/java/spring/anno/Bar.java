package spring.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
	
@Component
@Configuration
public class Bar{
	private Foo foo;
	
	@Bean("Piglet")
	public Foo activeFoo() {
		Foo f = new Foo();
		f.setName("piglet");
		return f;
	}
	
	@Required //값을 넣어주는 필수 어노테이션
	//@Resource
	@Autowired
	//@Qualifier("pooh")
	public void setFoo(Foo foo) {
		this.foo = foo;
	}
	public void doBar() {
		foo.doFoo();
	}
	}