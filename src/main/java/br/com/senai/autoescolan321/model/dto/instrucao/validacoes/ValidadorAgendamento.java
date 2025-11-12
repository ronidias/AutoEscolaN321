package br.com.senai.autoescolan321.model.dto.instrucao.validacoes;

import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;

public interface ValidadorAgendamento {
    void validar(DadosAgendamentoInstrucao dados);
}
