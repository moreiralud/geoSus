package br.com.geosus.unidade.adapter.out.persistence.entity;

import br.com.geosus.unidade.domain.entity.TipoUnidadeSaude;
import br.com.geosus.unidade.domain.entity.UnidadeSaude;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "unidades_saude")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadeSaudeJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUnidadeSaude tipo;

    private String endereco;
    private Double latitude;
    private Double longitude;
    private Integer vagasDisponiveis;

    @ElementCollection
    @CollectionTable(
            name = "unidade_saude_servicos",
            joinColumns = @JoinColumn(name = "unidade_saude_id")
    )
    @Column(name = "servicos")
    private List<String> servicos;

    // 🔁 Converte de entidade de domínio para JPA
    public static UnidadeSaudeJpaEntity fromDomain(UnidadeSaude domain) {
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

    // 🔁 Converte de JPA para entidade de domínio
    public UnidadeSaude toDomain() {
        return UnidadeSaude.builder()
                .id(this.id)
                .nome(this.nome)
                .tipo(this.tipo)
                .endereco(this.endereco)
                .latitude(this.latitude)
                .longitude(this.longitude)
                .vagasDisponiveis(this.vagasDisponiveis)
                .servicos(this.servicos)
                .build();
    }
}
