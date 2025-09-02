<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>マイページ</h2>
<p>ログイン中ユーザー: ${sessionScope.loginUser}</p>
<p><a href="${pageContext.request.contextPath}/login">ログアウト</a></p>
</body>
</html>