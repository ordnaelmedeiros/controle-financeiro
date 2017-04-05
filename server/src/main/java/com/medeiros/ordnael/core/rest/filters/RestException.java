package com.medeiros.ordnael.core.rest.filters;

public class RestException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public RestException() {
	}
	
	public RestException(String erro) {
		super(erro);
	}

}

