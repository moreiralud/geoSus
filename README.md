# GeoSUS – Fila Única com Geolocalização para o SUS 🏥📍

Sistema desenvolvido em Java com Spring Boot para auxiliar o direcionamento de pacientes para unidades de saúde próximas com vagas disponíveis.

---

## 📌 Funcionalidades

- Cadastro de unidades de saúde (UBS, UPA, Hospital)
- Geocodificação automática de endereços via API Nominatim (OpenStreetMap)
- Cálculo de distância entre o paciente e as unidades com base na fórmula de Haversine
- Consulta de unidades disponíveis dentro de um raio definido
- Simulação de vagas disponíveis
- APIs RESTful com Swagger

---

## 🛠️ Tecnologias e Ferramentas

- Java 17
- Spring Boot 3
- PostgreSQL + Flyway
- API Nominatim (Geocodificação)
- Docker + Docker Compose
- Jacoco (Cobertura de testes)
- Arquitetura limpa (Domain, Application, Adapters, Infrastructure)

---

## ▶️ Como rodar o projeto

### Pré-requisitos

- Docker
- Docker Compose
- Java 17
- Maven

### Subindo o ambiente

```bash
# Clonar o repositório
git clone git@github.com:moreiralud/geosus.git
cd geosus/unidade-service

# Subir banco de dados
docker-compose up -d

# Rodar aplicação localmente
./mvnw spring-boot:run
