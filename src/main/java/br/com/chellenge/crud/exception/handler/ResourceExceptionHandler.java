package br.com.chellenge.crud.exception.handler;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.chellenge.crud.exception.ClienteException;
import br.com.chellenge.crud.exception.ClienteIdInexistenteExcpetion;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ClienteException.class)
	public ResponseEntity<ApiError> handlerCliente(ClienteException ex){		
		ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
	@ExceptionHandler(ClienteIdInexistenteExcpetion.class)
	public ResponseEntity<ApiError> handlerClienteIdNulo(ClienteIdInexistenteExcpetion ex){		
		ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
}
