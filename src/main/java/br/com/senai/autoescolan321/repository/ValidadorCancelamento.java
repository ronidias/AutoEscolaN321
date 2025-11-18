package br.com.senai.autoescolan321.repository;

import br.com.senai.autoescolan321.model.dto.instrucao.DadosCancelamentoInstrucao;

public interface ValidadorCancelamento {

    void validar(DadosCancelamentoInstrucao dados);
}
