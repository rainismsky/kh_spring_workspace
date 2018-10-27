package spring.controller;

import java.io.File;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ReportSubmissionController {

	@RequestMapping(value = "/report/submission.do", method = RequestMethod.GET)
	public String form() {
		return "report/submissionForm";
	}

	@RequestMapping(value = "/report/submitReport1.do", method = RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber") String studentNumber,
			@RequestParam("report") MultipartFile report) {
		printInfo(studentNumber, report);
		upload(report);
		return "report/submissionComplete";
	}
/*	@Autowired 
	File Dao = dao;
*/

	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: " + report.getOriginalFilename());
	}

	@RequestMapping(value = "/report/submitReport2.do", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		printInfo(studentNumber, report);
		return "report/submissionComplete";
	}

	@RequestMapping(value = "/report/submitReport3.do", method = RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand) {
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		return "report/submissionComplete";
	}

	// 원하는 경로의 파일로 데이터 이동 - 파일 경로return
	public String upload(MultipartFile report) {
		String path = "D://item//";
		String f_name = report.getOriginalFilename();// 원본파일이름
		long now = System.currentTimeMillis();// 현재시간을 이용해 중복
		Random r = new Random();
		int i = r.nextInt(50);
		String new_name = now + "_" + i + "_" + f_name;
		File new_file = new File(path, new_name);//now+"_"+r+"_"+f_name이러한 이름을 가진 객체 생성

		try {
			report.transferTo(new_file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new_file.getPath();
	}
/*	public int insertFile(String studentNumber, MultipartFile)
	add.*/
}
