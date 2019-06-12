package com.mybatis;


import com.mybatis.domain.User;

// 建立配置文件
// 配置文件主要用于配置程序中可变性高的设置，一个偏大的程序，一定会存在一些经常变化的变量，如果每次变化都需要改变源码那会是非常糟糕的
// 设计，所以我们看到各种各样的框架或才应用的时候免不了要配置文件，MyBatis 中配置文件主要的封装在 configuration 中配置文件中的基本结构
// 91 所示
// mappers ,properties
// databaseIdProvider settings
// evironments
// typeAliases
// plugins
// objectFactory
// configration ,根元素
// properties 定义配置外在化
// settings 一此全局性配置
// typeAliases ： 为一些类定义别名
// environment :配置 MyBatis 环境
// transactionManager 事物管理器
// dataSource 数据源
// 读者如果对上面各个配置具体使用方法感兴趣，可以进一步查阅相关的资料，这里只举
public interface UserMapper {

    public void insertMapper(User user);

    public User getUser(Long id );


}
