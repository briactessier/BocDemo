package com.fdorval.bocdemo.util.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FunctionallException extends Exception {
	

	private static final long serialVersionUID = 1L;

	Logger LOG = LoggerFactory.getLogger(FunctionallException.class);
	
	
	FunctionallException(Exception e){
		super(e);
	}
	
	FunctionallException(String message, Exception e){
		super(message, e);
	}
	
	public FunctionallException(String message){
		super(message);
	}


	/**
	 * throws an exception
	 * @param message
	 * @param e
	 * @throws FunctionallException
	 */
	public static void throwFunctionallException(String message, Exception e) throws FunctionallException {
		throw new FunctionallException(message, e);
	}
	
	/**
	 * throws an exception
	 * @param message
	 * @param e
	 * @throws FunctionallException
	 */
	public static void throwFunctionallException(String message) throws FunctionallException {
		throw new FunctionallException(message);
	}
}
