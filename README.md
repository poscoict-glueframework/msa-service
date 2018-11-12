
```bash
git clone https://github.com/poscoict-glueframework/msa-service.git
``` 

```bash
mvn clean package                    # 전체빌드

mvn clean package -Pconfig-server    # config-server 만 빌드
mvn clean package -Peureka-server    # eureka-server 만 빌드 
mvn clean package -Pzuul-proxy       # zull-proxy 만 빌드

mvn clean package -Psample-service-all  # 예제 service 전체 빌드
```

```bash
java -jar config-server/target/config-server-0.0.1.jar  # config-server 실행

java -jar eureka-server/target/eureka-server-0.0.1.jar  # eureka-server 실행

java -jar zuul-proxy/target/zuul-proxy-0.0.1.jar        # zuul-proxy 실행(eureka 먼저 실행할것)
```

```bash
cd sample-service-parent/glueservice-provider-api
java -jar target/config-server-0.0.1.jar                # glueservice-provider-api 실행
```