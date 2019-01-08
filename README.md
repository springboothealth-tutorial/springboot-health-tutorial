# springboot-health-tutorial
* [springboot-health-tutorial](#springboot-health-tutorial)
   * [1. 概况](#1-概况)
   * [2. 环境](#2-环境)
   * [3. 详情](#3-详情)
      * [3.1 基础篇](#31-基础篇)
      * [3.2 项目篇](#32-项目篇)
      * [3.3 课程大纲](#33-课程大纲)
      * [3.4 功能介绍](#34-功能介绍)
   * [4. 里程碑节点](#4-里程碑节点)

# 1. 概况

​	本课程分为基础篇、项目篇两部分。基本篇五次课程分别介绍Spring Boot快速入门、基础Web开发、单元测试、过滤器、拦截器、监听器、整合Mybatis。项目篇是一个前后端分离的的用户健康管理系统，后端基于Spring Boot和Mybatis、前端基于react、AntD，分为用户端和健康指导员端两端。用户端需要两次课为大家讲解，健康指导员端需要一次课，登录注册功能需要一次课，最后前端页面展示需要一次课，通过这五次课为大家展示一个完整的项目开发测试流程。

# 2. 环境

- 后端
  - Eclipse Neon.2 Release (4.6.2)
  - Java 8
  - Maven 3.5
  - Spring Boot 2.0.6
  - Mybatis 3.4.6
  - MySQL 5.7
  - curl 7.63.0
- 前端
  - react
  - AntD
  - echarts

# 3. 详情

## 3.1 基础篇

- [x] [lesson1 - Spring Boot快速入门](./lesson-1/lesson-1.md)
- [ ] [lesson2 - Spring Boot基础Web开发]()
- [ ] [lesson3 - Spring Boot单元测试]()
- [ ] [lesson4 - Spring Boot过滤器、拦截器、监听器]()
- [x] [lesson5 - Spring Boot整合Mybatis](./lesson-5/lesson-5.md)

## 3.2 项目篇

- [x] [lesson6 - 后台接口开发（用户侧1）](./lesson-6/lesson-6.md)
- [x] [lesson7 - 后台接口开发（用户侧2）]()
- [x] [lesson8 - 后台接口开发（健康指导员侧）]()
- [ ] [lesson9 - 后台接口开发（登录、注册）]()
- [ ] [lesson10 - 前端页面开发]()

## 3.3 课程大纲

|  序号  |           名称           |                   知识点                    |
| :--: | :--------------------: | :--------------------------------------: |
|  1   |    Spring Boot 快速入门    | 1.Spring Boot 基本介绍 2.maven构建项目 3.Spring Boot目录结构介绍 |
|  2   |  Spring Boot 基础Web开发   |   1.Spring Boot 基础HTTP开发 2.开发工具Curl介绍    |
|  3   |    Spring Boot 单元测试    | 1.Spring Boot Service测试 2.Spring Boot Controller测试 3.单元测试回滚 |
|  4   | Spring Boot过滤器、拦截器、监听器 |             1、过滤器、拦截器、监听器介绍              |
|  5   |  Spring Boot整合Mybatis  | 1.搭建实验平台 2.Mybatis 基本介绍  3.Mybatis 级联查询  |
|  6   |      后端接口开发（用户侧1）      | 1.Spring Boot 基础HTTP开发、常用配置 2.Spring Boot 热部署 3.Mybatis 基础配置及CURD操作 4.Mybatis分页 |
|  7   |      后端接口开发（用户侧2）      |  1.Spring Boot 基础HTTP开发 2.Mybatis 级联查询   |
|  8   |     后端接口开发（健康指导员侧）     |    1.事务、隔离级别介绍 2.事务实战 3.Mybatis 级联查询     |
|  9   |     后端接口开发（登录、注册）      |   1.Spring Boot整合redis 2.基于token实现单点登录   |
|  10  |         前端页面开发         |   1.React基本使用 2.Antd基本使用3.echarts基本使用    |

## 3.4 功能介绍

- 用户端
  - 用户上传基本初始信息（性别、年龄、身高、体重、血压、血糖、心率）
  - 更新用户体重、血压、血糖、心率
  - 日常使用主要功能
    - 饮食
      - 显示食物图片、单位热量（XXX千卡/100克）
      - 用户记录饮食
    - 运动
      - 显示运动图标、单位时间消耗热量（XXX千卡/60分钟）
      - 用户记录运动情况
  - 用户主要生理指标与每日摄入热量关系图
  - 排行榜
- 健康指导员
  - 显示所有被指导者基本信息
  - 显示被指导者近期饮食情况
  - 显示被指导者近期主要生理指标
  - 显示被指导者主要生理指标与每日摄入热量关系图

# 4. 里程碑节点

- [x] 2018年12月19日之前交付《基于springboot+Mybatis的健康管理平台》 实验一、五、六代码和文档；
- [x] 2018 年1月4日之前交付《基于springboot+Mybatis的健康管理平台》 实验七、八代码和文档；
- [ ] 2018 年1月11日之前交付《基于springboot+Mybatis的健康管理平台》 实验九、十代码和文档；
- [ ] 2018 年1月18日之前交付《基于springboot+Mybatis的健康管理平台》 实验二、三、四代码和文档