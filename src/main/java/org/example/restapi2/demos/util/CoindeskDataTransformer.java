package org.example.restapi2.demos.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CoindeskDataTransformer {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static Map<String, Object> transformData(Map<String, Object> coindeskData, Map<String, String> currencyNameMap) {
        Map<String, Object> transformedData = new HashMap<>();

        // 解析时间
        Map<String, String> time = (Map<String, String>) coindeskData.get("time");
        Date updatedTime = new Date();
        try {
            updatedTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").parse(time.get("updatedISO"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        transformedData.put("updatedTime", dateFormat.format(updatedTime));

        // 解析币种信息并使用动态加载的中文名称映射
        Map<String, Map<String, Object>> bpi = (Map<String, Map<String, Object>>) coindeskData.get("bpi");
        Map<String, Object> currencies = new HashMap<>();

        for (String currencyCode : bpi.keySet()) {
            Map<String, Object> currencyData = bpi.get(currencyCode);
            Map<String, Object> transformedCurrencyData = new HashMap<>();
            transformedCurrencyData.put("code", currencyCode);
            transformedCurrencyData.put("name", currencyNameMap.getOrDefault(currencyCode, "未知货币"));
            transformedCurrencyData.put("rate", currencyData.get("rate"));
            currencies.put(currencyCode, transformedCurrencyData);
        }

        transformedData.put("currencies", currencies);
        return transformedData;
    }
}
