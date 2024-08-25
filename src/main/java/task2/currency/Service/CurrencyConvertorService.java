/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task2.currency.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

/**
 *
 * @author Fatema
 */
@Service
public class CurrencyConvertorService {

    @Value("${currency.api.url}")
    private String apiUrl;

    @Value("${currency.api.app-id}")
    private String appId;

    private final RestTemplate restTemplate;

    public CurrencyConvertorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        String url = String.format("%s?app_id=%s", apiUrl, appId);
        String response = restTemplate.getForObject(url, String.class);
        
        JSONObject jsonObject = new JSONObject(response);
        JSONObject rates = jsonObject.getJSONObject("rates");
        double fromRate = rates.getDouble(fromCurrency);
        double toRate = rates.getDouble(toCurrency);
        
        return amount / fromRate * toRate;
    }
}

