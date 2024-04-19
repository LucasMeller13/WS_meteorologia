package com.WSweather.wsservice.service;

import com.WSweather.wsservice.models.Data;

public interface MeteoInterface {
    public Data consultarDados(String parametros);
}
