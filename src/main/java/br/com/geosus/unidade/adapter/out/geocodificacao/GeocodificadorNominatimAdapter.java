package br.com.geosus.unidade.adapter.out.geocodificacao;

import br.com.geosus.unidade.domain.entity.Coordenadas;
import br.com.geosus.unidade.domain.repository.Geocodificador;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@Component
public class GeocodificadorNominatimAdapter implements Geocodificador {

    private final RestTemplate restTemplate;

    private static final String BASE_URL = "https://nominatim.openstreetmap.org/search";

    public GeocodificadorNominatimAdapter() {
        this.restTemplate = new RestTemplate();
        this.restTemplate.setInterceptors(List.of(
                (request, body, execution) -> {
                    request.getHeaders().add("User-Agent", "GeoSUS/1.0 (seu-email@exemplo.com)");
                    return execution.execute(request, body);
                }
        ));
    }

    @Override
    public Coordenadas obterCoordenadas(String endereco) {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("q", endereco)
                .queryParam("format", "json")
                .queryParam("limit", 1)
                .build()
                .encode()
                .toUri();

        try {
            var response = restTemplate.getForObject(uri, NominatimResponse[].class);
            if (response != null && response.length > 0) {
                var resultado = response[0];
                return new Coordenadas(Double.parseDouble(resultado.lat()), Double.parseDouble(resultado.lon()));
            }
        } catch (Exception e) {
            log.error("Erro ao geocodificar endereço: {}", endereco, e);
        }

        return new Coordenadas(0.0, 0.0); // fallback se falhar
    }

    private record NominatimResponse(String lat, String lon) {}
}
