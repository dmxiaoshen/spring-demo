package com.dmxiaoshen;


import com.dmxiaoshen.base.AbstractApiHolder;
import com.dmxiaoshen.service.BookService;

public class ApiHolder extends AbstractApiHolder {

	public static BookService bookService;

	static {
		bookService = getBean(BookService.class);
		notNull(bookService, "ApiHolder->bookService must not be null");
		
		showService();
	}
	
	public static void printServiceList(){
		printService("bookService");
	}
	
	public static void logServieList(){
		logService("bookService");
	}
	
	
	public static void showService() {
		System.out.println("--ApiHolder--dubboContext is--"+dubboContext);
		System.out.println("--ApiHolder--initialize start");
		printServiceList();
		System.out.println("--ApiHolder--initialize end");
		
		logger.error("--ApiHolder--dubboContext is--"+dubboContext);
		logger.error("--ApiHolder--initialize start");
		logServieList();
		logger.error("--ApiHolder--initialize end");
	}
	
}
