package spring.emp;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import spring.emp.EmpData;

@Controller
public class EmpController {

	@Autowired
	private EmpService eservice;
	
	public void setEservice(EmpService eservice) {
		this.eservice = eservice;
	}

	@RequestMapping(value = "/emp/emp.do")
	public String emp() throws Exception {
		return "emp/emp";
	}
	
	@RequestMapping(value = "/emp/empnolist.do", method = RequestMethod.POST)
	public void empnoList(HttpServletResponse resp) throws Exception {
			List<String> list = eservice.listEmpno();
			JSONObject jso = new JSONObject();
			jso.put("data", list);
			System.out.println(list);
			
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			System.out.println("111111");
			System.out.println(jso.toString());
			out.print(jso.toString());
	}
	
	@RequestMapping(value = "/emp/empList.do", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String empList(HttpServletResponse resp, @RequestParam("empno")String empno) throws Exception {
		resp.setContentType("text/html; charset=UTF-8");
		EmpData list = eservice.listEmp(empno);
		JSONObject jso = new JSONObject();
		jso.put("emp", list);
		System.out.println(jso.toString());
		return jso.toString();
		
	}
}
