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
		CustomizedResponse customizedResponse = new CustomizedResponse(ex.getMessage(), HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(customizedResponse,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SessaoNotFoundException.class)
	public final ResponseEntity<CustomizedResponse> handleSessaoNotFoundException(SessaoNotFoundException ex){
		CustomizedResponse customizedResponse = new CustomizedResponse(ex.getMessage(), HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(customizedResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AssociadoNotFoundException.class)
	public final ResponseEntity<CustomizedResponse> handleAssociadoNotFoundException(AssociadoNotFoundException ex){
		CustomizedResponse customizedResponse = new CustomizedResponse(ex.getMessage(), HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(customizedResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SessaoNaoIniciadaException.class)
	public final ResponseEntity<CustomizedResponse> handleSessaoNaoIniciadaException(SessaoNaoIniciadaException ex){
		CustomizedResponse customizedResponse = new CustomizedResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(customizedResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SessaoFechadaException.class)
	public final ResponseEntity<CustomizedResponse> handleSessaoFechadaException(SessaoFechadaException ex){
		CustomizedResponse customizedResponse = new CustomizedResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(customizedResponse,HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(AssociadoJaVotoException.class)
	public final ResponseEntity<CustomizedResponse> handleAssociadoJaVotoException(AssociadoJaVotoException ex){
		CustomizedResponse customizedResponse = new CustomizedResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(customizedResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UnableToVoteException.class)
	public final ResponseEntity<CustomizedResponse> handleUnableToVoteException(UnableToVoteException ex){
		CustomizedResponse customizedResponse = new CustomizedResponse(ex.getMessage(), HttpStatus.OK.toString());
		return new ResponseEntity<>(customizedResponse,HttpStatus.OK);
	}
	
	@ExceptionHandler(CpfInvalidoException.class)
	public final ResponseEntity<CustomizedResponse> handleCpfInvalidoException(CpfInvalidoException ex){
		CustomizedResponse customizedResponse = new CustomizedResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(customizedResponse,HttpStatus.BAD_REQUEST);
	}
}
