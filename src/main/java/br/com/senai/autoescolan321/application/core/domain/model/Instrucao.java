package br.com.senai.autoescolan321.application.core.domain.model;

import br.com.senai.autoescolan321.application.core.domain.enums.Motivo;

import java.time.LocalDateTime;

public class Instrucao {
    private Long id;
    private Aluno aluno;
    private Instrutor instrutor;
    private LocalDateTime data;
    private Boolean cancelada = false;
    private Motivo motivo;
    private LocalDateTime dataCancelamento;

    public Instrucao() {}

    public Instrucao(
            Long id,
            Aluno aluno,
            Instrutor instrutor,
            LocalDateTime data,
            Boolean cancelada,
            Motivo motivo,
            LocalDateTime dataCancelamento) {
        this.id = id;
        this.aluno = aluno;
        this.instrutor = instrutor;
        this.data = data;
        this.cancelada = cancelada;
        this.motivo = motivo;
        this.dataCancelamento = dataCancelamento;
    }

    public Long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Boolean getCancelada() {
        return cancelada;
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public LocalDateTime getDataCancelamento() {
        return dataCancelamento;
    }

    public void cancelar(Motivo motivo) {
        this.cancelada = true;
        this.motivo = motivo;
        this.dataCancelamento = LocalDateTime.now();
    }
}