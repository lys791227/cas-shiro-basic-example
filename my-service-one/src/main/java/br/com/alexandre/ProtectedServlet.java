package br.com.alexandre;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

@WebServlet(value="/protected", name="protectedServlet")
public class ProtectedServlet extends HttpServlet {

	private static final long serialVersionUID = -4718739199311134131L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final Subject subject = SecurityUtils.getSubject();

		resp.getWriter().println("principal: " + subject.getPrincipal());
		resp.getWriter().println("isAuthenticated: " + subject.isAuthenticated());
		resp.getWriter().println("ROLE_USER: " + subject.hasRole("ROLE_USER"));
        resp.getWriter().println("This is My Service One!");
	}
	
}
