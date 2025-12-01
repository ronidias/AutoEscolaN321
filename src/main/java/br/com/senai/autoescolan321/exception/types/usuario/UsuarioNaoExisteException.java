package br.com.senai.autoescolan321.exception.types.usuario;

public class UsuarioNaoExisteException extends RuntimeException {
    public UsuarioNaoExisteException(String message) {
        super(message);
    }
}