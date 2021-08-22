# JavaWeb-BookShop项目 

#### 介绍

学习完JavaWeb相关的知识后，便写了这个简易的书城项目。该项目是基于servlet，jsp，mysql的书城项目。主要包含的知识点有Servlet程序、Filter过滤器、jsp页面、EL表达式、JSTL标签库、jQuery框架（导入了bootstrap框架，但前端页面几乎没有怎么写）、Cookie技术、Session会话、JSON使用、Ajax请求。

总体来说该项目比较简单，也很适合初学者练手学习。



#### 开发环境

- IDEA 2020
- JDK 11.0.8
- Tomcat 8.5.45（服务器）
- druid 1.1.21（数据库连接池）
- kaptcha 2.3.2(验证码)
- commons-dbutils 1.7 （数据库操作工具）



#### 总体模块

本项目主要分为以下几个模块：

- 用户登录注册模块
- 图书管理模块
- 购物车模块
- 订单模块
- 整合支付宝支付模块

---
#### 支付宝测试环境代码测试
1.下载电脑网站的官方demo：

下载地址：https://docs.open.alipay.com/270/106291/

2.配置AlipayConfig

(1).注册蚂蚁金服开发者账号（免费）
注册地址：https://open.alipay.com ，用你的支付宝账号扫码登录，完善个人信息，选择服务类型

(2).设置app_id和gatewayUrl

(3).设置密钥
