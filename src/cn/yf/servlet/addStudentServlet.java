package cn.yf.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yf.entity.Student;
import cn.yf.service.StudentService;

/**
 * Servlet implementation class addStudentServlet
 */
@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String passPage = request.getParameter("passPage");
		SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd");
		String name = request.getParameter("add_student_name");
		int sex = Integer.parseInt(request.getParameter("add_student_sex")); 
		Date birth = null;
		Date schoolDay = null;
		try {
			birth = format.parse(request.getParameter("add_student_birth"));
			schoolDay = format.parse(request.getParameter("add_student_schoolDay"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int marjor = Integer.parseInt(request.getParameter("add_student_marjor")); 
		int college = Integer.parseInt(request.getParameter("add_student_college"));
		Student s = new Student(name,sex,birth,schoolDay,marjor,college);
		StudentService service = new StudentService();
		boolean result = service.addStudent(s);
		if(result){
			response.sendRedirect("QueryStudentByPage?passPage="+passPage);
		}else{
			System.out.println("添加失败");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
