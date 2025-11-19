package br.com.senai.autoescolan321.exception.types.instrucao;

public class InstrucaoNaoExisteException extends RuntimeException {
    public InstrucaoNaoExisteException(String message) {
        super(message);
    }
}