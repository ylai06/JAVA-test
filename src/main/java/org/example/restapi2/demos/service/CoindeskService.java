package org.example.restapi2.demos.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoindeskService {
    private static final String COINDESK_API_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

    // 调用 Coindesk API 并返回数据
    public JSONObject getCoindeskData() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(COINDESK_API_URL, String.class);
        return new JSONObject(response);  // 返回解析后的 JSON 对象
    }
}
