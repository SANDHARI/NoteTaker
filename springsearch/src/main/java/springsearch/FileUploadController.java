package springsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping("/fileform")
	public String showUploadForm() {
		String str = null;
		System.out.println(str.charAt(1));
		return "fileupload";
	}
	
	
	@RequestMapping(value="/uploadimage", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("profile") CommonsMultipartFile file, HttpSession s,Model m){
		System.out.println("File upload handler");
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getStorageDescription());
		
		//Get the byte data
		byte[] data = file.getBytes();
		//We have o save this file in server..
		//String path=s.getServletContext().getRealPath("/")+file.getOriginalFilename();
		String path=s.getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"resources"+File.separator+"image"+File.separator+file.getOriginalFilename();
		System.out.println(path);
		
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			System.out.println("File uploaded successfully to server");
			m.addAttribute("msg", "Uploaded Successfully");
			m.addAttribute("filename", file.getOriginalFilename());
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Uploading error...");
			m.addAttribute("msg", "File Upload Error");
		}
		
		
		return "filesuccess";
	}

}
