### API List:
1. 查詢所有幣別對應表的資料 -> GET http://localhost:8081/api/currencies
2. 根據ID查詢幣別對應表的資料 -> GET http://localhost:8081/api/currencies/{id} 
3. 根據Code查詢幣別對應表的資料 -> GET http://localhost:8081/api/currencies/code/{code} 
4. 新增幣別對應表的資料 -> POST http://localhost:8081/api/currencies ，JSON = {
   "code": newCode, "nameZh": newNameZh}
5. 根據ID更新幣別對應表的資料 -> POST http://localhost:8081/api/currencies/update/{id} ，JSON = {
   "code": newCode, "nameZh": newNameZh}
6. 根據ID刪除幣別對應表的資料 -> DELETE http://localhost:8081/api/currencies/{code}
7. 根據Code刪除幣別對應表的資料 -> DELETE http://localhost:8081/api/currencies/delete ，JSON = { "code": deletedCode }
8. 查詢coindesk API -> GET https://api.coindesk.com/v1/bpi/currentprice.json
9. 查詢資料轉換的API -> GET http://localhost:8081/api/coindesk

### 其他
- 使用 JUnit 和 [postman](https://www.postman.com/dark-water-495034/workspace/testcollection/request/21787422-d5ac8f6c-3514-40a3-82cb-d9939d4a0fff?action=share&creator=21787422&ctx=documentation) 測試
- 幣別與其對應中文名稱的資料表 /src/main/resources/schema.sql
- 測試數據 /src/main/resources/data.sql
- 刷新 Maven 依賴 `mvn clean install -U`