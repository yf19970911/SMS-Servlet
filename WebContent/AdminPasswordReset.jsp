<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery/2.0.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/bootstrap/3.3.6/bootstrap.min.css" />
<script type="text/javascript" src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
<style type="text/css">
#update_admin {
	border: 1px solid #bbb;
	background-color: #eee;
	border-radius: 10px;
	flex: 5;
	border-radius: 30px;
	width: 90%;
	height: 550px;
}

#update_admin_form {
	width: 400px;
	height: 400px;
	margin-top: 5%;
	margin-left: 30%;
}

#update_admin_title {
	margin-left: 120px;
}

#update_admin_1 {
	margin-top: 70px;
	margin-left: 100px;
}

#update_admin_2 {
	margin-top: 70px;
	margin-left: 100px;
}

#update_admin_3 {
	margin-top: 120px
}
</style>
<script>
	function check(){
		var name = document.getElementById("update_admin_name").value;
		var password = document.getElementById("update_admin_password").value;
		if(name == ""){
			alert("账号不能为空！");
			return false;
		}
		if(password == ""){
			alert("密码不能为空！");
			return false;
		}
		return true;
	}
	
</script>
</head>
<body>
	<div id="update_admin">
		<div id="update_admin_form">
			<form action="updateAdminServlet" method="post"
				onsubmit="return check()" target="_parent">
				<div id="update_admin_title">
					<h2>修改管理员信息</h2>
				</div>
				<div id="update_admin_1">
					<label>姓名：</label><input type="text" name="update_admin_name"
						class="form-control" style="width: 200px; display: inline;"
						id="update_admin_name" />
				</div>
				<div id="update_admin_2">
					<label>密码：</label><input type="password" name="update_admin_password"
						class="form-control" style="width: 200px; display: inline;"
						id="update_admin_password" />
				</div>
				<div id="update_admin_3">
					<a href="QueryStudentByPage" target="_parent"><input type="text" value="退出" class="btn btn-danger" style="width: 67px;margin-left: 70px"/></a>
					<input type="submit" value="提交" class="btn btn-primary" style="width: 67px; margin-left: 180px"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>