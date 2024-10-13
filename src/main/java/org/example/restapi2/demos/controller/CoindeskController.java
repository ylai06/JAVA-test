package org.example.restapi2.demos.controller;

import org.example.restapi2.demos.service.CoindeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// http://localhost:8081/api/coindesk/getCoinData
@RestController
@RequestMapping("/api")
public class CoindeskController {

    @Autowired
    private final CoindeskService coindeskService;

    public CoindeskController(CoindeskService coindeskService) {
        this.coindeskService = coindeskService;
    }

    // 新API: 呼叫coindesk的API，並進行資料轉換
    @GetMapping("/coindesk")
    public Map<String, Object> getCoindeskData() {
        return coindeskService.getCoindeskData();
    }
}