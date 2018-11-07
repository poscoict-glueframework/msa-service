package com.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class MyPostFilter extends ZuulFilter {
	@Override
	public boolean shouldFilter() {
		System.out.println("############### MyPostFilter.shouldFilter() 뭐니?");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("############### MyPostFilter.run() 뭐니? inside response filter");
		return null;
	}

	@Override
	public String filterType() {
		System.out.println("############### MyPostFilter.filterType() 뭐니? post");
		return "post";
	}

	@Override
	public int filterOrder() {
		System.out.println("############### MyPostFilter.filterOrder() 뭐니?");
		return 1;
	}
}
