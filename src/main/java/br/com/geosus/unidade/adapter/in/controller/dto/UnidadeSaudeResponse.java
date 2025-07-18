package br.com.geosus.unidade.adapter.in.controller.dto;

import br.com.geosus.unidade.domain.entity.TipoUnidadeSaude;
import br.com.geosus.unidade.domain.entity.UnidadeSaude;

import java.util.List;

public record UnidadeSaudeResponse(
        Long id,
        String nome,
        TipoUnidadeSaude tipo,
        String endereco,
        Double latitude,
        Double longitude,
        Integer vagasDisponiveis,
        List<String> servicos
) {
    public static UnidadeSaudeResponse from(UnidadeSaude unidade) {
        return new UnidadeSaudeResponse(
                unidade.getId(),
                unidade.getNome(),
                unidade.getTipo(),
                unidade.getEndereco(),
                unidade.getLatitude(),
                unidade.getLongitude(),
                unidade.getVagasDisponiveis(),
                unidade.getServicos()
        );
    }
}
