package com.springmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyDataContextListener implements ServletContextListener {

    private ServletContext context = null;

    public MyDataContextListener(){

    }


    // 该方法在ServletContext启动之前被调用，并准备好处理客户端请求
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.context = sce.getServletContext();
        // 通过你可以实现自己的逻辑并将结果记录在属性中
        this.context.setAttribute("myData","this is myData");
    }


    // 这个方法在ServletContext 将要关闭的时候调用

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.context = null;
    }
}
