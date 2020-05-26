package br.com.compasso.cooperativismo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AdviceExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
														  HttpStatus status, WebRequest request) {
		CustomizedResponse exceptionResponse = new CustomizedResponse(
				ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataInicioIsAfterDataFimException.class)
	public final ResponseEntity<CustomizedResponse> handleDataInicioIsAfterDataFimException(DataInicioIsAfterDataFimException ex){
		CustomizedResponse customizedResponse = new CustomizedResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(customizedResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PautaNotFoundException.class)
	public final ResponseEntity<CustomizedResponse> handlePautaNotFoundException(PautaNotFoundException ex){
		CustomizedResponse customizedResponse = new CustomizedResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(customizedResponse,HttpStatus.BAD_REQUEST);
	}

}
