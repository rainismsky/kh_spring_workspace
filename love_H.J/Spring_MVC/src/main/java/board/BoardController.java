package board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.sun.org.apache.regexp.internal.recompile;

@Controller //현재 클래스를 컨트롤러 빈(bean)으로 등록
@RequestMapping("/board/*")
public class BoardController{
	
	//의존관계 주입 => BoardServiceImpl 생성
	//loC 의존 관계 역전
	@Autowired // 빈 객체를 주입 받을때 사용
	BoardService boardService;

	// 1.게시글 목록
	@RequestMapping("list.do") //list.do(내가 지정 한 지정 경로명 do는 호출받을 도메인)을/를 호출 받을때 사용 
	public ModelAndView list() throws Exception {
		List<BoardVO> list = boardService.listAll();
		// ModelAndView - 모델과 뷰
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/list");// 뷰를 list.jsp로 설정
		mav.addObject("list", list);// 데이터 저장
		return mav; // list.jsp로 List가 전달됨.
	}

	// 2_1. 게시글 작성 화면
	// @RequestMapping("board/write.do")
	// value="",method="전송 방식"
	@RequestMapping(value = "write.do", method = RequestMethod.GET)
	public String write() {
		return "board/write"; // write.jsp 이동
	}

	// 2_2.게시글 작성 처리
	@RequestMapping(value="insert.do",method=RequestMethod.POST)
	public String insert(@ModelAttribute BoardVO vo)throws Exception{
		
		boardService.create(vo);
		return"redirect:list.do";
	}

	/*
	 * 3.게시글 상세 내용 조회,게시글 조회수 증가 처리
	 * 
	 * @RequestParam:get/post방식으로 전달된 변수 1개
	 *  Httpsession 세션 객체
	 */
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception {
		// 조회수 증가 처리
		boardService.increaseViewcnt(bno, session);
		// 모델(데이터)+뷰(화면)를(을) 함께  전달하는 객체
		ModelAndView mav = new ModelAndView();
		// 뷰 이름
		mav.setViewName("board/view");
		// 뷰로 전달할 데이터
		mav.addObject("dto", boardService.read(bno));
		return mav;
	}

	/*
	 * 4.게시글 수정
	 * 폼에서 입력한 내용들은 @ModelAttribute BoardVO vo로 전달
	 */
	
	@RequestMapping(value="update.do",method=RequestMethod.POST)
	public String update(@ModelAttribute BoardVO vo)throws Exception{
		boardService.update(vo);
		return "redirect:list.do";
	}
	
	//5. 게시글 삭제
	@RequestMapping("/delete.do")
	public String delete(@RequestParam("bno") int bno) throws Exception {
		boardService.delete(bno);
		return "redirect:list.do";
	}
}