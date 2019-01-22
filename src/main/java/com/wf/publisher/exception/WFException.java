package com.wf.publisher.exception;

public class WFException extends Exception
{ 
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public WFException(String errorMessage)
	{
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public WFException()
	{
		super();
	}

}
