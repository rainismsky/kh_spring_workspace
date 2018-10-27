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

	@Autowired // �� ��ü �ڵ� ����
	ReviewDAO reviewdao;
	
	// �� ��� ��
	@RequestMapping("/list_Review")
	public String listAll(HttpServletRequest request,Model model) throws Exception {
	
	List<ReviewDTO> list = reviewdao.listAll();
	
	System.out.println("list"+ list);
	
	model.addAttribute("list",list); //Ű�� ���� �Ӽ��� �� ��ü�� ��´�.
	
	System.out.println("�Խñ� ��� ��� ����� ���� �մϴ�.");
	
	return "list_Review"; //list.Review�� List�� ���޵ȴ�. 
	}
	
	 /* �� �� ����
	  @RequestParam:get/post������� ���޵� ���� 1��
	   Httpsession ���� ��ü  */
	
	@RequestMapping(value = "/Detail_Review", method = RequestMethod.GET)
	public String read(@RequestParam int rno, HttpSession session, Model model) throws Exception {
		ReviewDTO reviewDTO = new ReviewDTO();
		
		reviewDTO.setRno(rno);
	
		List<ReviewDTO> list = reviewdao.read(reviewDTO);
		
		System.out.println("rno::"+ rno);
		
		System.out.println("list::"+ list);
		
		model.addAttribute("list",list); //�� ��ü�� �߰� �Ӽ� ������ list��� key�� list value�� ��´�. ���� ����Ʈ��� �����ȿ� reviewDTO ��ü�� ���� �߱� �����̴�.		
		
		System.out.println("�Խñ� ��ȸ ����� ���� �մϴ�.");	
		
		return "Detail_Review";	
	}
			
/*	
  	// �� ��� 
	@RequestMapping(value = "create", method = RequestMethod.POST) //��ư���� �ѱ涩 ������ get����� ���ٰ���,������ ���ٶ� post��� ���
		public String create(@ModelAttribute ReviewDTO dto)throws Exception{
		
		System.out.println("create::"+dto);
		
		reviewdao.create(dto);
		
		System.out.println("dto::"+dto);
		
		System.out.println("�Խñ� �ۼ� ����� ���� �մϴ�");
		
		return "redirect:list_Review";
	}
	*/
	
	/* �� ����
	  	
	  	������ �Է��� ������� @ModelAttribute BoardDTO dto�� ���� */
	
	@RequestMapping(value = "update", method = RequestMethod.POST) 
	public String update(@ModelAttribute ReviewDTO dto)throws Exception{
		reviewdao.update(dto);
		
		System.out.println("dto::" + dto);
		System.out.println("�Խñ� ���� ����� ���� �մϴ�.");
		
		return "redirect:list_Review";
	}
	
/*	// �� ����
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public String delete(@RequestParam("rno") ReviewDTO rno) throws Exception {
		reviewdao.delete(rno);
		
		System.out.println("�Խñ� ���� ����� ���� �մϴ�.");
		
		return "redirect:list_Review";
	}*/
	
	/*// �Խñ� �ۼ� ȭ��
		// @RequestMapping("board/write.do")
		// value="",method="���� ���"
	@RequestMapping(value = "/write_Review", method = RequestMethod.GET)
	public String write() {
		
		System.out.println("�Խñ� �ۼ� ȭ�� ��� ����� ���� �մϴ�.");
		
		return "write_Review"; // write.jsp �̵�
	}
	*/
	
	/*reviewdao.increaseView(rno); ��ȸ�� ���� 
	
	 ��(������)+��(ȭ��)��(��) �Բ�  �����ϴ� ��ü
	ModelAndView mav = new ModelAndView();
	 �� �̸�
	mav.setViewName("Review/view.Review");
	 ��� ������ ������
	
	ReviewDTO reviewDTO = new ReviewDTO(); //reviewDTOŸ�Կ� ReviewDTO��ü�� ����� 
	reviewDTO.setRno(rno); //reviewDTOŸ�Կ� ���ͷ� setRno�� �����ͼ� (rno) <= �Ű������� rno ���� �����Ѵ�.  
	mav.addObject("dto", reviewdao.read(reviewDTO));//"dto"Ű����  reviewdao.read(reviewDTO) value���� ����(�߰�)�Ѵ�

	
	System.out.println("mav::"+ mav.toString()); //Test�� ���� toString���� ��� ����� �̾ƺ���.

	return mav;
}
*/	
}