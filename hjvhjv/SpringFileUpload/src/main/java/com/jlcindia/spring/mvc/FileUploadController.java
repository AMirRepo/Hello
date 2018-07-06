package com.jlcindia.spring.mvc;
import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class FileUploadController {
	public	FileUploadController()
	{
		System.out.println("FileUploadController--d.c");
		System.out.println("Hello");
		System.out.println("Hi");
		System.out.println("HO");
		System.out.println("Hayyyy");
		System.out.println("New");
		System.out.println("Hay");
		 System.out.println("HH");
		 System.out.println("hhhhhhhhh");
		 System.out.println("chdvc");
		 System.out.println("scjsjc");
		 System.out.println("gcjxbj");
	}
	
	@RequestMapping(value="/up.jlc",method=RequestMethod.POST)
	public String uploadFile(@RequestParam("name")String name, @RequestParam("file") MultipartFile file,  HttpServletRequest req)
	{
		System.out.println("uploadFile()");
		if(file.isEmpty())
		{
			req.setAttribute("MSG", file.getOriginalFilename()+"is empty");
			return "error";
		}
		
		else
		{
			try
			{
				System.out.println("Inside Try");
				File dir=new File("E:/file");
				if(!dir.exists())
				dir.mkdirs();
				String fileName=file.getOriginalFilename();
				File f=new File(dir,fileName);
				BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(f));
				byte data[]=file.getBytes();
				stream.write(data);
				stream.close();
				req.setAttribute("MSG", f.getAbsolutePath());
				return "success";
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				req.setAttribute("MSG", file.getOriginalFilename()+"."+e.getMessage());
				return "error";
			}
		}
	}

}
