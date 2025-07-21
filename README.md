# 🏥 GeoSUS - Unidade Service

Este microsserviço faz parte do sistema **GeoSUS - Fila Única com Geolocalização para o SUS**. Ele é responsável por gerenciar o cadastro e a consulta de unidades de saúde (UBS, UPA, Hospitais), incluindo geocodificação de endereços e simulação de vagas disponíveis.

## 📌 Funcionalidades

- Cadastro de unidades de saúde com geocodificação automática via API Nominatim (OpenStreetMap).
- Consulta de unidades próximas com base em coordenadas GPS e raio configurável.
- Retorno ordenado por proximidade (usando a fórmula de Haversine).
- Simulação da disponibilidade de vagas em tempo real.
- Endpoints RESTful.
- Arquitetura Limpa (Clean Architecture).

## 🧱 Arquitetura

[controller] → [application] → [domain] ←→ [infrastructure]


O projeto segue a divisão:
- `domain`: regras de negócio e entidades.
- `application`: casos de uso.
- `adapter`: entrada (controller REST) e saída (persistence, external APIs).
- `infrastructure`: implementação de gateways, configuração e integração com o banco.

## 🌐 Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/unidades` | Cadastra nova unidade (com geocodificação automática) |
| `GET`  | `/unidades/{id}` | Consulta detalhes da unidade pelo ID |
| `GET`  | `/unidades/proximas?lat={lat}&lng={lng}&raio={km}` | Lista unidades próximas da coordenada informada |

## 🧪 Testes

- Framework: JUnit 5 + Mockito.
- Cobertura: Mínimo de **80%** garantida com [JaCoCo](https://www.baeldung.com/jacoco).
- Relatórios são gerados na pasta `/target/site/jacoco`.

## 🐘 Banco de Dados

- PostgreSQL com versionamento via Flyway.
- Script de criação na pasta `resources/db/migration`.

## 🐳 Docker

### Comandos principais:

```bash
# Build da imagem
docker build -t geo-sus-unidade-service .

# Executar individualmente
docker run -p 8080:8080 geo-sus-unidade-service

# Ou use docker-compose (recomendado)
docker-compose up --build
