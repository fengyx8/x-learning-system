### 1. 环境依赖

| 名称 | 版本  | 官网                                                         |
| ---- | ----- | ------------------------------------------------------------ |
|Java Development Kit (JDK)|1.8.0| https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html |
|Maven|3.6.3|https://maven.apache.org/download.cgi|
|Redis|5.0.8|https://redis.io/download|
|MySQL|8.0.20|https://dev.mysql.com/downloads/mysql/|
|Python|3.8|https://www.python.org/downloads/|

### 2. 初始配置

- 在`MySQL`中运行`back-end`目录下的`init.sql`脚本初始化数据库
- 通过运行`import_data/src/main/java/com/example/rwredis/`路径下的`Write2Redis.java`,`WriteQuestion2Mysql.java`,`WriteNews2Mysql.java`,将数据录入数据库中
- 将`back-end/src/main/resources/application.yml`等三个文件内的数据库配置改为实际配置

### 3. 编译运行

在`back-end`目录下：

> 1. 执行`mvn compile`编译源码生成二进制文件
> 2. 执行`mvn spring-boot:run`命令启动服务
> 3. 若环境配置没有问题，控制台将会输出运行日志。可以在第2步中使用重定向命令将日志输出到文件
