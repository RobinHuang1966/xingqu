package com.hwadee.xingqu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *@author yongzhang
 *@since 2013-07-05
 *用于将非utf-8格式转化为utf-8
 */
public class CodeingFilter implements Filter {

	/**
	 * Take this filter out of service.
	 */
	public void destroy() {
	}
	/**
	 * Select and set (if specified) the character encoding to be used to
	 * interpret request parameters for this request.
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain)throws IOException, ServletException {

		request.setCharacterEncoding("utf-8");

		chain.doFilter(request, response);
	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub	
	}
}
