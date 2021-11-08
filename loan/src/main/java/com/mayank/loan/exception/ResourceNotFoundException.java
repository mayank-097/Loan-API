package com.mayank.loan.exception;

public class ResourceNotFoundException extends Exception{
	
	private static final long serialVVersionUID = 1L;
	
	public ResourceNotFoundException(String message) 
	{
		super(message);
	}

}
