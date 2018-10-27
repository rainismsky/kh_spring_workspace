package spring.board;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

	@Autowired
	private BoardDAO boarddao;

	public void setBoarddao(BoardDAO boarddao) { // 접근 제어자 뒤에 void로 선언하면 return값이 없다.라는 뜻이다.
		this.boarddao = boarddao;
	}

	/*
	 * @RequestMapping("/list.do") public String handleRequestInternal(Model model)
	 * { List<BoardDTO> boarddto = boarddao.select();
	 * model.addAttribute("boardlist", boarddto); System.out.println(boarddto);
	 * return "board/list"; }
	 */

	@RequestMapping(value = "/detail.do")
	public String detail(@RequestParam("num") int num, @RequestParam("pageNum") String pageNum, Model model) throws Exception {
		BoardDTO dto = boarddao.read(num);
		int readcount = dto.getReadcount();
		readcount = readcount + 1;
		dto.setReadcount(readcount);
		boarddao.update(dto);
		System.out.println("글 번호" + num + "번의 상세내용 페이지");
		model.addAttribute("board", dto);
		model.addAttribute("pageNum", pageNum);
		return "board/content";

	}
	
	//글 삭제
	@RequestMapping(value = "/delete.do")
	public String delete(@RequestParam("num") int num, Model model) throws Exception {
		boarddao.delete(num);
		System.out.println("글 번호" + num + "번 삭제");
		return "redirect:list.do";

	}
	//글 쓰기
	@RequestMapping(value = "/writeForm.do")
	public String write(@ModelAttribute("write") BoardDTO boarddto) {
		System.out.println("글쓰기페이지 이동");
		return "board/writeForm";
	}
	//글 작성 완료
	@RequestMapping(value = "/writePro.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute("write") BoardDTO dto, BindingResult result) {//write이름으로 dto를 보내주는거. 매개변수 dto타입이있으면 jsp에서 그것에 해당하는 타입이 있을시 데이터를 받아올수있다.
		boarddao.insertboard(dto);
		System.out.println("글작성 완료");
		return "redirect:list.do";
	}

	@RequestMapping(value = "/updateForm.do")
	public String update(@RequestParam("num") int num, Model model) {
		BoardDTO select = boarddao.read(num);
		System.out.println("글 수정 페이지 이동");
		model.addAttribute("board", select);
		return "board/updateForm";
	}

	@RequestMapping(value = "/updatePro.do", method = RequestMethod.POST)
	public String updatePro(BoardDTO dto) {
		boarddao.update(dto);
		System.out.println("글 수정 완료");
		return "redirect:list.do";
	}

	@RequestMapping(value = "/list.do")
	public String selectpage(@RequestParam("pageNum") String pageNum, Model m) {
		
		System.out.println('a');
		
		if (pageNum==null) {
			pageNum = "1";
		}
		int pageSize = 10;//한페이지에 보여줄 게시글의 숫자
		int currentPage = Integer.parseInt(pageNum);//가지고온 pageNum을 숫자로 바꿔준다.
		int startRow = (currentPage - 1) * pageSize + 1;//페이지의 시작 글번호
		int endRow = currentPage * pageSize;//페이지의 끝번호
		int count = 0;//게시글 숫자를 저장하는 변수
		Map<String, Integer> map = new HashMap<String, Integer>();//맵객체 생성
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<BoardDTO> list = boarddao.selectpage(map);
		count=boarddao.count();
		
		m.addAttribute("boardlist", list);
		m.addAttribute("currentPage", currentPage);
		m.addAttribute("startRow", startRow);
		m.addAttribute("endRow", endRow);
		m.addAttribute("count", count);
		m.addAttribute("number", count-pageSize*(currentPage-1));
		m.addAttribute("pageNum", pageNum);
		m.addAttribute("pageSize", pageSize);

		/*		int a;
		if (count % pageSize == 0) {
			a = 0;
		} else {
			a = 1;
		}*/

		return "board/list";
	}

	/*	
	
	@RequestMapping("/search.do") 
	public String search(@RequestParam("") String , Model model){ 
		List<BoardDTO> boarddto = boarddao.select();
		model.addAttribute("boardlist", boarddto); 
		System.out.println(boarddto);
		return "board/list"; 
	}
	
*/
}