package spring.member;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class member_main {
public static void main(String[] args) {
	ApplicationContext context = new GenericXmlApplicationContext("jdbcEx.xml");
	jdbcDao dao = context.getBean("jdbcDao", jdbcDao.class);

	List<User> mem = dao.selectAll();

	for (User user : mem) {
		System.out.println(user);
		}

	Integer mem1 = dao.count();

	System.out.println("END 끝!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
}