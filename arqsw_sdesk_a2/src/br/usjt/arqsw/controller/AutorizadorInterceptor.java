package br.usjt.arqsw.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws IOException
	{
		if(request.getSession().getAttribute("usuarioLogado") != null) 
		{
			return true;
		} 
		response.sendRedirect("loginForm");
		return false;
	}

}
