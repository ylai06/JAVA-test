package org.example.restapi2.demos.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 自增主鍵

    private String code;  // 幣別代碼 (如 USD, EUR)
    private String nameZh;  // 中文名稱
}

