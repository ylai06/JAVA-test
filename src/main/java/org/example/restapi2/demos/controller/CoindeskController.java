package org.example.restapi2.demos.controller;

import org.example.restapi2.demos.service.CoindeskService;
import org.example.restapi2.demos.util.CoindeskDataTransformer;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// http://localhost:8081/api/coindesk/getCoinData
@RestController
@RequestMapping("/api/coindesk")
public class CoindeskController {

    private final CoindeskService coindeskService;

    public CoindeskController(CoindeskService coindeskService) {
        this.coindeskService = coindeskService;
    }

    // 获取并转换 Coindesk 数据
    @GetMapping("/getCoinData")
    public Map<String, Object> getConvertedData() {
        JSONObject coindeskData = coindeskService.getCoindeskData();

        // 解析更新时间
        String updatedTime = coindeskData.getJSONObject("time").getString("updatedISO");

        // 解析汇率信息
        JSONObject bpi = coindeskData.getJSONObject("bpi");
        Map<String, Map<String, Object>> currencyInfo = new HashMap<>();

        for (String key : bpi.keySet()) {
            JSONObject currency = bpi.getJSONObject(key);
            Map<String, Object> currencyData = new HashMap<>();
            currencyData.put("code", currency.getString("code"));
            currencyData.put("name", currency.getString("description"));
            currencyData.put("rate", currency.getString("rate"));
            currencyData.put("symbol", currency.getString("symbol"));
            currencyInfo.put(key, currencyData);
        }

        // 构建返回结果
        Map<String, Object> result = new HashMap<>();
        result.put("updatedTime", updatedTime);
        result.put("currencies", currencyInfo);

        return result;
    }

}