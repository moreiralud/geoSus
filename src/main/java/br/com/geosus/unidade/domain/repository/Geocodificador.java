package br.com.geosus.unidade.domain.repository;

import br.com.geosus.unidade.domain.entity.Coordenadas;

public interface Geocodificador {
    Coordenadas obterCoordenadas(String endereco);
}
