# CDSIC-WebSite

CDSIC门户网站

## 组织结构

```
CDSIC-website
├── cdsic-common -- 公共依赖，工具类及通用代码
├── cdsic-front -- cdsic宣传页
├── cdsic-third-party -- 第三方服务，例如阿里云OSS对象存储服务
├── cdsic-gateway -- 统一配置网关
├── renren-fast -- 人人开源项目
├── renren-generator -- 人人开源项目，CRUD代码生成器
```

## 架构图

![](https://gitee.com/wang-zongqin/CDSIC-WebSite/raw/master/img/SystemStruct.jpg)


## 技术选型

| 技术                    | 说明                             | 版本             |
| ----------------------- | -------------------------------- | ---------------- |
| SpringBoot              | 脚手架+MVC结构                   | 2.5.9            |
| SpringCloud             | 微服务架构                       | 2020.0.5         |
| SpringCloudAibaba Nacos | 注册、配置中心                   | 1.1.3            |
| MySQL                   | 数据库                           | 8.0              |
| MyBatis-Plus            | ORM框架                          | 3.2.0            |
| OSS                     | 阿里云对象云存储（后期可能更换） | lasted           |
| git                     | 版本控制                         | 2.34.1.windows.1 |
| docker                  | 应用容器引擎                     | 20.10.12         |
| nginx                   | 反向代理                         | 1.10             |
| Vue                     | 前端框架                         | 3.0              |
| ElementUI               | 前端UI框架                       | lasted           |
| themeleaf               | 模板引擎                         | lasted           |
| Nodejs                  | 服务端的js                       | 16.14.0          |

