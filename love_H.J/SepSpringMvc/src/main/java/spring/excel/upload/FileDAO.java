package spring.excel.upload;

import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class FileDAO extends SqlSessionDaoSupport{

	public List<FileData> select(){
		List<FileData> fileDTO = getSqlSession().selectList("file.selectAll"); //셀렉트문 ID지정 //아이디값, 업로드할 파일명       
		return fileDTO;
 }
}