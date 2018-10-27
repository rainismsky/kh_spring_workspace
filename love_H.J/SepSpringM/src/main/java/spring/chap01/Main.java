package spring.chap01;

import org.springframework.beans.factory.BeanFactory;
	import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
	import org.springframework.core.io.Resource;

	public class Main {
	//BeanbFactory : 스프링 컨테이너 
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory beanFactory = new GenericXmlApplicationContext("applicationContext.xml");
		WriteArticleService articleService = (WriteArticleService) beanFactory.getBean("writeArticleService");
		articleService.write(new Article());
	}
}
