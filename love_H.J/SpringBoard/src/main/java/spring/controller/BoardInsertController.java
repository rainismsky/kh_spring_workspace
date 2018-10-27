package spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import spring.model.BoardDao;
import spring.model.BoardDto;

@Controller
public class BoardInsertController implements ApplicationContextAware {
	private WebApplicationContext context = null;

	@Autowired
	BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	// private WebApplicationContext context = null;
	
	//글등록 form
	@RequestMapping(value = "/board/boardInsert.do", method = RequestMethod.GET)
	public String insertFome() {
		return "boardInsert";
	}
	
	
	//글등록 submit
	@RequestMapping(value = "/board/insert.do", method = RequestMethod.POST)
	public String submit(MultipartHttpServletRequest request) {
		String path = "d:/data/";
		// String path =
		// request.getSession().getServletContext().getRealPath("/WEB-INF/files/");
		MultipartFile file = request.getFile("filename");
		
		long now = System.currentTimeMillis();
		Random r = new Random();
		int i= r.nextInt(50);
		
		File filename = new File(path, now+"_"+i+"_"+file.getOriginalFilename());
		try {
			BoardDto boardDto = new BoardDto();
			boardDto.setTitle(request.getParameter("title"));
			boardDto.setFilename(now+"_"+i+"_"+file.getOriginalFilename());
			boardDto.setName(request.getParameter("name"));
			boardDto.setPwd(request.getParameter("pwd"));
			boardDto.setContent(request.getParameter("content"));

			int x = dao.insertBoard(boardDto);

			if (x == 1) {
				System.out.println("인설트 성공");
			} else {
				System.out.println("실패");
			}

			file.transferTo(filename);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "redirect:/board/list.do";
	}
	
	
	//리스트
	@RequestMapping("board/list.do")
	public String boardList(HttpServletRequest request, ModelMap mav) {
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 10; // 한페이지의 글의 개수
		int currentPage = Integer.parseInt(pageNum);
		int start = (currentPage - 1) * pageSize + 1; // 한 페이지의 시작글 번호
		int end = currentPage * pageSize; // 한 페이지의 마지막 글번호
		int count = 0;
		String search = request.getParameter("search");
		/*ModelAndView mav = new ModelAndView("boardList");*/
		Map<Object, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		if(search == null || search == "") {
			count = dao.boardCount();
			List<BoardDto> list = dao.boardList(map);
			int number = count;
			mav.addAttribute("list", list);
			mav.addAttribute("number", number);
		}else {
			map.put("search", search);
			count = dao.boardSearchCount(search);
			List<BoardDto> list = dao.boardSearchList(map);
			int number = count;
			mav.addAttribute("list", list);
			mav.addAttribute("number", number);
		}
		
		
		mav.addAttribute("currentPage",currentPage);
		mav.addAttribute("start",start);
		mav.addAttribute("end",end);
		mav.addAttribute("count",count);
		mav.addAttribute("pageSize",pageSize);
		
		return "boardList";
	}
	
	
	//상세페이지
	@RequestMapping(value = "board/detail.do", method = RequestMethod.GET)
	public String boardDetail(@RequestParam("no") String no, ModelMap mav) {
		BoardDto list = dao.boardDetail(no);
		dao.boardViewUpdate(no);
		/*ModelAndView mav = new ModelAndView("boardDetail");*/
		mav.addAttribute("list", list);
		return "boardDetail";
	}

	
	//수정 form
	@RequestMapping(value = "board/updateFrom.do", method = RequestMethod.GET)
	public String boardUpdateForm(@RequestParam("no") String no, ModelMap mav) {
		BoardDto list = dao.boardDetail(no);
		/*ModelAndView mav = new ModelAndView("boardUpdate");*/
		mav.addAttribute("list", list);
		return "boardUpdate";
	}
	
	
	//수정 submit
	@RequestMapping(value = "board/updateSubmit.do", method = RequestMethod.POST)
	public String boardUpdateSubmit(MultipartHttpServletRequest request) {
		
		BoardDto boardDto = new BoardDto();
		try {
			String path = "d:/data/";
			long now = System.currentTimeMillis();
			Random r = new Random();
			int i= r.nextInt(50);
			MultipartFile file = request.getFile("filename");
			if (file.getOriginalFilename() != "") {
				
				boardDto.setFilename(now+"_"+i+"_"+file.getOriginalFilename());
				File filename = new File(path, now+"_"+i+"_"+file.getOriginalFilename());
				file.transferTo(filename);

			} else {
				BoardDto list = dao.boardDetail(request.getParameter("no"));
				boardDto.setFilename(list.getFilename());
			}
			boardDto.setTitle(request.getParameter("title"));
			boardDto.setContent(request.getParameter("content"));
			boardDto.setNo(request.getParameter("no"));
			int x = dao.boardUpdate(boardDto);

			if (x == 1) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}

		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "redirect:/board/list.do";
	}
	
	//file 다운로드
	@RequestMapping(value = "board/file.do", method = RequestMethod.GET)
	public String download(@RequestParam("no") String no, ModelMap mav) throws Exception {
		File downloadFile = getFile(no);
		mav.addAttribute("downloadFile", downloadFile);
		return "download";
	}
	
	//file 다운로드 메서드
	private File getFile(String no) {
		BoardDto list = dao.boardDetail(no);
		String filename = list.getFilename();
		String path = "d:/data/" + filename;
		return new File(path);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}
	
	
	//삭제 
	@RequestMapping(value = "board/delete.do", method=RequestMethod.GET)
	public String boardDelete(@RequestParam("no")String no) {
		
		int x = dao.boardDelete(no);
		if (x == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		return "redirect:/board/list.do";
	}
	

}
