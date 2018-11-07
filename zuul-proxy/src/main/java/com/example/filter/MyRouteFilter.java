package com.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class MyRouteFilter extends ZuulFilter {
	@Override
	public boolean shouldFilter() {
		System.out.println("############### MyRouteFilter.shouldFilter() 뭐니?");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("############### MyRouteFilter.run() 뭐니? inside route filter");
		return null;
	}

	@Override
	public String filterType() {
		System.out.println("############### MyRouteFilter.filterType() 뭐니? route");
		return "route";
	}

	@Override
	public int filterOrder() {
		System.out.println("############### MyRouteFilter.filterOrder() 뭐니? 1");
		return 1;
	}
}
