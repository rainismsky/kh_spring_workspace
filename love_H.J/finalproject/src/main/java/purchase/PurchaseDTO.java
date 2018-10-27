package purchase;

import java.util.Date;

public class PurchaseDTO {

	private int pc_no;
	private String pc_separate;
	private String pc_name;
	private int pc_quantity;
	private int pc_sum;
	private Date pc_buydate;
	private String pc_state;

	public int getPc_no() {
		return pc_no;
	}

	public void setPc_no(int pc_no) {
		this.pc_no = pc_no;
	}

	public String getPc_separate() {
		return pc_separate;
	}

	public void setPc_separate(String pc_separate) {
		this.pc_separate = pc_separate;
	}

	public String getPc_name() {
		return pc_name;
	}

	public void setPc_name(String pc_name) {
		this.pc_name = pc_name;
	}

	public int getPc_quantity() {
		return pc_quantity;
	}

	public void setPc_quantity(int pc_quantity) {
		this.pc_quantity = pc_quantity;
	}

	public int getPc_sum() {
		return pc_sum;
	}

	public void setPc_sum(int pc_sum) {
		this.pc_sum = pc_sum;
	}

	public Date getPc_buydate() {
		return pc_buydate;
	}

	public void setPc_buydate(Date pc_buydate) {
		this.pc_buydate = pc_buydate;
	}

	public String getPc_state() {
		return pc_state;
	}

	public void setPc_state(String pc_state) {
		this.pc_state = pc_state;
	}

}
