package br.com.geosus.unidade.application.service;

import br.com.geosus.unidade.adapter.in.controller.dto.CadastrarUnidadeSaudeRequest;
import br.com.geosus.unidade.domain.entity.TipoUnidadeSaude;
import br.com.geosus.unidade.domain.entity.UnidadeSaude;
import br.com.geosus.unidade.domain.repository.Geocodificador;
import br.com.geosus.unidade.domain.repository.UnidadeSaudeRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastrarUnidadeService {

    private final UnidadeSaudeRepository repository;
    private final Geocodificador geocodificador;

    public CadastrarUnidadeService(UnidadeSaudeRepository repository, Geocodificador geocodificador) {
        this.repository = repository;
        this.geocodificador = geocodificador;
    }

    public UnidadeSaude cadastrar(CadastrarUnidadeSaudeRequest request) {
        var coordenadas = geocodificador.obterCoordenadas(request.endereco());

        UnidadeSaude unidade = UnidadeSaude.builder()
                .nome(request.nome())
                .tipo(request.tipo())
                .endereco(request.endereco())
                .latitude(coordenadas.latitude())
                .longitude(coordenadas.longitude())
                .vagasDisponiveis(request.vagasDisponiveis())
                .servicos(request.servicos())
                .build();


        return repository.salvar(unidade);
    }
}
