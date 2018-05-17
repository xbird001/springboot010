package springboot010;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(@RequestParam(name="name")String name, @RequestParam(name="password")String password, Model model) {
		model.addAttribute("info", name + password);
		return "/loginOut";
	}
	
}
