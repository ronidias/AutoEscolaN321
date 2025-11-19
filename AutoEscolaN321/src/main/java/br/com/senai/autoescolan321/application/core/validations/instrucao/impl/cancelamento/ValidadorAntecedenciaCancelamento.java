package br.com.senai.autoescolan321.application.core.validations.instrucao.impl.cancelamento;

import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosCancelamentoInstrucao;
import br.com.senai.autoescolan321.exception.types.instrucao.InstrucaoNaoExisteException;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.InstrucaoRepository;
import br.com.senai.autoescolan321.exception.types.instrucao.ValidacaoException;
import br.com.senai.autoescolan321.application.core.validations.instrucao.interfaces.ValidadoresCancelamento;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorAntecedenciaCancelamento implements ValidadoresCancelamento {
    private final InstrucaoRepository instrucaoRepository;

    public ValidadorAntecedenciaCancelamento(InstrucaoRepository instrucaoRepository) {
        this.instrucaoRepository = instrucaoRepository;
    }

    @Override
    public void validar(DadosCancelamentoInstrucao dados) {
        LocalDateTime dataAgendamento = instrucaoRepository.findById(dados.id())
                .orElseThrow(() -> new InstrucaoNaoExisteException("ID da instrução informado não existe!"))
                .getData();
        LocalDateTime agora = LocalDateTime.now();

        Long antecedencia = Duration.between(agora, dataAgendamento).toHours();

        if(antecedencia < 24) {
            throw new ValidacaoException("Instrução deve ser cancelada com antecedência mínima de 24 h!");
        }
    }
}