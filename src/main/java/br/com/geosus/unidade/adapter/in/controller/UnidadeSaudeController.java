package br.com.geosus.unidade.adapter.in.controller;

import br.com.geosus.unidade.adapter.in.controller.dto.CadastrarUnidadeSaudeRequest;
import br.com.geosus.unidade.adapter.in.controller.dto.UnidadeSaudeResponse;
import br.com.geosus.unidade.adapter.out.persistence.repository.UnidadeSaudeJpaRepository;
import br.com.geosus.unidade.application.service.BuscarUnidadeService;
import br.com.geosus.unidade.application.service.CadastrarUnidadeService;
import br.com.geosus.unidade.domain.entity.UnidadeSaude;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unidades")
@RequiredArgsConstructor
public class UnidadeSaudeController {

    private final CadastrarUnidadeService cadastrarUnidadeService;
    private final BuscarUnidadeService buscarUnidadeService;


    @PostMapping
    public ResponseEntity<UnidadeSaudeResponse> cadastrar(@RequestBody @Valid CadastrarUnidadeSaudeRequest request) {
        var unidade = cadastrarUnidadeService.cadastrar(request);
        return ResponseEntity.ok(UnidadeSaudeResponse.from(unidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeSaudeResponse> buscarPorId(@PathVariable Long id) {
        return buscarUnidadeService.buscarPorId(id)
                .map(UnidadeSaudeResponse::from)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
