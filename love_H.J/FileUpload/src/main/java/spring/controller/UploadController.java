package spring.controller;

import java.io.File;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@RequestMapping(value = "/report/ajaxUpload.do", method = RequestMethod.GET)
	public String form() {
		System.out.println("ajaxUpload.do");
		return "upload";
	}

	@RequestMapping(value = "/report/ajaxUpload.do", method = RequestMethod.POST)
	@ResponseBody
	public Object submit(String studentNumber,
			@RequestParam("report") MultipartFile[] report) {
		printInfo(studentNumber, report);
		upload(report);

		return "test";
	}

	private void printInfo(String studentNumber, MultipartFile[] report) {
		System.out.println(studentNumber + "가 업로드 한 파일:");
		for (MultipartFile file : report) {
			System.out.println(file.getOriginalFilename());
		}
	}

	public void upload(MultipartFile[] file) {
		String path = "D://item//";
		String f_name = "";
		for (MultipartFile report : file) {
			f_name = report.getOriginalFilename();
			long now = System.currentTimeMillis();
			Random r = new Random();
			int i = r.nextInt(50);
			String new_name = now + "_" + i + "_" + f_name;
			File new_file = new File(path, new_name);

			try {
				report.transferTo(new_file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}