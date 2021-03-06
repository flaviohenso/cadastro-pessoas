package br.com.flaviohenrique.cadastroPessoas.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.flaviohenrique.cadastroPessoas.domain.exception.BusinessException;
import br.com.flaviohenrique.cadastroPessoas.domain.exception.EntidadeNaoEncontradaException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleNegocio(BusinessException negocioException, WebRequest request) {
			var status = HttpStatus.BAD_REQUEST;
			
			var problema = new Problema();
			problema.setStatus(status.value());
			problema.setLocalDateTime(OffsetDateTime.now());
			problema.setTitulo(negocioException.getMessage());
			
			return super.handleExceptionInternal(negocioException, problema, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<Object> handleEntidadeNaoEncontradaExeception(BusinessException negocioException, WebRequest request) {
			var status = HttpStatus.NOT_FOUND;
			
			var problema = new Problema();
			problema.setStatus(status.value());
			problema.setLocalDateTime(OffsetDateTime.now());
			problema.setTitulo(negocioException.getMessage());
			
			return super.handleExceptionInternal(negocioException, problema, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		var campos = new ArrayList<Problema.Campo>();

		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) error).getField();
			String menssagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

			campos.add(new Problema.Campo(nome, menssagem));
		}

		var problema = new Problema();

		problema.setStatus(status.value());
		problema.setTitulo("Um o mais campo estao invalidos! Faça o preenchimento corretamente");
		problema.setLocalDateTime(OffsetDateTime.now());
		problema.setCampos(campos);

		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}
}
