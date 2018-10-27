package spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.service.SearchCommand;
import spring.service.SearchResult;
import spring.service.SearchService;
import spring.service.SearchType;

@Controller
public class GameSearchController {
	private SearchService searchService;

	@ModelAttribute("searchTypeList")
	public List<SearchType> referenceSearchTypeList() {
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "아템"));
		options.add(new SearchType(3, "캐릭터"));
		return options;
	}

	@ModelAttribute("popularQueryList")
	public String[] getPopularQueryList() {//getPopularQueryList메서드 호출해서 스트링 배열 호출
		return new String[] { "battleground", "바람의나라", "검은사막" };
	}

	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}

	@RequestMapping("/search/game.do")
	public ModelAndView search(@ModelAttribute("command") SearchCommand command) {//command라는 이름으로 @ModelAttribute 어노테이션 지정 view단에서 command라는 이름을 씀
		//
		
		ModelAndView mav = new ModelAndView("search/game");
		System.out.println("검색명 = " + command.getQuery().toUpperCase());
		SearchResult result = searchService.search(command);
		mav.addObject("searchResult", result);
		return mav;
	}

	@ExceptionHandler(NullPointerException.class)//예외가 발생할때 처리할 애
	public String handNullPointerException(NullPointerException ex) {//매서드 호출 ex매개변수 저장
		return "error/nullException";//에러 발생순간 다 중단시키고 해당 뷰 요청 error/nullException.jsp파일 실행
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
}
