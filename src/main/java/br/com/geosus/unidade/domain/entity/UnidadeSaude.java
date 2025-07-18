package br.com.geosus.unidade.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeSaude {

    private Long id;
    private String nome;
    private TipoUnidadeSaude tipo;
    private String endereco;
    private Double latitude;
    private Double longitude;
    private List<String> servicos;
    private Integer vagasDisponiveis;

}
