/*package spring.upload;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import spring.upload.fileData;

public class main {
	public static void main(String[] args) {
		String res = "config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(res);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			List<> list = session.selectList("member.getlist");

			for (MembersVo vo : list) {
				System.out.println("id:" + vo.getId());
				System.out.println("pwd:" + vo.getPwd());
				System.out.println("email:" + vo.getEmail());
				System.out.println("phone:" + vo.getPhone());
				System.out.println("regdate:" + vo.getRegdate());
				System.out.println();
			}
			MembersVo vo = new MembersVo("tiavn79", "1234", "gmail", "01089784535",
					new Timestamp(System.currentTimeMillis()));// new date()로 대체가능

			int n = session.insert("member.addMem", vo);
			if (n > 0) {
				session.commit();
				System.out.println("insert ok");
			} else {
				session.rollback();
				System.out.println("insert f");
			}
			session.close();
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}*/