package br.com.agenda.AgendaTelefonica_SpringBoot.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErro {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity tratar404() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity tratar400(MethodArgumentNotValidException e) {
		return ResponseEntity.badRequest().body(e.getFieldErrors().stream().map(DadosErroValidacao::new).toList());
	}
	
	private record DadosErroValidacao(String nome,String message) {
		public DadosErroValidacao(FieldError err){
            this(err.getField(), err.getDefaultMessage());
        }
	}
}
