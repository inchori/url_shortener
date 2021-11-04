# url_shortener
스마일게이트 데브캠프 2기 과제 URL Shortener

기간 : 2021.11.01 ~ 2021.11.04

문의 : sic61695@gmail.com

## Requirements
1. Java - OpenJDK 11.0.9
2. Spring - 2.5.
3. MySQL - 8.0.27
4. Frontend - HTML, Javascript
5. Intellij

## Configuration

**1. 레포지토리 클론 & 프로젝트 폴더로 이동**
```bash
git clone https://github.com/inchori/url_shortener.git

cd url_shortener
```

**2. MySQL DB 생성**
```bash
mysql -uroot -p

create database
```

**3. application.yml 설정**
```yaml
server:
  port: 8080
  host: localhost

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password:
    url: jdbc:mysql://localhost:3306/short_url

  jpa:
    hibernate:
      ddl-auto: create
    generate-ddl: true
    show-sql: true
    database-platform: org.hibernate.dialect.MySQL8Dialect
```

**4. 빌드 & 실행**
```bash
./gradlew build

cd build/libs

java -jar urlshortener-0.0.1-SNAPSHOT.jar
```
