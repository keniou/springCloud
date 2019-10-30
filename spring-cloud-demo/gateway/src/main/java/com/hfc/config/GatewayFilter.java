package com.hfc.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.xml.internal.ws.client.ResponseContext;
import org.apache.http.protocol.ResponseContent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 *
 * PRE：在请求被路由之前调用，可以使用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试Log等【用于请求前认证】。
 * ROUTE：将请求路由到对应的微服务，用于构建发送给微服务的请求。【构建请求参数Reqrest数据】
 * POST：在请求被路由到对应的微服务以后执行，可用来为Response添加HTTP Header、将微服务的Response发送给客户端等。【用于构建Response数据】
 * ERROR：在其他阶段发生错误时执行该过滤器。
 * ————————————————
 * @author huangfeichang.
 * @date 2019/9/12 0012.
 */
@Component
public class GatewayFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        Enumeration<String> stringEnumeration=  httpServletRequest.getParameterNames();
        while (stringEnumeration.hasMoreElements()) {
            System.err.println(stringEnumeration.nextElement());
        }
        return null;
    }
}
