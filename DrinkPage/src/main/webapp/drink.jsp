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
<c:if test="${not empty sessionScope.drink}">
<p>今日も${sessionScope.drink}を飲んで頑張ってください</p>
</c:if>
<c:if test="${empty sessionScope.drink}">
<p>まだ飲み物が登録されていません。</p>
</c:if>
</body>
</html>