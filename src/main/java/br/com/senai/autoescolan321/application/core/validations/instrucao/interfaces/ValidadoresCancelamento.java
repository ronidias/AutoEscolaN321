package br.com.senai.autoescolan321.application.core.validations.instrucao.interfaces;

import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosCancelamentoInstrucao;

public interface ValidadoresCancelamento {
    void validar(DadosCancelamentoInstrucao dados);
}