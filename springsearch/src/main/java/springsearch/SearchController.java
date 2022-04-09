package springsearch;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("Home Page");
		String str=null;
		System.out.println(str.length());
		return "home";
	}
	
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query) {
		RedirectView redirectView = new RedirectView();
		if(query.isEmpty()) {
			
			redirectView.setUrl("home");
			
			return redirectView ;
		}
		
		String url="https://www.google.com/search?q="+query;
		
		
		redirectView.setUrl(url);
		return redirectView;
	}
	
	//Using @ pathVariable annotation
	
	@RequestMapping("/user/{userId}/{userName}")
	public String userDetails(@PathVariable("userId") int userId,@PathVariable("userName") String userName) {
		
		System.out.println(userId);
		System.out.println(userName);
		return "home";
	}
	
	//Handling exception in Spring MVC in single Controller
	
//	@ExceptionHandler({NullPointerException.class,NumberFormatException.class})
//	public String exceptionHandlerNull() {
//		
//		return "null_page";
//	}
	
	
//	
//	@ExceptionHandler(value=NullPointerException.class)
//	public String exceptionHandlerNull() {
//		
//		return "null_page";
//	}
//	@ExceptionHandler(value=NumberFormatException.class)
//	public String exceptionHandlerNumberFormat() {
//		
//		return "null_page";
//	}
//	@ExceptionHandler(value=Exception.class)
//	public String exceptionHandlerGeneric() {
//		
//		return "null_page";
//	}
//	
	
	
	
	

}
