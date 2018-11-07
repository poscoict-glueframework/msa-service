package com.example.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class MyPreFilter extends ZuulFilter {
	@Override
	public boolean shouldFilter() {
		System.out.println("############### MyPreFilter.shouldFilter() 뭐니?");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("############### MyPreFilter.run() 뭐니?");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println("############### MyPreFilter.run() " + request.getMethod() + " " + request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		System.out.println("############### MyPreFilter.filterType() 뭐니? pre");
		return "pre";
	}

	@Override
	public int filterOrder() {
		System.out.println("############### MyPreFilter.filterOrder() 뭐니? 1");
		return 1;
	}
}
