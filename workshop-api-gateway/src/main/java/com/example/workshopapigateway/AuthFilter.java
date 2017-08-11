package com.example.workshopapigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;

public class AuthFilter extends ZuulFilter {
//    private static Logger log = LoggerFactory.getLogger(RequestLoggerFilter.class);

    @Override
    public String filterType() {
        return "pre";
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
    public Object run() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        if(ctx != null){
            Object user = ctx.getAuthentication().getPrincipal();
            RequestContext.getCurrentContext().addZuulRequestHeader("X-ZUUL-USER", user.toString());
        }else{
//
        }
        return null;
    }
}
