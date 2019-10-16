<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery/2.0.0/jquery.min.js" ></script>
<link rel="stylesheet" href="css/bootstrap/3.3.6/bootstrap.min.css" />
<script type="text/javascript" src="js/bootstrap/3.3.6/bootstrap.min.js" ></script>
<link rel="stylesheet" href="css/main.css" />
</head>
<script type="text/javascript">
	
	function check(){
		var result = confirm("请确认是否退出！");
		if(result){
			return true;
		}
		return false;
	}

</script>
<body>
	<div class="list-group" id="Navbar">
			<a href="QueryStudentByPage" class="list-group-item" target="_parent">学生管理</a>
			<a href="AdminPasswordReset.jsp" class="list-group-item" target="contain">账号密码重置</a>
			<a href="login.jsp" class="list-group-item" target="_parent" onclick="return check()">退出系统</a>
	</div>
</body>
</html>