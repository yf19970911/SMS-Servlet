package cn.yf.test;

import java.util.Date;

import org.junit.Test;

import cn.yf.dao.AdminDao;
import cn.yf.dao.StudentDao;
import cn.yf.entity.Admin;
import cn.yf.entity.Student;
import cn.yf.util.DateUtil;

public class DBTest {
	
	@Test
	public void addTest(){
		StudentDao studentDao = new StudentDao();
		Date date = new Date();
		Student student = new Student("yf",1,DateUtil.d2t(date),DateUtil.d2t(date),1,2);
		boolean result = studentDao.addStudent(student);
		if(result){
			System.out.println("添加成功！");
		}else{
			System.out.println("添加失败！");
		}
	}
	
	@Test
	public void deleteTest(){
		StudentDao studentdao = new StudentDao();
		boolean result = studentdao.deleteStudent(2);
		if(result){
			System.out.println("删除成功！");
		}else{
			System.out.println("删除失败！");
		}
	}
	
	@Test
	public void updateTest(){
		StudentDao studentdao = new StudentDao();
		Date date = new Date();
		Student student = new Student("tht",1,DateUtil.d2t(date),DateUtil.d2t(date),1,2);
		boolean result = studentdao.updateStudent(1, student);
		if(result){
			System.out.println("更新成功！");
		}else{
			System.out.println("更新失败！");
		}
	}
	
	@Test
	public void queryAllStudent(){
		StudentDao studentdao = new StudentDao();
		System.out.println(studentdao.queryAllStudent());
	}
	
	@Test
	public void queryStudentById(){
		StudentDao studentdao = new StudentDao();
		System.out.println(studentdao.queryStudentById(1));
	}
	
	@Test
	public void queryStudentByName(){
		StudentDao studentdao = new StudentDao();
		System.out.println(studentdao.queryStudentByName("yf"));
	}
	
	@Test
	public void QueryAll(){
		StudentDao studentdao = new StudentDao();
		System.out.println(studentdao.QueryAll());
	}
	
	@Test
	public void queryStudentByPage(){
		StudentDao studentdao = new StudentDao();
		System.out.println(studentdao.queryCurrentPage(1, 3));
		System.out.println(studentdao.queryCurrentPage(2, 3));
		System.out.println(studentdao.queryCurrentPage(3, 3));
		System.out.println(studentdao.queryCurrentPage(4, 3));
	}
	
	@Test
	public void TotalPage(){
		AdminDao dao = new AdminDao();
		System.out.println(dao.isExist("tht", "456"));
		System.out.println(dao.isExist("yf", "123"));
	}
	
	@Test
	public void test1111(){
		AdminDao dao = new AdminDao();
		Admin admin = new Admin("yf","123");
		System.out.println(dao.updateAdminByName("tht", admin));
	}
	
	
}
