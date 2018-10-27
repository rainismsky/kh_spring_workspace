package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import disposal.DisposalDAO;
import disposal.DisposalDTO;




@Controller
public class DisposalController {

	@Autowired
	private DisposalDAO disposaldao;

	public void setDisposaldao(DisposalDAO disposaldao) {
		this.disposaldao = disposaldao;
	}
	
	@RequestMapping("/disposallist.do") 
	public String list(@RequestParam("pageNum") String pageNum, Model m) {
		if (pageNum==null) {
			pageNum = "1";
		}
		int pageSize = 10;//한페이지에 보여줄 게시긓의 숫자
		int currentPage = Integer.parseInt(pageNum);//가지고온 pageNum을 숫자로 바꿔준다.
		int startRow = (currentPage - 1) * pageSize + 1;//페이지의 시작 글번호
		int endRow = currentPage * pageSize;//페이지의 끝번호
		int count = 0;//게시글 숫자를 저장하는 변수
		Map<String, Integer> map = new HashMap<String, Integer>();//맵객체 생성
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<DisposalDTO> list = disposaldao.selectpage(map);
		count= disposaldao.count();
		for(DisposalDTO dto: list) {
		long now = System.currentTimeMillis();
		Date ddate = new Date(now);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String date = dateFormat.format(ddate);
		
		}
		
		m.addAttribute("purchaselist", list);
		m.addAttribute("currentPage", currentPage);
		m.addAttribute("startRow", startRow);
		m.addAttribute("endRow", endRow);
		m.addAttribute("count", count);
		m.addAttribute("number", count-pageSize*(currentPage-1));
		m.addAttribute("pageNum", pageNum);
		m.addAttribute("pageSize", pageSize);
		
	  return "e/disposal/list"; 
	  
	  }
	
	
}
