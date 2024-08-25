/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task2.currency.Controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import task2.currency.DTO.ConversionRequest;
import task2.currency.DTO.ConversionResponse;

/**
 *
 * @author Fatema
 */
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import task2.currency.Service.CurrencyConvertorService;

@RequestMapping("/api/currency")
@RestController
public class CurrencyConvertorController {

    private final CurrencyConvertorService conversionService;

    public CurrencyConvertorController(CurrencyConvertorService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/convert")
    public ResponseEntity<Double> convert(
        @RequestParam double amount,
        @RequestParam String fromCurrency,
        @RequestParam String toCurrency) {
        
        double convertedAmount = conversionService.convertCurrency(amount, fromCurrency, toCurrency);
        return ResponseEntity.ok(convertedAmount);
    }
}
