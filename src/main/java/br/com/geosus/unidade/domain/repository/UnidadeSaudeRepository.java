package br.com.geosus.unidade.domain.repository;

import br.com.geosus.unidade.domain.entity.UnidadeSaude;

import java.util.List;
import java.util.Optional;

public interface UnidadeSaudeRepository {
    UnidadeSaude salvar(UnidadeSaude unidade);
    Optional<UnidadeSaude> buscarPorId(Long id);
    List<UnidadeSaude> listarTodos();
}
