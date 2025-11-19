package br.com.senai.autoescolan321.application.core.domain.model;

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
public class Instrucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;
    private LocalDateTime data;
    private Boolean cancelada = false;

    @Enumerated(EnumType.STRING)
    private Motivo motivo;

    @Column(name = "data_cancelamento")
    private LocalDateTime dataCancelamento;

    public void cancelar(Motivo motivo) {
        this.cancelada = true;
        this.motivo = motivo;
        this.dataCancelamento = LocalDateTime.now();
    }
}