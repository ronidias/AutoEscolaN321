package br.com.senai.autoescolan321.adapters.out.repository.mapper;

import br.com.senai.autoescolan321.adapters.out.repository.entity.InstrutorEntity;
import br.com.senai.autoescolan321.application.core.domain.model.Instrutor;
import org.springframework.stereotype.Component;

@Component
public class InstrutorEntityMapper {
    public InstrutorEntity toEntity(Instrutor instrutor) {
        return new InstrutorEntity(
                instrutor.getId(),
                instrutor.getAtivo(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getTelefone(),
                instrutor.getCnh(),
                instrutor.getEspecialidade(),
                instrutor.getEndereco()
        );
    }

    public Instrutor toDomain(InstrutorEntity entity) {
        return new Instrutor(
                entity.getId(),
                entity.getAtivo(),
                entity.getNome(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getCnh(),
                entity.getEspecialidade(),
                entity.getEndereco()
        );
    }
}