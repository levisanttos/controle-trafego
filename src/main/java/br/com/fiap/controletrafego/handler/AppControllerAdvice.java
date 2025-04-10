package br.com.fiap.controletrafego.handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.fiap.controletrafego.exception.ErroExecption;
import br.com.fiap.controletrafego.exception.ObjetoNotFoundException;

@RestControllerAdvice
public class AppControllerAdvice {
	
	@ExceptionHandler(ObjetoNotFoundException.class)
	public ResponseEntity<ErroExecption> handlerObjetoNotFoundExceptio(ObjetoNotFoundException ex) {
		
		ErroExecption erroExecption = new ErroExecption(ex.getMessage(), LocalDateTime.now());
		
		return new ResponseEntity<ErroExecption>(erroExecption, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> manusearArgumentoInvalidos(MethodArgumentNotValidException exception) {
		
		Map<String, String> mapaDeErros = new HashMap<>();
		List<FieldError> campos = exception.getBindingResult().getFieldErrors();
		campos.forEach(campo -> {
			mapaDeErros.put(campo.getField(), campo.getDefaultMessage());
		});
		
		return mapaDeErros;
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public Map<String, String> handlerIntegridadeDados(DataIntegrityViolationException exception) {
		
		Map<String, String> mapaDeErros = new HashMap<>();
		mapaDeErros.put("erro", "Usuario já cadastrado");
		
		return mapaDeErros;
		
	}

}
