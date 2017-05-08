package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import systemServices.FileUploadPath;

@Controller
public class UploadedPhotosContr {
	@Autowired
	private FileUploadPath regularUploadPath;
	
	private FileUploadPath tournamentUploadPath;

	@RequestMapping(value ={ "/uploads/regularPlay/**","/uploads/tournament/**"},  
			method = RequestMethod.GET)
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String filename = URLDecoder.decode(req.getServletPath().substring(req.getServletPath()
				.lastIndexOf('/')),
				"UTF-8");
		File file;
		if(req.getServletPath().contains("regularPlay")){
			file= new File(regularUploadPath.getUploadDirectory(), filename);
		}
		else{
			file= new File(tournamentUploadPath.getUploadDirectory(), filename);
		}
		resp.setHeader("Content-Type", req.getServletContext().getMimeType(filename));
		resp.setHeader("Content-Length", String.valueOf(file.length()));
		resp.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
		Files.copy(file.toPath(), resp.getOutputStream());
	}

}
