package cn.yf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import cn.yf.entity.Student;
import cn.yf.service.StudentService;

/**
 * Servlet implementation class queryByIdOrNameServlet
 */
@WebServlet("/queryByIdOrNameServlet")
public class queryByIdOrNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("IdorName");
		StudentService service = new StudentService();
		List<Student> students = null;
		HttpSession session = request.getSession();
		int id = -1;
		try{
			id = Integer.parseInt(s);
			System.out.println(id);
			students = service.queryStudentById(id);
			session.setAttribute("students", students);
			//request.getRequestDispatcher("main.jsp").forward(request, response);
			response.sendRedirect("main.jsp");
		}catch(Exception e){
			System.out.println(s);
			students = service.queryStudentByName(s);
			session.setAttribute("students", students);
			//request.getRequestDispatcher("main.jsp").forward(request, response);
			response.sendRedirect("main.jsp");
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
