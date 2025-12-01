package br.com.senai.autoescolan321.application.core.validations.instrutor;

import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.exception.types.instrucao.ValidacaoException;
import br.com.senai.autoescolan321.application.core.validations.instrucao.interfaces.ValidadoresAgendamento;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.InstrutorJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidadorInstrutorAtivo implements ValidadoresAgendamento {
    private final InstrutorJpaRepository instrutorJpaRepository;

    public ValidadorInstrutorAtivo(InstrutorJpaRepository instrutorJpaRepository) {
        this.instrutorJpaRepository = instrutorJpaRepository;
    }

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        if(dados.idInstrutor() == null) {
            return;
        }

        Boolean instrutorAtivo = instrutorJpaRepository.findInstrutorAtivoById(dados.idInstrutor());

        if(!instrutorAtivo) {
            throw new ValidacaoException("Instrução não pode ser agendada com instrutor inativo no sistema!");
        }
    }
}