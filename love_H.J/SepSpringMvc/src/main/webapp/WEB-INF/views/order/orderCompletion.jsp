<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="EUC-KR">
<title>주문 완료</title>
</head>
<body>
	주문 성공!
	<br/> 주문 item
	<ul>
		<c:forEach var="item" items="${orderCommand.orderItems}">
		<li>${item.itemId}/${item.number}/${item.remark}</li>
		</c:forEach>
	</ul>
	배송지: ${orderCommand.address}
</body>
</html>