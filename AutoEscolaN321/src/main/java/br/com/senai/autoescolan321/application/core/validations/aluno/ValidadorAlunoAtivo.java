package br.com.senai.autoescolan321.application.core.validations.aluno;

import br.com.senai.autoescolan321.adapters.out.repository.persistence.AlunoRepository;
import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.exception.types.instrucao.ValidacaoException;
import br.com.senai.autoescolan321.application.core.validations.instrucao.interfaces.ValidadoresAgendamento;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAlunoAtivo implements ValidadoresAgendamento {
    private final AlunoRepository alunoRepository;

    public ValidadorAlunoAtivo(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        Boolean alunoAtivo = alunoRepository.findAlunoAtivo(dados.idAluno());

        if(!alunoAtivo) {
            throw new ValidacaoException("Instrução não pode ser agendada por aluno inativo!");
        }
    }
}