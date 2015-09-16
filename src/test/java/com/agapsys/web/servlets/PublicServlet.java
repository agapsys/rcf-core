/*
 * Copyright 2015 Agapsys Tecnologia Ltda-ME.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.agapsys.web.servlets;

import com.agapsys.web.ActionServlet;
import com.agapsys.web.ActionServletTest;
import com.agapsys.web.HttpMethod;
import com.agapsys.web.annotations.WebAction;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/public/*")
public class PublicServlet extends ActionServlet {
	
	private void processRequest(String msg, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.getWriter().print(msg);
	}
	
	@WebAction
	public void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(ActionServletTest.PUBLIC_GET_URL, req, resp);
	}
	
	@WebAction(mapping = "mapped/get")
	public void mappedGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(ActionServletTest.PUBLIC_MAPPED_GET_URL, req, resp);
	}
	
	
	@WebAction(httpMethod = HttpMethod.POST)
	public void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(ActionServletTest.PUBLIC_POST_URL, req, resp);
	}
	
	@WebAction(httpMethod = HttpMethod.POST, mapping = "mapped/post")
	public void mappedPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(ActionServletTest.PUBLIC_MAPPED_POST_URL, req, resp);
	}
}
