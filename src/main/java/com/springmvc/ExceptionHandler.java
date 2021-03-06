package com.springmvc;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        request.setAttribute("exception", ex.toString());
        request.setAttribute("exceptionStack", ex);
        System.out.println(ex.toString());
        return new ModelAndView("/error/exception");
    }

    public static void main(String[] args) {
        System.out.println("test add msm");
        System.out.println("测试我们测试他们东西 void main();");
        System.out.println("void main() 测试他们东西是这样的");
    }
}
