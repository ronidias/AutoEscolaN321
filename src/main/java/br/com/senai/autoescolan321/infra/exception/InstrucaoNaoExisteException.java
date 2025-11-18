package br.com.senai.autoescolan321.infra.exception;

public class InstrucaoNaoExisteException extends RuntimeException {
    public InstrucaoNaoExisteException(String message) {
        super(message);
    }
}
