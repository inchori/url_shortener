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

create database short_url
```

**3. application.yml 설정**
+ `src/main/resources/application.yml` 파일 설정
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

## How To Run
1. http://localhost:8080/index.html 접속
2. 단축할 URL 입력
3. [URL 단축] 버튼 클릭
4. 결과 URL로 리다이렉트 원하신다면, http://localhost:8080/api/shorten/{단축된URL} 웹 페이지에 입력

## ScreenShort
+ http://localhost:8080/index.html 접속 및 URL 단축
<img width="429" alt="스크린샷 2021-11-04 오후 10 46 16" src="https://user-images.githubusercontent.com/49394875/140324756-55127b53-8488-456a-b73d-9bfb82904ca9.png">

+ 단축된 URL로 리다이렉트
<img width="445" alt="스크린샷 2021-11-04 오후 10 45 43" src="https://user-images.githubusercontent.com/49394875/140324605-f5941ea1-c952-4768-b83b-3f34ad6c754e.png">
