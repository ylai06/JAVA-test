CREATE TABLE IF NOT EXISTS currency (
      id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
      code VARCHAR(10) NOT NULL, -- 幣種代碼，設定為唯一
      name_zh VARCHAR(50) NOT NULL -- 幣種的中文名稱
);




