package br.com.senai.autoescolan321.exception.types.usuario;

public class UsuarioInativoException extends RuntimeException {
    public UsuarioInativoException(String message) {
        super(message);
    }
}