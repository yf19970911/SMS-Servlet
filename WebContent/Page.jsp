<%@page import="cn.yf.entity.Page"%>
<%@page import="cn.yf.entity.Student"%>
<%@page import="java.util.List"%>
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
<link rel="stylesheet" href="css/main.css" />
<script type="text/javascript">
	
	function check(){
		var idorName = document.getElementById("IdorName").value;
		if(idorName == ""){
			alert("ID不能为空！");
			return false;
		}
		return true;
	}
	
	function remove(){
		var result = confirm("请确认是否删除！");
		if(result){
			return true;
		}
		return false;
	}

</script>
</head>
<body>
	<% Page p = (Page)session.getAttribute("page"); %>
	<div id="Student">
		<div id="Student_top">
			<div id="Student_title">
				<h3>学生学籍管理</h3>
			</div>
			<div id="Student_search">
				<form action="queryByIdOrNameServlet" method="post" onsubmit="return check()" target="_parent">
					<input type="text" placeholder="请输入ID" class="form-control"
						style="width: 250px; float: left;" id="IdorName" name="IdorName" /> <input type="submit"
						value="搜索" class="btn btn-primary" style="float: right;" />
				</form>
			</div>
			<div id="Student_add">
				<input class="btn btn-success" value="添加学生" style="width: 100px;" onclick="location='addStudent.jsp?passPage=<%=p.getTotalPage() %>'"/>
			</div>
		</div>
		<div id="hr"></div>
		<div id="Student_List" style="margin-left: 20px">
			<table id="Student_table">
				<thead>
					<tr>
						<th>ID</th>
						<th>姓名</th>
						<th>性别</th>
						<th>出生日期</th>
						<th>入学日期</th>
						<th>所属专业</th>
						<th>所需学院</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<%	
						List<Student> students = p.getStudents();
						for (Student s : students) {
					%>
					<tr>
						<td><%=s.getId()%></td>
						<td><%=s.getName()%></td>
						<td><%=s.getSex()%></td>
						<td><%=s.getBirth()%></td>
						<td><%=s.getSchoolday()%></td>
						<td><%=s.getMarjor_id()%></td>
						<td><%=s.getCollege_id()%></td>
						<td>
							<button class="btn btn-primary" onclick="location='updateStudent.jsp?id=<%=s.getId() %>&passPage=<%=p.getCurrentPage() %>'">修改</button>
							<a href="deleteStudentServlet?id=<%=s.getId()%>&passPage=<%=p.getCurrentPage()%>"target="_parent" onclick="return remove()"><button class="btn btn-danger">删除</button></a>
						</td>
					</tr>

					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<div id="Page" style="margin-top: 40px; margin-left: 400px;">
			<a href="QueryStudentByPage?passPage=1" target="_parent"><button class="btn btn-info" >首页</button></a>
			<a style="margin: 0 10px" target="_parent" href="QueryStudentByPage?passPage=<%=p.getCurrentPage()-1%>"><button class="btn btn-info">上一页</button></a>
			<a style="margin-right: 10px" target="_parent" href="QueryStudentByPage?passPage=<%=p.getCurrentPage()+1%>"><button class="btn btn-info">下一页</button></a>
			<a href="QueryStudentByPage?passPage=<%= p.getTotalPage()	 %>" target="_parent"><button class="btn btn-info">尾页</button></a>			
		</div>
	</div>
</body>

</html>