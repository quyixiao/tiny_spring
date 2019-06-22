package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*****
 * HandlerInterceptor的处理
 * ServletApi 定义了 servlet 过滤器可以在 servlet 处理每个 web 请求的前后分别对它进行前置处理，此外，有一些时候 Spring MVC 处理程序
 * 的 web 请求，并在些处理程序返回的模型属性被传递到视图之前，对它们进行一些操作，Spring MVC 允许你通过处理拦截 web 请求，进行前置处理
 * 和后置处理，处理拦截是在 Spring 的 web 应用程序上下文中配置的，因此它们可以利用各种容器特性，并引用容器中声明的任何 bean ，处理拦截是
 * 针对特殊处理程序映射进行注册的，因此它只拦截通过这些处理程序映射的请求，每个处理拦截都必须 实现 HandlerInterceptor接口，它包含
 * 三个需要你实现的回调方法，preHandler,PostHandle()和 afterCompletion()，第一个和第二个方法分别是在处理程序处理请求之前和之后的
 * 被调用，第二个方法还允许访问返回 ModelAndView 对象，因引可以它里面操作的模型属性，最后一个方法是所有的请求处理完成之后被调用的，如视图
 * 呈现之后，以下是 HandlerInterceptor 的简单的实现
 *
 *
 * 在这个拦截器的 preHandler()方法中，你记录了起始时间，并将它保存到请求属性中，这个方法应该返回 true，允许 dispatcherServlet 继续处理
 * 请求，否则，DisaptcherServlet 会认为这个方法已经处理了请求，直接将响应返回给用户，然后在 postHandler 方法中，从请求属性中加载起始时间
 * 并将它与当前的时间进行了比较，你可以计算总的持续时间，然后把这个时间添加到模型中，
 *
 */
public class MyTestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        modelAndView.addObject("handlingTime",(endTime - startTime));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
