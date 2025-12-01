package br.com.senai.autoescolan321.adapters.out.repository.entity;

import br.com.senai.autoescolan321.application.core.domain.enums.Motivo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Instrucao")
@Table(name = "instrucoes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class InstrucaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private AlunoEntity aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrutor_id")
    private InstrutorEntity instrutor;
    private LocalDateTime data;
    private Boolean cancelada = false;

    @Enumerated(EnumType.STRING)
    private Motivo motivo;

    @Column(name = "data_cancelamento")
    private LocalDateTime dataCancelamento;
}