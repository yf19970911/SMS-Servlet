package cn.yf.service;

import java.util.List;

import cn.yf.dao.StudentDao;
import cn.yf.entity.Student;

public class StudentService {
	
	StudentDao dao = new StudentDao();
	
	//添加学生
	public boolean addStudent(Student student){
		boolean result = dao.addStudent(student);
		return result;
	}
	
	//根据id删除学生
	public boolean deleteStudent(int id){
		boolean result = dao.deleteStudent(id);
		return result;
	}
	
	//根据id修改学生信息
	public boolean updateStudent(int id,Student student){
		boolean result = dao.updateStudent(id, student);
		return result;
	}
	
	//查询所有学生
	public List<Student> queryAllStudent(){
		return dao.queryAllStudent();
	}
	
	//根据id查询学生
	public List<Student> queryStudentById(int id){
		return dao.queryStudentById(id);
	}
	
	//根据姓名查询学生
	public List<Student> queryStudentByName(String name){
		return dao.queryStudentByName(name);
	}
	
	//查询Student表中的数据个数
	public int QueryAll(){
		return dao.QueryAll();
	}
	
	//查询当前页的数据
	public List<Student> queryCurrentPage(int currentPage,int pageSize){
		return dao.queryCurrentPage(currentPage, pageSize);
	}
	
	
}
