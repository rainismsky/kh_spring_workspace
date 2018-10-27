package spring.excel.upload;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDAO filedao;

	public void setFiledao(FileDAO filedao) {
		this.filedao = filedao;
	}
	
	public List<FileData> FileData() {
		List<FileData> listfiledata = null;
		
		try {
			listfiledata = filedao.select();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return listfiledata;
	}

	

	
	
}