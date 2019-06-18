package com.springmvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class UserController extends AbstractController {


    /***
     *  在请求中的最后返回了ModelAndView类型的实例，ModelAndView类在SpringMVC中占有很重要的地位，控制器执行方法
     *  必须返回一个ModelAndView，ModelAndView对象保存了视图以及视图显示模型数据，例如其中的参数如下
     *  第一个参数userlist ：视图组件的逻辑名称，这里视图的逻辑名就是userlist，视图解析器使用该名称查找实际View对象
     *  第二个参数users: 传递给视图的模型对象名称
     *  第三个参数userList ，传递给视图的，模型对象的值
     *
     *
     *
     *
     *  因为Spring MVC 是基于Servlet的实现的，所以在Web启动的时候，服务器会首先尝试加载对应于Servlet配置文件，
     *  而为了让项目更加模块化，通常我们将web部分的配置都存放于此配置文件中
     *
     *  至此，已经完成了Spring MVC 的搭建，启动服务器，输入网址，http://location:8080/Springmvc/userlist.htm
     *
     *  对于Spring MVC 功能实现的分析，我们首先从web.xml开始，在web.xml文件中我们首先配置的是ContextLoadListener
     *  ，那么它所提供的功能有哪些又是如何实现的呢
     *
     *  当使用编程的方式的时候我们可以直接将Spring配置信息作为参数传入Spring容器中，如
     *  ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
     *  但是在Web下，我们需要更多的是Web环境相互结合，通常的办法是将路径以context-param的方式注册并使用ContextLoaderListener进行监听读取
     *      ContextLoaderListener的作用就是启动web容器时，自动装配ApplicationContext的配置信息，因为它实现了ServletContextListener这
     * 个接口，在web.xml配置这个监听器，启动容器时，就会默认执行它的实现方法，使用ServletContextListener接口，开发者能够在为客户端请求
     * 提供服务之前向ServletContext中添加任意对象，这个对象在ServletContext启动的时候被初始化，然后在ServletContext整个运行期间都是可
     * 见的。
     *      每一个web应用都有一个ServletContext与相关的关联，ServletContext对象应用启动时被创建，在应用关闭时候，被销毁，ServletContext
     * 在全局范围内有效，类似于应用中的一个全局的变量
     *      在ServletContextListener中核心的逻辑便是初始化WebApplicationContext实例并存入至ServletContext中
     *
     *      ServletContextListener的使用
     *      正式的分析代码前还是先首先了解ServletContextListener的使用
     *  1.创建自定义的ServletContextListener
     *  首先我们创建ServletContextListener ，目标是在系统启动的时候添加自定义属性，以便于在全局范围内可以随时调用，系统启动的时候会调用
     *  ServletContextListener实现类的contextInitialized方法，所以需要在这个方法实现我们初始化逻辑
     *
     *
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> userList = new ArrayList<>();
        User userA = new User();
        User userB = new User();
        userA.setAge(27);
        userA.setUserName("zhangsan");

        userB.setUserName("lisi");
        userB.setAge(10);
        userList.add(userA);
        userList.add(userB);

        return new ModelAndView("userlist","users",userList);
    }
}
