package org.example.restapi2.demos.service;

import org.example.restapi2.demos.domain.Currency;
import org.example.restapi2.demos.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    // 顯示所有資料
    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    // 根據ID查找
    public Currency getCurrencyById(Long id) {
        Optional<Currency> currency = currencyRepository.findById(id);
        return currency.orElse(null);  // 如果找不到，返回null
    }

    // 根據Code查找
    public Currency getCurrencyByCode(String code) {
        return currencyRepository.findByCode(code);
    }

    // 添加
    public Currency addCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    // 更新
    public Currency updateCurrency(Long id, Currency newCurrencyData) {
        return currencyRepository.findById(id).map(currency -> {
            currency.setCode(newCurrencyData.getCode());
            currency.setNameZh(newCurrencyData.getNameZh());
            return currencyRepository.save(currency);
        }).orElseGet(() -> {
            // 如果币种不存在，则添加新的记录
            newCurrencyData.setId(id);
            return currencyRepository.save(newCurrencyData);
        });
    }

    // 根據ID刪除
    public void deleteCurrency(Long id) {
        currencyRepository.deleteById(id);
    }

    // 根據Code刪除
    public void deleteCurrencyByCode(String code) {
        Currency currency = currencyRepository.findByCode(code);
        currencyRepository.deleteById(currency.getId());
    }
}
