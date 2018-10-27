package disposal;

import java.util.Date;

public class DisposalDTO {

	private int eq_no;
	private String eq_name;
	private String di_reason;
	private Date di_regdate;

	public int getEq_no() {
		return eq_no;
	}

	public void setEq_no(int eq_no) {
		this.eq_no = eq_no;
	}

	public String getEq_name() {
		return eq_name;
	}

	public void setEq_name(String eq_name) {
		this.eq_name = eq_name;
	}

	public String getDi_reason() {
		return di_reason;
	}

	public void setDi_reason(String di_reason) {
		this.di_reason = di_reason;
	}

	public Date getDi_regdate() {
		return di_regdate;
	}

	public void setDi_regdate(Date di_regdate) {
		this.di_regdate = di_regdate;
	}

}
