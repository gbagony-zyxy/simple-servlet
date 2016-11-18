package org.ruyin.code.servlet;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(
		filterName="sampleFilter",
		urlPatterns={"*.do"},
		dispatcherTypes={DispatcherType.REQUEST},
		servletNames={"myServlet"})
//If defined the servletNames,this filter will preprocess all requestes mapped to the specified servlet.The value
//of this element must reference the servlet name as defined in <servlet-name> element.
public class SampleFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String value = filterConfig.getInitParameter("hello");
		System.out.println("The init value:"+value);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("The doFilter process...");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("The destroy execute....");
	}

}
