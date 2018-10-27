package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game/users/{userId}")
public class CharacterInfoController {

	@RequestMapping("/characters/{characterId}")
	public String characterInfo(@PathVariable String userId,//url경로에 변수를 넣어주는 어노테이션
				@PathVariable int characterId, ModelMap model) {
		model.addAttribute("userId", userId);
		model.addAttribute("characterId", characterId);
		return "game/users/info";
	}
}
