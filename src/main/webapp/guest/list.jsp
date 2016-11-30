<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style></style>
    <!-- jQuery (자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <title>LIST</title>
</head>
<body>
<div>
    <c:if test="${loginGo}">
        <a href="../login.do">로그인</a>
    </c:if>
</div>
<h1>LIST PAGE</h1>
<table>
    <tr>
        <th>사번</th>
        <th>이름</th>
        <th>날짜</th>
        <th>금액</th>
    </tr>
    <c:forEach items="${alist}" var="bean">
        <tr>
            <td>${bean.sabun}</td>
            <td><a href="detail.do?idx=${bean.sabun}">${bean.name}</a></td>
            <td>${bean.nalja}</td>
            <td>${bean.pay}</td>
        </tr>
    </c:forEach>
</table>
<c:if test="${loginOk}">
    <p><a href="add.do">입 력</a></p>
</c:if>
</body>
</html>
