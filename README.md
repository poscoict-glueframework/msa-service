
```bash
git clone
``` 

```bash
mvn clean package                    # ÀüÃ¼ºôµå

mvn clean package -Pconfig-server    # config-server ¸¸ ºôµå
mvn clean package -Peureka-server    # eureka-server ¸¸ ºôµå 
mvn clean package -Pzuul-proxy       # zull-proxy ¸¸ ºôµå

mvn clean package -Psample-service-all  # ¿¹Á¦ service ÀüÃ¼ ºôµå
```