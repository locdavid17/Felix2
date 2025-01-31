package assets.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class UserController {
	@RequestMapping("/home")
	public String userPage(Model model) {
		model.addAttribute("mess", "Welcome user page");
		return "home";
	}
	
// ...
}

/*@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/user")
	public String userPage(Model model) {
		model.addAttribute("mess", "Welcome user page");
		return "user";
	}
}
*/