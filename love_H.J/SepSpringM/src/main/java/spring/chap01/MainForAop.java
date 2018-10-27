package spring.chap01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForAop {

	public static void main(String[] args) {
		String[] configLocations = new String[] { "applicationContext.xml",
				"commonConcern.xml" };
		ApplicationContext context = new GenericXmlApplicationContext(configLocations); //GenericXmlApplicationContext <=요새()는 이것을 더 많이 사용한다고 한다. 
		// 객체를 만들어서 getbean에서 꺼내서 사용하는 방법이다.(8~11줄 해당내용)
		WriteArticleService articleService = (WriteArticleService) context
				.getBean("writeArticleService");
		articleService.write(new Article());
	}
}
