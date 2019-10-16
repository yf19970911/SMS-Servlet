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
#add_Student {
	border: 1px solid #bbb;
	background-color: #eee;
	border-radius: 10px;
	flex: 5;
	border-radius: 30px;
	width: 90%;
	height: 550px;
}

#add_form {
	width: 400px;
	height: 400px;
	margin-top: 5%;
	margin-left: 35%;
}

#add_Student_title {
	margin-left: 120px;
}

#add_Student_1 {
	margin-top: 20px;
	margin-left: 50px;
}

#add_Student_2 {
	margin-top: 20px;
	margin-left: 50px;
}

#add_Student_3 {
	margin-top: 20px;
	margin-left: 20px;
}

#add_Student_4 {
	margin-top: 20px;
	margin-left: 20px;
}

#add_Student_5 {
	margin-top: 20px;
	margin-left: 50px;
}

#add_Student_6 {
	margin-top: 20px;
	margin-left: 50px;
}

#add_Student_7 {
	margin-top: 50px
}
</style>
<script>
	function check() {
		var name = document.getElementById("add_student_name").value;
		var sex = document.getElementById("add_student_sex").value;
		var birth = document.getElementById("add_student_birth").value;
		var schoolDay = document.getElementById("add_student_schoolDay").value;
		var marjor = document.getElementById("add_student_marjor").value;
		var college = document.getElementById("add_student_college").value;
		if (name == "") {
			alert("账号不能为空");
			return false;
		}
		if (sex == "") {
			alert("性别不能为空");
			return false;
		}
		if (birth == "") {
			alert("出生年月日不能为空");
			return false;
		}
		if (schoolDay == "") {
			alert("入学时间不能为空");
			return false;
		}
		if (marjor == "") {
			alert("专业不能为空");
			return false;
		}
		if (college == "") {
			alert("学院不能为空");
			return false;
		}
		return true;

	}
</script>
</head>
<body>
	<%
		String passPage = request.getParameter("passPage");
	%>
	<div id="add_Student">
		<div id="add_form">
			<form action="addStudentServlet?passPage=<%=passPage%>" method="post"
				onsubmit="return check()" target="_parent">
				<div id="add_Student_title">
					<h2>添加学生</h2>
				</div>
				<div id="add_Student_1">
					<label>姓名：</label><input type="text" name="add_student_name"
						class="form-control" style="width: 200px; display: inline;"
						id="add_student_name" />
				</div>
				<div id="add_Student_2">
					<label>性别：</label><select id="add_student_sex"
						name="add_student_sex">
						<option value="">---请选择---</option>
						<option value="0">女</option>
						<option value="1">男</option>
					</select>
				</div>
				<div id="add_Student_3">
					<label>出生日期：</label><input type="date" name="add_student_birth" id="add_student_birth"/>
				</div>
				<div id="add_Student_4">
					<label>入学日期：</label><input type="date" name="add_student_schoolDay" id="add_student_schoolDay" />
				</div>
				<div id="add_Student_5">
					<label>专业：</label><input type="text" name="add_student_marjor" id="add_student_marjor"/>
				</div>
				<div id="add_Student_6">
					<label>学院：</label><input type="text" name="add_student_college" id="add_student_college"/>
				</div>
				<div id="add_Student_7">
					<a href="QueryStudentByPage?passPage=<%=passPage %>" target="_parent"><input type="text" value="退出" class="btn btn-danger" style="width: 67px; margin-right: 100px"/></a>
					<input type="submit" value="提交" class="btn btn-primary" style="margin-left: 100px; width: 67px"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>