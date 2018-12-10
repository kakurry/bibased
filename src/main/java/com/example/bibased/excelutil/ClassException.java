package com.example.bibased.excelutil;

import org.springframework.stereotype.Component;

@Component
public class ClassException extends RuntimeException {
	private static final long serialVersionUID = -2314389159501665275L;
	public ClassException(){
		super();
	}
	
	public ClassException(String msg){
		super(msg);
	}
	
	public ClassException(Throwable cause){
		super(cause);
	}
	
	public ClassException(String msg,Throwable cause){
		super(msg,cause);
	}
}
