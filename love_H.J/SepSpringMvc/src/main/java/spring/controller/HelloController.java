package spring.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping(value="/hello.do",method=RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();		
		//view 정보 저장
		mav.setViewName("hello");
		
		mav.addObject("greeting",getGreeting()); //맵을 구현하고 있는애,model데이터 저장 (키,값)
		
		return mav;
	}
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour >= 6 && hour <=10) {
			return"좋은 아침";
		}else if(hour >=12 && hour <=15) { //12시 ~ 3시
			return "점심 식사 ??";
		}else if(hour >=18 && hour <=22) {
			return "굿 밤^^";}
		return"안녕?";
		}
	}