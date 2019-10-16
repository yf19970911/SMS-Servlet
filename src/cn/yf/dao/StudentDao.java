package cn.yf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.yf.entity.Student;
import cn.yf.util.DBUtil;
import cn.yf.util.DateUtil;

public class StudentDao {
	
	//添加学生
	public boolean addStudent(Student student){
		String sql = "insert into student values(null,?,?,?,?,?,?)";
		Object params[] = {student.getName(),
		student.getSex(),student.getBirth(),student.getSchoolday(),student.getMarjor_id(),student.getCollege_id()}; 
		boolean result = DBUtil.generalUpdate(sql, params);
		return result;
	}
	
	//删除学生(根据id删除)
	public boolean deleteStudent(int id){
		String sql = "delete from student where id = ?";
		Object[] params = {id};
		boolean result = DBUtil.generalUpdate(sql, params);
		return result;
	}
	
	//根据id修改学生信息
	public boolean updateStudent(int id,Student student){
		String sql = "update student set name=?,sex=?,birth=?,schoolday=?,marjor_id=?,college_id=? where id = ?";
		Object[] params = {student.getName(),student.getSex(),student.getBirth(),student.getSchoolday(),student.getMarjor_id(),student.getCollege_id(),id};
		boolean result = DBUtil.generalUpdate(sql, params);
		return result;
	}
	
	//查询所有学生
	public List<Student> queryAllStudent(){
		List<Student> students = new ArrayList<Student>();
		Student s = null;
		try {
			String sql = "select * from student";
			ResultSet rs = DBUtil.generalQuery(sql, null);
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int sex = rs.getInt("sex");
				Date birth = DateUtil.t2d(rs.getTimestamp("birth"));
				Date schoolday = DateUtil.t2d(rs.getTimestamp("schoolday"));
				int marjor_id = rs.getInt("marjor_id");
				int college_id = rs.getInt("college_id");
				s = new Student(id,name,sex,birth,schoolday,marjor_id,college_id);
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	
	//根据id查询
	public List<Student> queryStudentById(int id){
		Student s = null;
		List<Student> students = new ArrayList<Student>();
		try {
			String sql = "select * from student where id = ?";
			Object[] params = {id};
			ResultSet rs = DBUtil.generalQuery(sql, params);
			while(rs.next()){
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				int sex = rs.getInt("sex");
				Date birth = DateUtil.t2d(rs.getTimestamp("birth"));
				Date schoolday = DateUtil.t2d(rs.getTimestamp("schoolday"));
				int marjor_id = rs.getInt("marjor_id");
				int college_id = rs.getInt("college_id");
				s = new Student(id1,name,sex,birth,schoolday,marjor_id,college_id);
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	
	//根据姓名查询
	public List<Student> queryStudentByName(String name){
		List<Student> students = new ArrayList<Student>();
		Student s = null;
		try {
			String sql = "select * from student where name = ?";
			Object[] params = {name};
			ResultSet rs = DBUtil.generalQuery(sql, params);
			while(rs.next()){
				int id1 = rs.getInt("id");
				String name1 = rs.getString("name");
				int sex = rs.getInt("sex");
				Date birth = DateUtil.t2d(rs.getTimestamp("birth"));
				Date schoolday = DateUtil.t2d(rs.getTimestamp("schoolday"));
				int marjor_id = rs.getInt("marjor_id");
				int college_id = rs.getInt("college_id");
				s = new Student(id1,name1,sex,birth,schoolday,marjor_id,college_id);
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	
	//查询Student表中的数据个数
	public int QueryAll(){
		String sql = "select count(*) from student";
		return DBUtil.QueryAll(sql);
	}
	
	//查询当前页的数据
	public List<Student> queryCurrentPage(int currentPage,int pageSize){
		String sql = "SELECT * FROM STUDENT LIMIT ?,?";
		Object[] params = {(currentPage-1)*pageSize,pageSize};
		ResultSet rs = DBUtil.generalQuery(sql, params);
		Student s = null;
		List<Student> students = new ArrayList<>();
		try {
			while(rs.next()){
				int id1 = rs.getInt("id");
				String name1 = rs.getString("name");
				int sex = rs.getInt("sex");
				Date birth = DateUtil.t2d(rs.getTimestamp("birth"));
				Date schoolday = DateUtil.t2d(rs.getTimestamp("schoolday"));
				int marjor_id = rs.getInt("marjor_id");
				int college_id = rs.getInt("college_id");
				s = new Student(id1,name1,sex,birth,schoolday,marjor_id,college_id);
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	
		
}
