package spring.model;


public class BoardDto {
	private String no;
	private String name;
	private String pwd;
	private String title;
	private String content;
	private String filename;
	private String bdate;
	private String vcount;
	

	public BoardDto() {
	}

	public BoardDto(String no, String name, String pwd, String title, String content, String filename, String bdate,String vcount) {
		this.no = no;
		this.name = name;
		this.pwd = pwd;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.bdate = bdate;
		this.vcount = vcount;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getVcount() {
		return vcount;
	}

	public void setVcount(String vcount) {
		this.vcount = vcount;
	}

	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", name=" + name + ", pwd=" + pwd + ", title=" + title + ", content=" + content
				+ ", filename=" + filename + ", bdate=" + bdate + ", vcount=" + vcount + "]";
	}

	
	

}
