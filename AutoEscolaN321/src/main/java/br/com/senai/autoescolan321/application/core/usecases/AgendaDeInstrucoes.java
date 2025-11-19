package br.com.senai.autoescolan321.application.core.usecases;

import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosCancelamentoInstrucao;
import br.com.senai.autoescolan321.adapters.in.controller.response.instrucao.DadosDetalhamentoCancelamento;
import br.com.senai.autoescolan321.adapters.in.controller.response.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.InstrucaoRepository;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.InstrutorRepository;
import br.com.senai.autoescolan321.application.core.domain.model.Aluno;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.AlunoRepository;
import br.com.senai.autoescolan321.application.core.domain.model.Instrucao;
import br.com.senai.autoescolan321.application.core.domain.model.Instrutor;
import br.com.senai.autoescolan321.exception.types.instrucao.InstrucaoNaoExisteException;
import br.com.senai.autoescolan321.application.core.validations.instrucao.interfaces.ValidadoresAgendamento;
import br.com.senai.autoescolan321.application.core.validations.instrucao.interfaces.ValidadoresCancelamento;
import br.com.senai.autoescolan321.exception.types.aluno.AlunoNaoExisteException;
import br.com.senai.autoescolan321.exception.types.instrucao.EspecialidadeNaoInformadaException;
import br.com.senai.autoescolan321.exception.types.instrucao.InstrutorIndisponivelException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeInstrucoes {
    private final AlunoRepository alunoRepository;
    private final InstrutorRepository instrutorRepository;
    private final InstrucaoRepository instrucaoRepository;
    private final List<ValidadoresAgendamento> validadoresAgendamento;
    private final List<ValidadoresCancelamento> validadoresCancelamento;

    public AgendaDeInstrucoes(
            AlunoRepository alunoRepository,
            InstrutorRepository instrutorRepository,
            InstrucaoRepository instrucaoRepository,
            List<ValidadoresAgendamento> validadoresAgendamento,
            List<ValidadoresCancelamento> validadoresCancelamento) {
        this.alunoRepository = alunoRepository;
        this.instrutorRepository = instrutorRepository;
        this.instrucaoRepository = instrucaoRepository;
        this.validadoresAgendamento = validadoresAgendamento;
        this.validadoresCancelamento = validadoresCancelamento;
    }

    @Transactional
    public DadosDetalhamentoInstrucao agendar(DadosAgendamentoInstrucao dados) {

        validadoresAgendamento.forEach(v -> v.validar(dados));

        Aluno aluno = alunoRepository.findById(dados.idAluno())
                .orElseThrow(() -> new AlunoNaoExisteException("ID do aluno informado não existe!"));
        Instrutor instrutor = escolherInstrutor(dados);
        if(instrutor == null) {
            throw new InstrutorIndisponivelException("Não existe instrutor disponível nessa data e horário!");
        }
        Instrucao instrucao = new Instrucao(null, aluno, instrutor, dados.data(), false, null, null);
        instrucaoRepository.save(instrucao);
        return new DadosDetalhamentoInstrucao(instrucao);
    }

    @Transactional
    public DadosDetalhamentoCancelamento cancelar(DadosCancelamentoInstrucao dados) {

        validadoresCancelamento.forEach(v -> v.validar(dados));

        Instrucao instrucao = instrucaoRepository.findById(dados.id())
                .orElseThrow(() -> new InstrucaoNaoExisteException("ID da instrução informado não existe!"));
        instrucao.cancelar(dados.motivo());
        instrucaoRepository.save(instrucao);
        return new DadosDetalhamentoCancelamento(instrucao);
    }

    private Instrutor escolherInstrutor(DadosAgendamentoInstrucao dados) {
        if(dados.idInstrutor() != null) {
            return instrutorRepository.findById(dados.idInstrutor())
                    .orElseThrow(() -> new InstrucaoNaoExisteException("ID do instrutor informado não existe!"));
        }
        if(dados.especialidade() == null) {
            throw new EspecialidadeNaoInformadaException("Especialidade é obrigatória, quando o instrutor não for informado!");
        }
        return instrutorRepository.escolherInstrutorDisponivel(dados.especialidade(), dados.data());
    }
}