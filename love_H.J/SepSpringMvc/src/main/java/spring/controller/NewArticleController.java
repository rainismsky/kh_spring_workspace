package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.service.ArticleService;
import spring.service.NewArticleCommand;

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	@Autowired
	private ArticleService articleService;
	
	/* @RequestMapping 컨트롤러 메서드의 리턴 타입이 String일때
	=> return값을 viewname으로 사용
*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "article/newArticleForm";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command")NewArticleCommand command) {//@ModelAttribute("command") => 모델데이터를 쓰겠다고 명시를하면 다 디스패쳐서블릿으로 넘어간다.
		//1.객체 생성
		//2.파라미터 값 전달
		/*3.모델 데이터 추가(NewArticleCommand)로 추가 편하게 쓰고 싶다면 
		@ModelAttribute("command") <= 이렇게 모델 데이터 사용하겠다고 명시
		*/
		articleService.writeArticle(command);//writeArticle메서드 호출 하고 있고
		return "article/newArticleSubmit"; //문자열을 리턴하는 뷰의 정보
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
}