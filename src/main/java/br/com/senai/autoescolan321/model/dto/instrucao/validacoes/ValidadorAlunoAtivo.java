package br.com.senai.autoescolan321.model.dto.instrucao.validacoes;

import br.com.senai.autoescolan321.infra.exception.ValidacaoException;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.repository.AlunoRepository;
import br.com.senai.autoescolan321.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAlunoAtivo implements ValidadorAgendamento {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        if(dados.idAluno() == null){
            return;
        }

        Boolean alunoAtivo = alunoRepository.findAlunoAtivoById(dados.idAluno());

        if(!alunoAtivo){
            throw new ValidacaoException("Aluno não está ativo no sistema.");
        }

    }
}

