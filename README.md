# Boai API

### 技術框架
* Java version 21
* Spring boot 3.5.5
* Spring Security
* JWT
* Maven
* Mybatis
* postgresql
* Swagger

### 開發工具
* IntelliJ

### 版本資訊
* 1.0.0
  * 對外啟用，更新Java版本至21
* 0.0.1-SNAPSHOT
  * 初版

### 執行
* 打包jar
```
mvn install
```
* build image
```
docker build -t boai-api .
```
* run 
```
docker run --name BOAI-API -p 8080:8080 -d boai-api
```