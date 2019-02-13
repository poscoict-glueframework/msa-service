# msa

다음 순서로 생성( https://spring.io/guides/gs/multi-module/ 참고함 )

```bash
$ cd /c/workspace       # workspace로 이동. 
$ mkdir boot-samples    # boot-samples 생성
$ cd boot-samples
$ touch pom.xml
$ mkdir apps     # apps 생성
$ mkdir demos    # demos 생성
$ mkdir services # services 생성
$ 
$ cd ~/Downloads   # spring initializr에서 생성할 프로젝트가 다운로드 되는곳으로 이동.
$ unzip config-server.zip -d /c/workspace/boot-samples/services/
$ unzip eureka-server.zip -d /c/workspace/boot-samples/services/
$ unzip zuul-proxy.zip    -d /c/workspace/boot-samples/services/
$
$ unzip hello.zip         -d /c/workspace/boot-samples/demos/
$ 
$ cd /c/workspace/boot-samples/apps     # apps 로 이동
$ cp -r /c/infra/GlueSDK/templateFolder/maven order    # order 생성
$ cp -r /c/infra/GlueSDK/templateFolder/maven payment  # payment 생성
$ cp -r /c/infra/GlueSDK/templateFolder/maven stock    # stock 생성
$ cp -r /c/infra/GlueSDK/templateFolder/maven delivery # delivery 생성
```

|a     | ProjectMeta (groupId)| ProjectMeta (artifactId) | Dependencies          |
|------|----------------------|--------------------------|-----------------------|
|spring|com.poscoict.service  |config-server             |Actuator, Config Server|
|spring|com.poscoict.service  |eureka-server             |Actuator, Eureka Server|
|spring|com.poscoict.service  |zuul-proxy                |Actuator, Eureka Discovery, Zuul|
|spring|com.poscoict.service  |all                       |Actuator, Config Server, Eureka Server, Eureka Discovery, Zuul|
|spring|com.poscoict.demo     |hello                     |Actuator, Web, Devtools|
|glue  |com.poscoict.app.biz  |order                     |Actuator, Web, JPA, Devtools, H2, Swagger|
|glue  |com.poscoict.app.biz  |payment                   |Actuator, Web, JPA, Devtools, H2, Swagger|
|glue  |com.poscoict.app.biz  |stock                     |Actuator, Web, JPA, Devtools, H2, Swagger|
|glue  |com.poscoict.app.biz  |delivery                  |Actuator, Web, JPA, Devtools, H2, Swagger|


```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.poscoict.sample</groupId>
    <artifactId>boot-samples</artifactId>
    <version>0.1.0</version>
    <packaging>pom</packaging>
    <modules>
        <module>apps</module>
        <module>demos</module>
        <module>services</module>
    </modules>
</project>
```
