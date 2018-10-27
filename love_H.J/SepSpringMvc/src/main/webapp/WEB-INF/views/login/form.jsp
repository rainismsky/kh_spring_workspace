<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>로그인</title>
</head>
<body><%-- 메서드 속성 지정하지 않으면 get방식으로 요청된다. <form:form 하지만 이태그는 post방식으로 요청됨. --%>
	<form:form commandName="loginCommand">
		<form:errors element="div" /><!-- 글로벌 에러 div태그로 감싸서 에러 출력하겠다.-->
		아이디: <form:input path="userId" />
		<form:errors path="userId" /><%-- userId에 대한 에러 --%>
		<br />
		암호: <form:password path="password" showPassword="false" />
		<form:errors path="password" />
		<br />
		<input type="submit" />
	</form:form>
</body>
</html>
