package br.com.senai.autoescolan321.application.core.validations.instrucao.interfaces;

import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosAgendamentoInstrucao;

public interface ValidadoresAgendamento {
    void validar(DadosAgendamentoInstrucao dados);
}