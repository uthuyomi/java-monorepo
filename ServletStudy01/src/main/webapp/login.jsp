<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty sessionScope.loginUser}">
<p>ようこそ、${sessionScope.loginUser}さん</p>
</c:if>
<c:if test="${empty sessionScope.loginUser}">
<c:if test="${param.error == '1'}">
<p style="color:red">ユーザー名またはパスワードが違います。</p>
</c:if>
</c:if>
</body>
</html>