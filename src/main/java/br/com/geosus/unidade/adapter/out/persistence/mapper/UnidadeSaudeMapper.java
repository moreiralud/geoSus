package br.com.geosus.unidade.adapter.out.persistence.mapper;

import br.com.geosus.unidade.adapter.out.persistence.entity.UnidadeSaudeJpaEntity;
import br.com.geosus.unidade.domain.entity.UnidadeSaude;

public class UnidadeSaudeMapper {

    public static UnidadeSaudeJpaEntity toEntity(UnidadeSaude domain) {
        return UnidadeSaudeJpaEntity.builder()
                .id(domain.getId())
                .nome(domain.getNome())
                .tipo(domain.getTipo())
                .endereco(domain.getEndereco())
                .latitude(domain.getLatitude())
                .longitude(domain.getLongitude())
                .vagasDisponiveis(domain.getVagasDisponiveis())
                .servicos(domain.getServicos())
                .build();
    }

    public static UnidadeSaude toDomain(UnidadeSaudeJpaEntity entity) {
        return UnidadeSaude.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .tipo(entity.getTipo())
                .endereco(entity.getEndereco())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .vagasDisponiveis(entity.getVagasDisponiveis())
                .servicos(entity.getServicos())
                .build();
    }
}
