package com.vzard.javase.Bank;


public class OverDraftException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private double deficit;
	
	public double getDeficit() {
		return deficit;
	}
	
	public OverDraftException(String message,double deficit){
		super(message);
		this.deficit = deficit;
	}
	
}
