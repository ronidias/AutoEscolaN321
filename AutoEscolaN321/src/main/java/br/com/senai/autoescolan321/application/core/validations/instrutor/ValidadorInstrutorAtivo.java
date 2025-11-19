package br.com.senai.autoescolan321.application.core.validations.instrutor;

import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.exception.types.instrucao.ValidacaoException;
import br.com.senai.autoescolan321.application.core.validations.instrucao.interfaces.ValidadoresAgendamento;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.InstrutorRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidadorInstrutorAtivo implements ValidadoresAgendamento {
    private final InstrutorRepository instrutorRepository;

    public ValidadorInstrutorAtivo(InstrutorRepository instrutorRepository) {
        this.instrutorRepository = instrutorRepository;
    }

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        if(dados.idInstrutor() == null) {
            return;
        }

        Boolean instrutorAtivo = instrutorRepository.findInstrutorAtivoById(dados.idInstrutor());

        if(!instrutorAtivo) {
            throw new ValidacaoException("Instrução não pode ser agendada com instrutor inativo no sistema!");
        }
    }
}