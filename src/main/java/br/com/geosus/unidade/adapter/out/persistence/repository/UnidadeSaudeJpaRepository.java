package br.com.geosus.unidade.adapter.out.persistence.repository;

import br.com.geosus.unidade.adapter.out.persistence.entity.UnidadeSaudeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeSaudeJpaRepository extends JpaRepository<UnidadeSaudeJpaEntity, Long> {

}
