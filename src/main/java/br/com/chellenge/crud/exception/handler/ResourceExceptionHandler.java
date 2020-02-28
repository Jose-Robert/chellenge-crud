package br.com.chellenge.crud.exception.handler;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.chellenge.crud.exception.ClienteNuloOuInexistenteException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ClienteNuloOuInexistenteException.class)
	public ResponseEntity<ApiError> handlerIdentificadorNulo(ClienteNuloOuInexistenteException ex){		
		ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
}
