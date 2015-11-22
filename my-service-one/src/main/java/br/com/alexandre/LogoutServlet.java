package br.com.alexandre;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;


@WebServlet(value = "/logout", name = "logoutServlet")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = -1749376537784803630L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SecurityUtils.getSubject().logout();
        resp.sendRedirect("https://localhost:8443/cas/logout?service=http://localhost:8080/my-service-one");
	}
    
}

