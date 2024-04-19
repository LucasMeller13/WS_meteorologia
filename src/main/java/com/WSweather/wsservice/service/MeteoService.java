package com.WSweather.wsservice.service;

import com.WSweather.wsservice.models.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Service
public class MeteoService implements MeteoInterface {
    private RestClient client = RestClient.create("https://api.open-meteo.com/v1/forecast");

    @Override
    public Data consultarDados(String parametros){
        String uriTemplate = "/?latitude=-27.5967&longitude=-48.5492&daily={parameters}&forecast_days=1";
        try {
            return client
                    .get()
                    .uri(uriTemplate, parametros)
                    .retrieve()
                    .body(Data.class);
        }catch (HttpClientErrorException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
