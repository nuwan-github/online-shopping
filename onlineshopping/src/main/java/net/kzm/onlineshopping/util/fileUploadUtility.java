package net.kzm.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class fileUploadUtility {

	private static final String ABS_PATH= "F:\\My_projects\\springMvcEnterpriceApp1_1_18\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH="";
	
	private static final Logger logger= LoggerFactory.getLogger(fileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// TODO Auto-generated method stub
		
		//get the real path
		
		REAL_PATH =request.getSession().getServletContext().getRealPath("/assets/images");
		logger.info(REAL_PATH);
		
		// to make sure the directory exists
		//please create the directory
		if(!new File(ABS_PATH).exists()){
			//create the directory
			new File(ABS_PATH).mkdirs();
		}
		if(!new File(REAL_PATH).exists()){
			//create the directory
			new File(REAL_PATH).mkdirs();
		}
		try{
			//server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			//project directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
		}catch(IOException ex){
			
		}
	}
}
