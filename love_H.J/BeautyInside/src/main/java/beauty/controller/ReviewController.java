package beauty.controller;

import java.util.List;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beauty.model.ReviewDTO;
import beauty.service.ReviewDAO;

@Controller
@RequestMapping("/Review/*")
public class ReviewController {

	@Autowired // 빈 객체 자동 주입
	ReviewDAO reviewdao;
	
	// 글 목록 폼
	@RequestMapping("/list_Review")
	public String listAll(HttpServletRequest request,Model model) throws Exception {
	
	List<ReviewDTO> list = reviewdao.listAll();
	
	System.out.println("list"+ list);
	
	model.addAttribute("list",list); //키와 벨류 속성을 모델 객체에 담는다.
	
	System.out.println("게시글 목록 출력 명령을 수행 합니다.");
	
	return "list_Review"; //list.Review로 List가 전달된다. 
	}
	
	 /* 글 상세 보기
	  @RequestParam:get/post방식으로 전달된 변수 1개
	   Httpsession 세션 객체  */
	
	@RequestMapping(value = "/Detail_Review", method = RequestMethod.GET)
	public String read(@RequestParam int rno, HttpSession session, Model model) throws Exception {
		ReviewDTO reviewDTO = new ReviewDTO();
		
		reviewDTO.setRno(rno);
	
		List<ReviewDTO> list = reviewdao.read(reviewDTO);
		
		System.out.println("rno::"+ rno);
		
		System.out.println("list::"+ list);
		
		model.addAttribute("list",list); //모델 객체에 추가 속성 값으로 list라는 key와 list value를 담는다. 내가 리스트라는 변수안에 reviewDTO 객체를 저장 했기 떄문이다.		
		
		System.out.println("게시글 조회 명령을 수행 합니다.");	
		
		return "Detail_Review";	
	}
			
/*	
  	// 글 등록 
	@RequestMapping(value = "create", method = RequestMethod.POST) //버튼으로 넘길땐 무조건 get방식을 쓴다고함,폼으로 쏴줄땐 post방식 사용
		public String create(@ModelAttribute ReviewDTO dto)throws Exception{
		
		System.out.println("create::"+dto);
		
		reviewdao.create(dto);
		
		System.out.println("dto::"+dto);
		
		System.out.println("게시글 작성 명령을 수행 합니다");
		
		return "redirect:list_Review";
	}
	*/
	
	/* 글 수정
	  	
	  	폼에서 입력한 내용들은 @ModelAttribute BoardDTO dto로 전달 */
	
	@RequestMapping(value = "update", method = RequestMethod.POST) 
	public String update(@ModelAttribute ReviewDTO dto)throws Exception{
		reviewdao.update(dto);
		
		System.out.println("dto::" + dto);
		System.out.println("게시글 수정 명령을 수행 합니다.");
		
		return "redirect:list_Review";
	}
	
/*	// 글 삭제
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public String delete(@RequestParam("rno") ReviewDTO rno) throws Exception {
		reviewdao.delete(rno);
		
		System.out.println("게시글 삭제 명령을 수행 합니다.");
		
		return "redirect:list_Review";
	}*/
	
	/*// 게시글 작성 화면
		// @RequestMapping("board/write.do")
		// value="",method="전송 방식"
	@RequestMapping(value = "/write_Review", method = RequestMethod.GET)
	public String write() {
		
		System.out.println("게시글 작성 화면 출력 명령을 수행 합니다.");
		
		return "write_Review"; // write.jsp 이동
	}
	*/
	
	/*reviewdao.increaseView(rno); 조회수 증가 
	
	 모델(데이터)+뷰(화면)를(을) 함께  전달하는 객체
	ModelAndView mav = new ModelAndView();
	 뷰 이름
	mav.setViewName("Review/view.Review");
	 뷰로 전달할 데이터
	
	ReviewDTO reviewDTO = new ReviewDTO(); //reviewDTO타입에 ReviewDTO객체를 만들고 
	reviewDTO.setRno(rno); //reviewDTO타입에 세터로 setRno를 가져와서 (rno) <= 매개변수에 rno 값을 저장한다.  
	mav.addObject("dto", reviewdao.read(reviewDTO));//"dto"키값과  reviewdao.read(reviewDTO) value값을 저장(추가)한다

	
	System.out.println("mav::"+ mav.toString()); //Test를 위해 toString으로 출력 결과를 뽑아본다.

	return mav;
}
*/	
}