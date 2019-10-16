package cn.yf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.yf.entity.Admin;
import cn.yf.service.AdminService;

/**
 * Servlet implementation class updateAdminServlet
 */
@WebServlet("/updateAdminServlet")
public class updateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name1 = request.getParameter("update_admin_name");
		String password = request.getParameter("update_admin_password");
		HttpSession session = request.getSession();
		String name2 = (String)session.getAttribute("name");
		Admin admin = new Admin(name1,password);
		AdminService service = new AdminService();
		boolean result = service.updateAdminByName(name2, admin);
		if(result){
			session.setAttribute("name", name1);
			response.sendRedirect("main.jsp");
		}else{
			System.out.println("更新失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
