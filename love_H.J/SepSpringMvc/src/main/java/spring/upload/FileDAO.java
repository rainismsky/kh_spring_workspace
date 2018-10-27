package spring.upload;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.List;

public class FileDAO extends SqlSessionDaoSupport {
	
	
	/*SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}*/
	
	public int insert(fileData dto){
		int l = getSqlSession().insert("myMem.insert", dto); //셀렉트문 ID지정 //아이디값, 업로드할 파일명
		
		return l;
	}

}
