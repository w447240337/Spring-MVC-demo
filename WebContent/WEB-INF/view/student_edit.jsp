<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript"
	src="<%=request.getContextPath()%>/script/jquery.min.js"></script>
<script>
	function update() {
		$.ajax( {
			type: "POST",
			url:"<%=request.getContextPath()%>/student.do?method=update",
			dataType : "json",
			data: JSON.stringify({ "user": "1222" }),
			success : function(data) {
				if (data.update == "true") {
					alert("修改成功！");
				} else {
					alert("修改失败！");
				}
			},
			error : function() {
				alert("网络连接出错！");
			}
		})
	}
</script>
</head>
<body>
	<c:forEach items="${info}" var="student">
		<div>
			姓名：${student.user}<input type="text" id="name"><input
				type="button" onclick="update()" value="提交">
		</div>
		<div>
			密码：${student.psw} <input type="text" id="name"><input
				type="button" onclick="update" value="提交">
		</div>
	</c:forEach>
</body>
</html>