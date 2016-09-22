<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/include/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>姓名：</div>
	<div>密码：</div>
	<c:forEach items="${info}" var="student">
		<tr id="<c:out value="${student.id}"/>">
			<td><c:out value="${student.id}" /></td>
			<td><c:out value="${student.user}" /></td>
			<td><c:out value="${student.psw}" /></td>
		</tr>
	</c:forEach>

</body>
</html>