/*package spring.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sun.jmx.snmp.Timestamp;

public class insertmain {
	
	public static void main(String[] args) {
		String res = "config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(res);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
					.build(is);
			SqlSession session = factory.openSession();
			List<User> list = session.selectList("member.");

			for (User vo : list) {
				
				System.out.println("memberid:" + vo.getMemberid());
				System.out.println("password:" + vo.getPassword());
				System.out.println("email:" + vo.getEmail());
				System.out.println("name:" + vo.getName());
				
				System.out.println();
			}
			User vo = new User("h","11","옥","su@naver.com",
					new String(System.console()));
			
			int n = session.insert("member.addMem",vo);
			
			if(n > 0) {
				session.commit();
				System.out.println("insert ㅇㅋ");
			}else{
				session.rollback();
				System.out.println("rollback ㅇㅋ");
			}
			session.close();
		}catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}


}
*/