<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>game search main</title>
</head>
<body>

	인기 키워드:
	<c:forEach var="popularQuery" items="${popularQueryList}"><!-- foreach 사용시 jstl.jar와 core태그 추가 -->
${popularQuery}
</c:forEach>
	<form action="game.do">
		<select name="type">
			<c:forEach var="searchType" items="${searchTypeList}">
				<option value="${searchType.code}">${searchType.text}</option>
			</c:forEach>
		</select> <input type="text" name="query" value="" /> <input type="submit"
			value="검색" />

	</form>
</body>
</html>