# demo

#### 介绍
Java项目模板：SpringBoot, MyBatis-Plus, Redis, Logback, Hutool, Swagger-UI

* master: 线上
* beta: 测试
* other: 各自分支

#### 使用说明
1. 拉取项目到本地: git clone xxx 
2. 用 idea 打开项目，在 terminal 里面输入 mvn archetype:create-from-project
3. 脚手架项目编译成功后到 install 到本地
    1. cd target/generated-sources/archetype
    2. mvn install
4. 用 idea 打开一个新窗口准备使用脚手架新建工程
5. 新建 maven 项目，勾选 create from archetype，点击 add Archetype 输入
    ```
    groupId : com.plus
    artifactId : plus-template-archetype
    version : 0.0.1-SNAPSHOT
    ```
6. 选择添加的骨架新建项目，在配置中心配置相关项目的配置，如：你自己的 mysql 连接
7. 系统生成的 API 管理工具 swagger 接口文档地址：<http://localhost:8899//swagger-ui.html>
#### 软件架构
软件架构说明
##### java
* base : 基础类
* common : 公共类
* config : 配置
* constant : 常量，存放固定不变的信息
* dto : 入参对象
* entity : 实体对象，与数据库表一一对应
* exception : 自定义异常
* mapper : dao
* service : 业务层接口
    * impl : 业务逻辑实现类
* utils : 自定义工具
##### resources
* sql : mapper.xml
* templates : 代码生成模板
* application.beta : 测试环境配置
* application.deploy : 线上环境配置
* logback-spring : logback配置

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
