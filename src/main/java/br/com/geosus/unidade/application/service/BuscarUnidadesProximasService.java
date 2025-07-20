package br.com.geosus.unidade.application.service;

import br.com.geosus.unidade.domain.entity.UnidadeSaude;
import br.com.geosus.unidade.domain.repository.UnidadeSaudeRepository;
import br.com.geosus.unidade.domain.util.HaversineCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarUnidadesProximasService {

    private final UnidadeSaudeRepository repository;

    public List<UnidadeSaude> buscar(double latPaciente, double lngPaciente, double raioKm) {
        return repository.listarTodos().stream()
                .filter(unidade -> {
                    double distancia = HaversineCalculator.calcularDistanciaKm(
                            latPaciente, lngPaciente,
                            unidade.getLatitude(), unidade.getLongitude()
                    );
                    return distancia <= raioKm;
                })
                .toList();
    }
}
