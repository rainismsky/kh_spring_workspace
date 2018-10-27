package spring.upload;

import java.util.Date;

public class fileData {
	private String sno;
	private String orig_name;
	private String sys_name;
	private int f_size;
	private Date regdate;

	public fileData() { //기본 생성자
	
	}

	public fileData(String sno, String orig_name, String sys_name, int f_size, Date regdate) {
		super();
		this.sno = sno;
		this.orig_name = orig_name;
		this.sys_name = sys_name;
		this.f_size = f_size;
		this.regdate = regdate;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getOrig_name() {
		return orig_name;
	}

	public void setOrig_name(String orig_name) {
		this.orig_name = orig_name;
	}

	public String getSys_name() {
		return sys_name;
	}

	public void setSys_name(String sys_name) {
		this.sys_name = sys_name;
	}

	public int getF_size() {
		return f_size;
	}

	public void setF_size(int f_size) {
		this.f_size = f_size;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
