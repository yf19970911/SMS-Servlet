package cn.yf.service;

import cn.yf.dao.AdminDao;
import cn.yf.entity.Admin;

public class AdminService {
	
	AdminDao dao = new AdminDao();
	
	//根据管理员的账号修改管理员的信息
	public boolean updateAdminByName(String name,Admin admin){
		return dao.updateAdminByName(name, admin);
	}
	
	//判断管理员是否存在
	public boolean isExist(String name,String password){
		return dao.isExist(name, password);
	}
	
}
