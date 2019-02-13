
created by Spring Initailizr.

created at 2019.02.13.

http://poscoict-glueframework.github.io/5.1/docs/spring-cloud-config.html 의 예제입니다. 

```bash
$ cd /c/workspace
$ mkdir config-repo
$ cd config-repo
$ git init .
$ git add -A .
$ echo greeting: ohai > demo.properties
$ echo server.port:8080 >> demo.properties
$ echo logging.level.ROOT: INFO >> demo.properties
$ echo logging.level.com.poscoict.sample: TRACE >> demo.properties
$ git commit -m "Add application.propertie"
```

```bash
$ curl localhost:8888/demo-default.properties
```