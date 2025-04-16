# Boai API

### 技術框架
* Java version 18
* Spring boot 3.3.10
* Spring Security
* JWT
* Maven
* Mybatis
* postgresql
* Swagger

### 開發工具
* IntelliJ

### 版本資訊
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