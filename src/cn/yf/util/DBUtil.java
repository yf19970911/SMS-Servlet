package cn.yf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/sms?characterEncoding=UTF-8";
	private static final String NAME = "root";
	private static final String PASSWORD="admin";
	public static Connection connection = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	//获得连接
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, NAME, PASSWORD);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	
	//获得PreparedStatement
	public static PreparedStatement getPreparedStatement(String sql,Object[] params){
		try{
			ps = DBUtil.getConnection().prepareStatement(sql);
			if(params != null){
				for(int i=0; i<params.length; i++){
					//这里是从1开始的
					ps.setObject(i+1, params[i]);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ps;
	}
	
	//关闭
	public static void close(Connection c, PreparedStatement ps, ResultSet rs){
		try{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//通用的增删改
	public static boolean generalUpdate(String sql, Object[] params){
		ps = DBUtil.getPreparedStatement(sql, params);
		int count = -1;
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	//通用的查询(条件查询)
	public static ResultSet generalQuery(String sql, Object[] params){
		ps = DBUtil.getPreparedStatement(sql, params);
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	//查询数据库中的所有数据个数
	public static int QueryAll(String sql){
		int count = 0;
		try {
			rs = DBUtil.generalQuery(sql, null);
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	
}
