package com.crm.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
public class UserFilter implements Filter {
    public UserFilter() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		Object user = req.getSession().getAttribute("user");
		if(user!=null){
		chain.doFilter(request, response);
		}else{
			req.setAttribute("error", "请勿非法访问，请登录");//为什么页面不显示？
			res.sendRedirect(req.getContextPath()+"/login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
