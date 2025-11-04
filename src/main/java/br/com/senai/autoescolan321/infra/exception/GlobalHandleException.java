package br.com.senai.autoescolan321.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleNotFoundeException () {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBadRequestException (MethodArgumentNotValidException e) {
        List<FieldError> erros = e.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream()
                .map(DadosBadRequest::new).toList());
    }


    private record DadosBadRequest (String campo, String mensagem) {
        public DadosBadRequest (FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
