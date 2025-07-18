package br.com.geosus.unidade.application.service;

import br.com.geosus.unidade.domain.entity.UnidadeSaude;
import br.com.geosus.unidade.domain.repository.UnidadeSaudeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscarUnidadeService {

    private final UnidadeSaudeRepository repository;

    public Optional<UnidadeSaude> buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }
}
