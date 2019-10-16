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
	document.documentElement.style.overflow="hidden";
</script>
<frameset rows="20%,*" frameborder="0" framespacing="10">
	<frame src="top.jsp" noresize="noresize" scrolling="no" />
	<frameset cols="20%,*">
		<frame src="Left_nav.jsp" noresize="noresize" />
		<frame src="Page.jsp" name="contain"/>
	</frameset>
</frameset>
</html>