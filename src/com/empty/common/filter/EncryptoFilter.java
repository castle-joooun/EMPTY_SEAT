package com.empty.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(servletNames = { 
		"LoginServlet",
		"SignUpFinishServlet",
		"SignUp2FinishServlet",
		"UpdatePasswordServlet",
		"MyPageUpdateEndServlet",
		"DeleteMemberEndServlet"
		"MyPageWithdrawalServlet"
})
public class EncryptoFilter implements Filter {

    public EncryptoFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		EncryptWrapper ew = new EncryptWrapper((HttpServletRequest)request);
		chain.doFilter(ew, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
