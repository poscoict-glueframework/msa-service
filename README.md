
```bash
git clone
``` 

```bash
mvn clean package                    # ��ü����

mvn clean package -Pconfig-server    # config-server �� ����
mvn clean package -Peureka-server    # eureka-server �� ���� 
mvn clean package -Pzuul-proxy       # zull-proxy �� ����

mvn clean package -Psample-service-all  # ���� service ��ü ����
```