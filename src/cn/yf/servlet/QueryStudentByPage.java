package cn.yf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yf.entity.Page;
import cn.yf.entity.Student;
import cn.yf.service.StudentService;

/**
 * Servlet implementation class QueryStudentByPage
 */
@WebServlet("/QueryStudentByPage")
public class QueryStudentByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService service = new StudentService();
		// student表数据数总数
		int totalCount = service.QueryAll();
		// 每页的大小
		int pageSize = 10;
		// 总页数
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		// 当前页
		String passPage = request.getParameter("passPage");
		int currentPage = -1;
		if (passPage == null) {
			passPage = "1";
			currentPage = Integer.parseInt(passPage);
		}else if(Integer.parseInt(passPage)>=totalPage){
			currentPage = totalPage;
		}else if(Integer.parseInt(passPage)<=1){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(passPage);
		}
		// 当前页的数据集合
		List<Student> students = service.queryCurrentPage(currentPage, pageSize);

		Page page = new Page();
		page.setTotalCount(totalCount);
		page.setpageSize(pageSize);
		page.setStudents(students);
		page.setCurrentPage(currentPage);
		page.setTotalPage(totalPage);
		HttpSession session = request.getSession();
		session.setAttribute("page", page);
		response.sendRedirect("main.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
