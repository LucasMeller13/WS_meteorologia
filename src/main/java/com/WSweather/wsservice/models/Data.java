package com.WSweather.wsservice.models;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Data {
    private String longitude;
    private String latitude;
    private String timezone;
    private Map<String, List<Object>> daily;

    public Data(String longitude, String latitude, String timezone, Map<String, List<Object>> daily) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.timezone = timezone;
        this.daily = daily;
    }

    public void setDaily(Map<String, List<Object>> daily) {
        this.daily = daily;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String returnJSON(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(daily);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, List<Object>> getDaily() {
        return daily;
    }

}
