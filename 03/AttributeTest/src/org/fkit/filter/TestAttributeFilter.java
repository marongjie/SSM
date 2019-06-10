package org.fkit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

// 过滤器拦截/main请求
@WebFilter(value="/main")
public class TestAttributeFilter implements Filter{
			
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("进入AuthFilter过滤器的doFilter方法");
		// 将ServletRequest对象强转成HttpServletRequest对象
		HttpServletRequest request = (HttpServletRequest)arg0;
		// 在request作用范围域中设置一个school属性
		request.setAttribute("school", "疯狂软件");
		// 在session作用范围域中设置一个author属性
		request.getSession().setAttribute("author", "肖文吉");
		// 如果还有过滤器执行过滤器，否则进入请求处理方法
		chain.doFilter(request, arg1);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
