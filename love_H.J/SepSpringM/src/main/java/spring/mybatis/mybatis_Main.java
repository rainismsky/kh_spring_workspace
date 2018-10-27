package spring.mybatis;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class mybatis_Main {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("mybatisEx.xml");

		MemberDAO dao = context.getBean("memberDao", MemberDAO.class);
		List<User> mem = dao.selectAll();
		for (User user : mem) {
			System.out.println(user);
		}
		System.out.println("System end!!");
	}
}
