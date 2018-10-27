package spring.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDAO empnodao;

	public void setEmpnodao(EmpDAO empnodao) {
		this.empnodao = empnodao;
	}

	public List<String> listEmpno() {
		List<String> list = null;

		try {
			list = empnodao.getListData("emp.listEmpno");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;
	}

	public EmpData listEmp(String empno) {
		EmpData list = null;

		try {
			list = empnodao.getEmpList("emp.empList", empno);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;
	}
}