package beauty.model;

import java.util.Date;
import com.sun.jmx.snmp.Timestamp;

//ȸ�� �ı�
public class ReviewDTO {
	
	private int rno; //�� ��ȣ
	private String mid; //�ۼ���
	private String rfile; //÷�� ����
	private String rcontents; //�� ����
	private Date r_regdate; //�ۼ���
	private String r_grade; //����
	private String eid; //�亯 �ۼ���(��ü ID)
	private String ra_contents; //��� ����
	private Date ra_regdate; //��� �ۼ���
	
	//toString()
	@Override
	public String toString() {
		return"ReviewDTO[rno="+rno+",mid="+mid+",rfile="+rfile+",rcontents="+rcontents+",r_regdate="+r_regdate+",r_grade="+r_grade+",eid"+eid+",ra_contents"+ra_contents+",ra_regdate"+ra_regdate+"]";
	}
	
	// getter/setter
	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getRfile() {
		return rfile;
	}

	public void setRfile(String rfile) {
		this.rfile = rfile;
	}

	public String getRcontents() {
		return rcontents;
	}

	public void setRcontents(String rcontents) {
		this.rcontents = rcontents;
	}

	public Date getR_regdate() {
		return r_regdate;
	}

	public void setR_regdate(Date r_regdate) {
		this.r_regdate = r_regdate;
	}

	public String getR_grade() {
		return r_grade;
	}

	public void setR_grade(String r_grade) {
		this.r_grade = r_grade;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getRa_contents() {
		return ra_contents;
	}

	public void setRa_contents(String ra_contents) {
		this.ra_contents = ra_contents;
	}

	public Date getRa_regdate() {
		return ra_regdate;
	}

	public void setRa_regdate(Date ra_regdate) {
		this.ra_regdate = ra_regdate;
	}
}