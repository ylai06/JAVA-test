package org.example.restapi2.demos.controller;

import org.example.restapi2.demos.domain.Currency;
import org.example.restapi2.demos.service.CurrencyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin
@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService service;

    @GetMapping
    public List<Currency> getAllCurrencies() {
        return service.getAllCurrencies();
    }

    @GetMapping("/{id}")
    public Currency getCurrencyById(@PathVariable Long id) {
        return service.getCurrencyById(id);
    }

    @GetMapping("/code/{code}")
    public Currency getCurrencyByCode(@PathVariable String code) {
        return service.getCurrencyByCode(code);
    }

    @PostMapping
    public Currency addCurrency(@RequestBody Currency currency) {
        return service.addCurrency(currency);
    }

    @PostMapping("/update/{id}")
    public Currency updateCurrency(@PathVariable Long id, @RequestBody Currency currency) {
        return service.updateCurrency(id, currency);
    }

    @DeleteMapping("/{id}")
    public void deleteCurrency(@PathVariable Long id) {
        service.deleteCurrency(id);
    }

    @DeleteMapping("/delete")
    public void deleteCurrencyByCode(@RequestBody Map<String, String> request) {
        String code = request.get("code");
        service.deleteCurrencyByCode(code);
    }
}


