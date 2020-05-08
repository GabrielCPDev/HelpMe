package com.Yggdrasil.HelpMe.exceptions;

public class NotImplementation extends RuntimeException{

	private static final long serialVersionUID = -3447104875824146937L;
	
	public NotImplementation() {
		super("Necessário implementar esse métoda.");
	}
	
}
