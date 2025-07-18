package br.com.geosus.unidade.adapter.in.controller.dto;

import br.com.geosus.unidade.domain.entity.TipoUnidadeSaude;
import jakarta.validation.constraints.*;

import java.util.List;

public record CadastrarUnidadeSaudeRequest(

        @NotBlank
        String nome,

        @NotNull
        TipoUnidadeSaude tipo,

        @NotBlank
        String endereco,

        @NotEmpty
        List<@NotBlank String> servicos,

        @NotNull
        @Min(0)
        Integer vagasDisponiveis

) {
}
