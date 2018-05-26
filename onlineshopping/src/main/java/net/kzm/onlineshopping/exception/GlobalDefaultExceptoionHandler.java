package net.kzm.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptoionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The Page is not constructed");
		mv.addObject("errorDescription", "The page you looking for is not availbale");
		mv.addObject("title", "404 Error Page");

		return mv;

	}
	
	@ExceptionHandler(productNotFoundException.class)
	public ModelAndView handlerproductNotFoundException() {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The Page is not constructed");
		mv.addObject("errorDescription", "Product you are lokking for not availble right now!");
		mv.addObject("title", "Product UnAvailble");

		return mv;

	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException( Exception ex) {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact your Administrator!!");
		
		/* only for debuging your application*/
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription",sw.toString());
		mv.addObject("title","Error");
		
		return mv;


	}
}
