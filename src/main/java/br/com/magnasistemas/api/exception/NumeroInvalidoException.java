package br.com.magnasistemas.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumeroInvalidoException extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
	public NumeroInvalidoException(String mensagem) {
		super(mensagem);
	}

}
