package org.example.restapi2.demos.service;

import org.example.restapi2.demos.domain.Currency;
import org.example.restapi2.demos.repository.CurrencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import org.springframework.beans.factory.annotation.Autowired;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class CoindeskService {

    @Autowired
    private CurrencyRepository currencyRepository;

    private static final String COINDESK_API_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

    public Map<String, Object> getCoindeskData() {
        Map<String, Object> result = new HashMap<>();

        // 呼叫 Coindesk API
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> coindeskData = restTemplate.getForObject(COINDESK_API_URL, Map.class);

        // 取得更新時間並格式化 yyyy/mm/dd hh:mm:ss
        Map<String, Object> timeData = (Map<String, Object>) coindeskData.get("time");
        String updatedISO = (String) timeData.get("updatedISO");
        String formattedTime = formatDate(updatedISO);
        result.put("updateTime", formattedTime);

        // 取得幣別相關資訊
        Map<String, Object> bpiData = (Map<String, Object>) coindeskData.get("bpi");
        Map<String, Object> currencyInfo = new HashMap<>();
        for (String code : bpiData.keySet()) {
            Map<String, Object> currencyData = (Map<String, Object>) bpiData.get(code);

            // 根據 code 查詢幣別中文名稱
            String codeStr = (String) currencyData.get("code");
            Currency currency = currencyRepository.findByCode(codeStr);
            String nameZh = currency != null ? currency.getNameZh() : "未知";

            Map<String, Object> currencyDetail = new HashMap<>();
            currencyDetail.put("code", codeStr);
            currencyDetail.put("nameZh", nameZh);
            currencyDetail.put("rate", currencyData.get("rate"));

            currencyInfo.put(codeStr, currencyDetail);
        }

        result.put("currencies", currencyInfo);
        return result;
    }

    // 格式化時間
    private String formatDate(String isoDate) {
        try {
            SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
            Date date = isoFormat.parse(isoDate);
            SimpleDateFormat customFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            return customFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
