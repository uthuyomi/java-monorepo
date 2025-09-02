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
<c:if test="${ not empty sessionScope.loginUser }">
<p>こんにちは、${sessionScope.loginUser} さん</p>
<a href="${pageContext.request.contextPath}/mypage">マイページ</a>
<a href="${pageContext.request.contextPath}/logout ">ログアウト</a>
</c:if>
<c:if test="${empty sessionScope.loginUser}">
<c:if test="${param.error == '1'}">
<p style="color:red;">ユーザーまたはパスワードが違います</p>
</c:if>
<c:if test="${param.error == '2'}">
<p style="color:red;">ログインが必要です</p>
<p><a href="${pageContext.request.contextPath}+/login">ログイン画面へ戻る</a></p>
</c:if>
</c:if>
</body>
</html>