package spring.logincontroller;

public class LoginCommand {
	private String id;
	private String password;
	private String loginType; //select 태그의 패스속성에다가 로그인 타입 지정
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

}
