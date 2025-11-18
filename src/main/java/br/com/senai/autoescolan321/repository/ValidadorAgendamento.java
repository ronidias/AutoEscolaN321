package br.com.senai.autoescolan321.repository;

import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;

public interface ValidadorAgendamento {
    void validar(DadosAgendamentoInstrucao dados);
}
