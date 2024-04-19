# Documentação do Projeto WS_meteorologia

## Visão Geral

O projeto WS_meteorologia é uma API projetada para acessar e fornecer dados meteorológicos da cidade de Criciúma, interagindo com a API [Open Meteo](https://open-meteo.com/en/docs/#latitude=-27.5967&longitude=-48.5492&hourly=&daily=weather_code,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,precipitation_sum,rain_sum&timezone=America%2FSao_Paulo&forecast_days=1). Este documento descreve os endpoints disponibilizados pela API.

### Endpoints da API

**Obter Previsão Meteorológica Atual:**
- **Método:** GET
- **URL:** `http://localhost:8080/forecast`


**Acessar endpoint "ajuda" requisitado pelo professor:**
- **Método:** GET
- **URL:** `http://localhost:8080/ajuda`

 
**Enviar Solicitação de Dados Meteorológicos:**
- **Método:** POST
- **URL:** `http://localhost:8080/forecast`
- **Corpo da Requisição:**
  ```json
  {
      "parametros": "weather_code,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,precipitation_sum,rain_sum"
  }
