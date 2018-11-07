package com.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class MyErrorFilter extends ZuulFilter {
	@Override
	public boolean shouldFilter() {
		System.out.println("############### MyErrorFilter.shouldFilter() 뭐니?");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("############### MyErrorFilter.run() 뭐니? inside error filter");
		return null;
	}

	@Override
	public String filterType() {
		System.out.println("############### MyErrorFilter.filterType() 뭐니? error");
		return "error";
	}

	@Override
	public int filterOrder() {
		System.out.println("############### MyErrorFilter.filterOrder() 뭐니? 1");
		return 1;
	}
}