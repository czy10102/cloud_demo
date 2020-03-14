package com.czy.controller;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class ZuulFilterDemo extends ZuulFilter {
    @Override
    public String filterType() {
        //PRE 过滤器：请求路由到具体的服务之前执行  可以做安全验证，例如身份验证、参数验证等。

       // ROUTING 过滤器：将请求路由到具体的微服务实例

      //  POST 过滤器：请求己被路由到微服务后执行 用作收集统计信息、指标，以及将响应传输到客户端

       // ERROR过滤器 ：在其他过滤器发生错误时执行
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 过滤顺序 值越小 越早过滤
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // true执行run false不执行
        return true;
    }

    @Override
    public Object run() {
        // 判断是否有name参数
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        HttpServletResponse response = currentContext.getResponse();
        String name = request.getParameter("name");
        if(StringUtils.isEmpty(name)){
            try {
                response.setCharacterEncoding("utf-8");
                response.getWriter().write("error");
                currentContext . setSendZuulResponse(false) ;
                currentContext . setResponseStatusCode(401) ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
