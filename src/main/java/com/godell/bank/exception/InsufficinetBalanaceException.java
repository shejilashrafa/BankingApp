package com.godell.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_ACCEPTABLE)
public class InsufficinetBalanaceException extends RuntimeException{
	public InsufficinetBalanaceException(String message) {
		super(message);
	}

}
