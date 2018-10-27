package spring.controller;

import javax.validation.Valid;

import spring.service.AuthenticationException;
import spring.service.Authenticator;
import spring.service.LoginCommand;
import spring.validator.LoginCommandValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {

	private String formViewName = "login/form";

	@Autowired
	private Authenticator authenticator;

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}

	@ModelAttribute
	public LoginCommand formBacking() {//어노테이션 이름지정 안하면 리턴타입 소문자로 시작하는 애로 모델에 저장됨.loginCommand
		return new LoginCommand();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@Valid LoginCommand loginCommand, BindingResult result) {
		if (result.hasErrors()) {
			return formViewName;
		}
		try {
			authenticator.authenticate(loginCommand);
			return "redirect:/index.jsp";
		} catch (AuthenticationException e) {
			result.reject("invalidIdOrPassword", new Object[] { loginCommand.getUserId() }, null);
			return formViewName;
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {//파라미터는 스트링 타입인데 data타입으로 바로 변경 가능
		binder.setValidator(new LoginCommandValidator());
	}

	public void setAuthenticator(Authenticator loginService) {
		this.authenticator = loginService;
	}

}