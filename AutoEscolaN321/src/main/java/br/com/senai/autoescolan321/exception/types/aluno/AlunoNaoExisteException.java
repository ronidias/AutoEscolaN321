package br.com.senai.autoescolan321.exception.types.aluno;

public class AlunoNaoExisteException extends RuntimeException {
    public AlunoNaoExisteException(String message) {
        super(message);
    }
}