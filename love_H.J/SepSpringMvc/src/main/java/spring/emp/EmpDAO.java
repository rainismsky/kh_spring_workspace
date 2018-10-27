package spring.emp;
import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class EmpDAO extends SqlSessionDaoSupport {

	public List<String> getListData(String string) {
		List<String> empno = getSqlSession().selectList(string);
		return empno;
	}
	
	public EmpData getEmpList(String string , String empno) {
		EmpData EmpList = getSqlSession().selectOne(string , empno);
		return EmpList;
	}
}


