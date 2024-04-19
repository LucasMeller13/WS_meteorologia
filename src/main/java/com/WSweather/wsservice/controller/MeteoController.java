package com.WSweather.wsservice.controller;

import com.WSweather.wsservice.models.Data;
import com.WSweather.wsservice.models.Solicitacao;
import com.WSweather.wsservice.service.MeteoInterface;
import com.WSweather.wsservice.service.MeteoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MeteoController {

    @Autowired
    private MeteoService meteoService;

    @GetMapping("/forecast")
    public ResponseEntity<String> getWeather(){
        try{
            Data teste = meteoService.consultarDados("weather_code,temperature_2m_max,temperature_2m_min");
            return ResponseEntity.status(200).body(teste.returnJSON());
        } catch (Exception e){
            return ResponseEntity.status(500).body("Erro na requisição GET da API");
        }

    }

    @GetMapping("/ajuda")
    public ResponseEntity<String> ajuda(){
        try{
            Map<String, String> ajudaMap = new HashMap<>();
            ajudaMap.put("estudante", "Lucas Meller");
            ajudaMap.put("projeto", "WS_meteorologia");
            ObjectMapper mapper = new ObjectMapper();
            return ResponseEntity.status(200).body(mapper.writeValueAsString(ajudaMap));
        }catch (Exception e){
            return ResponseEntity.status(500).body("Erro na requisição GET.");
        }
    }

    @PostMapping("/forecast")
    public ResponseEntity<String> postWeather(@RequestBody Solicitacao solicitacao) {

        /* {
                "parametros": "weather_code,temperature_2m_max,
                               temperature_2m_min,apparent_temperature_max,
                               apparent_temperature_min,uv_index_max,
                               uv_index_clear_sky_max,precipitation_sum,
                               rain_sum,precipitation_hours,
                               precipitation_probability_max,wind_speed_10m_max"
            } */

        try {
            Data teste = meteoService.consultarDados(solicitacao.getParametros());
            return ResponseEntity.status(200).body(teste.returnJSON());
        }catch (Exception e){
            return ResponseEntity.status(500).body("Erro na requisição POST da API.");
        }

    }
}
