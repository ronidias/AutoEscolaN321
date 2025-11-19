package br.com.senai.autoescolan321.exception.types.instrutor;

public class InstrutorNaoExisteException extends RuntimeException {
    public InstrutorNaoExisteException(String message) {
        super(message);
    }
}