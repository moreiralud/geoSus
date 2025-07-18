package br.com.geosus.unidade.adapter.out.persistence;

import br.com.geosus.unidade.adapter.out.persistence.entity.UnidadeSaudeJpaEntity;
import br.com.geosus.unidade.adapter.out.persistence.mapper.UnidadeSaudeMapper;
import br.com.geosus.unidade.adapter.out.persistence.repository.UnidadeSaudeJpaRepository;
import br.com.geosus.unidade.domain.entity.UnidadeSaude;
import br.com.geosus.unidade.domain.repository.UnidadeSaudeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("CustomUnidadeSaudeRepository")
@RequiredArgsConstructor
public class UnidadeSaudeRepositoryImpl implements UnidadeSaudeRepository {

    private final UnidadeSaudeJpaRepository jpaRepository;

    @Override
    public UnidadeSaude salvar(UnidadeSaude unidade) {
        UnidadeSaudeJpaEntity entity = UnidadeSaudeMapper.toEntity(unidade);
        UnidadeSaudeJpaEntity saved = jpaRepository.save(entity);
        return UnidadeSaudeMapper.toDomain(saved);
    }

    @Override
    public Optional<UnidadeSaude> buscarPorId(Long id) {
        return jpaRepository.findById(id)
                .map(UnidadeSaudeMapper::toDomain);
    }

    @Override
    public List<UnidadeSaude> listarTodos() {
        return jpaRepository.findAll()
                .stream()
                .map(UnidadeSaudeMapper::toDomain)
                .collect(Collectors.toList());
    }

    // Outros métodos se necessário...
}
