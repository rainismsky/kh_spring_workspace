package spring.emp;

import java.util.List;

public interface EmpService {
	public List<String> listEmpno();
	public EmpData listEmp(String empno);
}