package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author shpatel
 *
 */
@Component
public class MyInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean result = request.getParameter("exception") == null ? false
				: Boolean.valueOf(request.getParameter("exception").toString());

		if (result) {
			throw new MyException("Called from filter");
		}

		System.out.println("After exception");
		return true;

	}
}
