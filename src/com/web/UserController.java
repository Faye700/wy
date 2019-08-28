package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.common.Result;

public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if ("get".equals(method)) {
			selectByUserName(request, response);
		} 
	}
	
	private void selectByUserName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type","application/json;charset=UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter ops = response.getWriter();

		String name = request.getParameter("name");
		if (null == name || name == "") {
			ops.append(Result.failure("姓名不能为空").toString());
			return;
		}
			
		User user = new User();
		user.setName(name);
		user.setAge(18);
		user.setEmail("xxxx@qq.com");
		
		ops.append(Result.success(user).toString());
		
	}

	
}
