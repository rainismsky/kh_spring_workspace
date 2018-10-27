package spring.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.List;

public class MemberDAO extends SqlSessionDaoSupport {
	
	/*
	SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}*/
	
	public List<User> selectAll(){
		List<User> l = getSqlSession().selectList("myMem.selectAll"); //셀렉트문 ID지정
		return l;
	}
}
