package org.example.restapi2.demos.domain;

import lombok.Data;

@Data
public class CurrencyVO {
    private Long id;  // 自增主鍵

    private String code;  // 幣別代碼 (如 USD, EUR)
    private String nameZh;  // 中文名稱
}
