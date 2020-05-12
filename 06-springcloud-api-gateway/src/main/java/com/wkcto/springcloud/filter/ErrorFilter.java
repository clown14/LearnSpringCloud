package com.wkcto.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: wkctoProjects
 * @author: onion
 * @create: 2020-05-12 15:45
 **/

//@Component
public class ErrorFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        try {
            RequestContext context = RequestContext.getCurrentContext();
            ZuulException exception = (ZuulException) context.getThrowable();
            logger.error("进入系统异常拦截", exception);
            HttpServletResponse response = context.getResponse();
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(exception.nStatusCode);
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
                writer.print("{code:" + exception.nStatusCode + ",message:\"" + exception.getMessage()+"\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (writer == null) {
                    writer.close();
                }
            }
        } catch (Exception var5) {
            ReflectionUtils.rethrowRuntimeException(var5);
        }

        return null;
    }
}

    