package springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	//@RequestMapping("/home")
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		
		System.out.println("Hello you are in Home Url");
		model.addAttribute("name", "Bharath Kumar");
		model.addAttribute("id", 5264);
		
		List<String> friends = new ArrayList<String>();
		friends.add("Shiva");
		friends.add("Ravi");
		friends.add("Santhosh");
		
		model.addAttribute("f","friends");
		
		return "index";
	
	}
	
	@RequestMapping("/about")
	public String about() {
		System.out.println("Hello you are in About Url");
		return "about";
	}
	
	
	@RequestMapping("/help")
	public ModelAndView help() {
		
		System.out.println("This is Help Controller");
		
		//Creating ModelandView object
		ModelAndView mv=new ModelAndView();
		
		//Setting the Data
		mv.addObject("name", "Bharath");
		
		mv.addObject("eid", 6550);
		LocalDateTime now =LocalDateTime.now();
		mv.addObject("time", now);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(95);
		list.add(94);
		list.add(75);
		list.add(65);
		
		mv.addObject("marks",list);
		
		
		
		//Setting the View name
		mv.setViewName("help");
		
		return mv;
	}
	

}
