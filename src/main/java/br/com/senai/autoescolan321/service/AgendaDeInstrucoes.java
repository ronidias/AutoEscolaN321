package br.com.senai.autoescolan321.service;


import br.com.senai.autoescolan321.domain.Aluno;
import br.com.senai.autoescolan321.domain.Instrucao;
import br.com.senai.autoescolan321.domain.Instrutor;
import br.com.senai.autoescolan321.infra.exception.AlunoNaoExisteException;
import br.com.senai.autoescolan321.infra.exception.EspecialidadeNaoInformadaException;
import br.com.senai.autoescolan321.infra.exception.InstrutorIndisponivelException;
import br.com.senai.autoescolan321.infra.exception.InstrutorNaoExisteException;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosDetalahamentoInstrucao;
import br.com.senai.autoescolan321.model.dto.instrucao.validacoes.ValidadoresAgendamento;
import br.com.senai.autoescolan321.repository.AlunoRepository;
import br.com.senai.autoescolan321.repository.InstrucaoRepository;
import br.com.senai.autoescolan321.repository.InstrutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AgendaDeInstrucoes {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private InstrutorRepository instrutorRepository;
    @Autowired
    private InstrucaoRepository instrucaoRepository;
    @Autowired
    private List<ValidadoresAgendamento> validadoresAgendamentoList;

    @Transactional
    public DadosDetalahamentoInstrucao agendar(DadosAgendamentoInstrucao dados) {

        if(!alunoRepository.existsById(dados.idAluno())){
            throw new AlunoNaoExisteException("ID informado não existe!");
        }
        if(dados.idInstrutor()!= null && !instrutorRepository.existsById(dados.idInstrutor())){
            throw new InstrutorNaoExisteException("ID informado não existe");
        }
        validadoresAgendamentoList.forEach(v -> v.validar(dados));

        Aluno aluno = alunoRepository.getReferenceById(dados.idAluno());
        Instrutor instrutor = escolherInstrutor(dados);
        if(instrutor == null){
            throw new InstrutorIndisponivelException("Nenhum instrutor disponível para a especialidade informada na data escolhida!");
        }

        Instrucao instrucao = new Instrucao(null, aluno, instrutor, dados.data(), false);
        instrucaoRepository.save(instrucao);
        return new DadosDetalahamentoInstrucao(instrucao);
    }
    private Instrutor escolherInstrutor(DadosAgendamentoInstrucao dados) {
        if(dados.idInstrutor()!=null){
            return instrutorRepository.getReferenceById(dados.idInstrutor());
        }
        if(dados.especialidade() == null){
            throw new EspecialidadeNaoInformadaException("Especialidade obrigatória, quando o instrutor não for informado!");

        }
        return instrutorRepository.escolherInstrutorDisponivel(dados.especialidade(), dados.data());
    }

}
