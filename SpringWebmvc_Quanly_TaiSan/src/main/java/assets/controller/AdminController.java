package assets.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class AdminController {
	@RequestMapping(value = {"/","/welcome"})
	public String adminPage(Model model, HttpSession session) {
		model.addAttribute("mess", "Welcome to admin page");
		assets.entities.CustomUserDetails user = (assets.entities.CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		session.setAttribute("user", user);
		return "home";
	}
}
