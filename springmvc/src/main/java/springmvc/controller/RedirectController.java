package springmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {
	
	//1. Using redirect prefix
//	@RequestMapping("/one")
//	public String one()
//	{
//		System.out.println("This is One handler");
//		return "redirect:/enjoy";// Used for redirecting the URL
//	}
	
	//2. Using ReDirectView
	@RequestMapping("/one")
	public RedirectView one()
	{
		RedirectView rv=new RedirectView();
		System.out.println("This is One handler");
		rv.setUrl("enjoy");
		return rv;
	}
	
	//3. Using HttpServletResponse (Not Recommended)
//		@RequestMapping("/one")
//		public String one(HttpServletResponse response) throws IOException
//		{
//			
//			System.out.println("This is One handler");
//			//response.sendRedirect("/enjoy");
//			return "response.sendRedirect(\"/enjoy\")";
//		}
	
	
	@RequestMapping("/enjoy")
	public String two() {
		System.out.println("This is enjoy handler");
		return "";
	}

}
