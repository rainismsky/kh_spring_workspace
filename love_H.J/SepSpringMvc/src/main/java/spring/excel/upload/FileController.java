package spring.excel.upload;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.excel.upload.FileService;

@Controller
public class FileController {

	@Autowired
	private FileService fservice;
	
	public void setFservice(FileService fservice) {
		this.fservice = fservice;
	}

	@RequestMapping("/list")
	public ModelAndView handleRequestInternal() {
		List<FileData> fileDTO = fservice.FileData();
		
		return new ModelAndView("FileData", "FileData", fileDTO);
		
		
	}

}

//대문자로 시작하는 것들은 모두 객체들
//다형성 =>하나의 참조변수로 다른 참조변수들을 받아올수 있는것

