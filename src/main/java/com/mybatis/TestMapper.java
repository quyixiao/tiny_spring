package com.mybatis;

import com.alibaba.fastjson.JSON;
import com.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestMapper {

    static SqlSessionFactory sqlSessionFactory ;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    @Test
    public void testAdd(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User("tom","123456");
            userMapper.insertMapper(user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }



    @Test
    public void getUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(1l);
            System.out.println(JSON.toJSONString(user));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }





}
