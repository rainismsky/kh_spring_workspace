package spring.downloadcontroller;

import java.io.File;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController implements ApplicationContextAware {

	private WebApplicationContext context = null;

	@RequestMapping("/file")
	public ModelAndView download() throws Exception {
		File downloadFile = getFile();
		return new ModelAndView("download", "downloadFile", downloadFile);
	}

	private File getFile() {
		String path = context.getServletContext().getRealPath(
				"/WEB-INF/설명.txt"); // <= 프로젝트안에 있는 경로로 파일을 저장받을 것이기 때문에 이렇게 선언해줌

		return new File(path);
	}

	
	//자동 호출
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}

}