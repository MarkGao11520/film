# springboot+mybatis+bootstrap实现简单电影搜索demo Edit
  Add topics


## 测试，普通环境启动
配置文件为application.yml。
### 1.将项目导入IntelliJ IDEA
### 2.打开src/main/resources下的application-dev.yml修改数据库（数据库文件在```src/main/resource/sql里```）
### 3.修改src/main/resources/static/film/js下的url.js 中的ip/域名为自己的
### 3.启动SpringBootMybatisWithRedisApplication
### 4.浏览器访问localhost:9999/

## docker 部署
```
cd docker-compose && docker-compose up
```

## 演示
- #### 电影列表地址 http://116.196.100.156:9090/static/film/html/film_list.html
- #### API文档地址 http://116.196.100.156:9090/swagger-ui.html#

