package cn.yf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.yf.entity.Admin;
import cn.yf.util.DBUtil;

public class AdminDao {
	
	//根据管理员的账号修改管理员的信息
	public boolean updateAdminByName(String name,Admin admin){
		String sql = "update admin set name=?,password=? where name=?";
		Object[] params = {admin.getName(),admin.getPassword(),name};
		boolean result = DBUtil.generalUpdate(sql, params);
		return result;
	}
	
	//判断管理员是否存在
	public boolean isExist(String name,String password){
		String sql = "select * from admin where name=? and password=?";
		Object params[] = {name,password};
		ResultSet rs = DBUtil.generalQuery(sql, params);
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
