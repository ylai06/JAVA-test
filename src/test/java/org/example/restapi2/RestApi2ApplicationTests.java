package org.example.restapi2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.restapi2.demos.domain.Currency;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RestApi2ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

//    @Test
//    public void testGetAllCurrencies() throws Exception {
//        mockMvc.perform(get("/api/currencies")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isArray())
//                .andExpect(jsonPath("$[0].code").isNotEmpty())
//                .andExpect(jsonPath("$[0].nameZh").isNotEmpty());
//    }
//
//    @Test
//    public void testGetCurrencyById() throws Exception {
//        // 假设数据库中有 ID 为 1 的币别
//        mockMvc.perform(get("/api/currencies/1")  // 这里是通过 ID 查询
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())  // 期望状态码为 200 OK
//                .andExpect(jsonPath("$.id").value(1))  // 期望返回的 id 是 1
//                .andExpect(jsonPath("$.code").value("USD"))  // 期望返回的 code 是 "USD"
//                .andExpect(jsonPath("$.nameZh").value("美元"));  // 期望返回的 nameZh 是 "美元"
//    }
//
//    @Test
//    public void testGetCurrencyByCode() throws Exception {
//        // 假设数据库中有 code 为 USD 的币别
//        mockMvc.perform(get("/api/currencies/code/USD")  // 通过 code 查询
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())  // 期望状态码为 200 OK
//                .andExpect(jsonPath("$.code").value("USD"))  // 期望返回的 code 是 "USD"
//                .andExpect(jsonPath("$.nameZh").value("美元"));  // 期望返回的 nameZh 是 "美元"
//    }
//
//    @Test
//    public void testAddCurrency() throws Exception {
//        Currency newCurrency = new Currency();
//        newCurrency.setCode("JPY");
//        newCurrency.setNameZh("日圓");
//
//        mockMvc.perform(post("/api/currencies")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(newCurrency)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.code").value("JPY"))
//                .andExpect(jsonPath("$.nameZh").value("日元"));
//    }
//
//    @Test
//    public void testUpdateCurrency() throws Exception {
//        Currency updatedCurrency = new Currency();
//        updatedCurrency.setCode("USD");
//        updatedCurrency.setNameZh("美元更新");
//
//        mockMvc.perform(put("/api/currencies/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(updatedCurrency)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.code").value("USD"))
//                .andExpect(jsonPath("$.nameZh").value("美元更新"));
//    }
//
//    @Test
//    public void testDeleteCurrency() throws Exception {
//        mockMvc.perform(delete("/api/currencies/3")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//    }

}
