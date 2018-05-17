package springboot010;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class Index {
	
	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		return "Hello Spring boot Mvc";
	}
	
	@RequestMapping(path={"/index4GET"},method=RequestMethod.GET)
	@ResponseBody
	public String index4GET() {
		return "get method";
	}
	
	@GetMapping(path="/index4GET2")
	@ResponseBody
	public String index4GET2() {
		return "get method2"; 
	}
	
	@RequestMapping(path={"/index4POST"},method=RequestMethod.POST)
	@ResponseBody
	public String index4POST() {
		return "post method";
	}
	
	@PostMapping(path="/index4POST2")
	@ResponseBody
	public String index4POST2() {
		return "post method2";
	}
	
	@PostMapping(path="/indexCommon/{pathValue}")
	@ResponseBody
	public String indexCommon(@RequestParam(name="name", required=false) String name, 
							  @RequestParam(name="password") String password,
							  @PathVariable(name="pathValue") String pathValue, 
							  HttpServletRequest reques ) {
		return "name = " + name + " password = " + password + " pathValue = " + pathValue + " localAddr = " + reques.getLocalAddr(); 
		
	}
	
	@RequestMapping("/index4Jsp")
	public String index4Jsp(@RequestParam(name="name", required=false) String name, @RequestParam(name="password") String password, Model model) {
		if(name.equals(password)) {
			model.addAttribute("info", name + "_" + password);
			return "/ok";
		} else {
			return "/fail";
		}
	}

}
