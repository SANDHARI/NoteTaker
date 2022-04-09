package springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/contact")
	public String showForm(Model model) {
		
		return "contact";
	}

	// 1. Servlet Approach using getParameter()
	
//	@RequestMapping(path="/processform", method = RequestMethod.POST)
//	public String handleForm(HttpServletRequest request) {
//		
////		String email = request.getParameter("email");
////		System.out.println("User Mail: " + email);
//		
//		
//		
//		return "success";
//	}

	// 2. Using @RequestParam Annotation
	
//	@RequestMapping(path = "/processform", method = RequestMethod.POST)
//	public String handleForm(
//			@RequestParam(name="email", required=true) String email, 
//			@RequestParam("userName") String userName,
//			@RequestParam(name="password", required=true) String password, Model model) {
//
//		System.out.println("User Email: " + email);
//		System.out.println("User Name: " + userName);
//		System.out.println("User Passowrd: " + password);
//		
//		model.addAttribute("name", userName);
//		model.addAttribute("email", email);
//		model.addAttribute("pass", password);
//
//		return "success";
//	}

	
	// 3. Using Model Class
	
	/*
	 * @RequestMapping(path = "/processform", method = RequestMethod.POST) public
	 * String handleForm(
	 * 
	 * @RequestParam("email") String email,
	 * 
	 * @RequestParam("userName") String userName,
	 * 
	 * @RequestParam("password") String password, Model model) {
	 * 
	 * 
	 * User user = new User(); user.setEmail(email); user.setUserName(userName);
	 * user.setPassword(password); System.out.println(user);
	 * 
	 * model.addAttribute(user);
	 * 
	 * return "success"; }
	 */
	
	
	// 4. Using @ModelAttribute annotation
	
	//@ModelAttribute annotation will do three tasks:
	//a. It will get parameters from client/UI
	//b. It will create Model class object (In this Case it is User)
	//c. It will also set data in Model
	
		@RequestMapping(path = "/processform", method = RequestMethod.POST)
		public String handleForm(@ModelAttribute User user, Model model) {
			
			if(user.getUserName().isEmpty()) {
				return "redirect:/contact";
			}
			int createdUser = this.userService.createUser(user);
			model.addAttribute("msg", "User created with Id " + createdUser);
			return "success";
		}
		
		// To add something repeatedly in Model In such case we can create a method and add @ModelAttribute on top of it
		@ModelAttribute
		public void commonDataForModel(Model model) {
			model.addAttribute("Header", "Spring MVC Form");
			model.addAttribute("Desc", "Login Form developed using Spring MVC");
			
		}

}
