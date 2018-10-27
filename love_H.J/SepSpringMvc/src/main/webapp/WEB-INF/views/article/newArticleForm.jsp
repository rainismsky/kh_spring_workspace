<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글 쓰기</title>
</head>
<body>
게시글 쓰기 입력 폼:
<form method="post"> <!-- 현재 url 그대로 요청하나 post방식이용함 -->
	<input type="hidden" name="parentId" value="10"/> 
	<!-- 10은 파라미터이므로 String타입이다 -->
	
	<!-- 위 선언된 인풋태그에 value값에 "10"이 아닌  "hyodang" <= 이런식으로 명시를 하면 400에러가 발생함
		 이유는 parentId는 int형으로 만들어져 있기 때문
	  	 Bad Request, 요청 실패 - 문법상 오류가 있어서 서버가 요청 사항을 이해하지 못함.

	  -->
	
	<!-- 특정 요청이 둘 중 하나 방식만 지원해서 하나의 방식만 지원한다고 알려주는게 405방식 에러 
		  Method not allowed, 메소드 허용 안 됨 - 이 에러는 Request 라인에 명시된 메소드를 
		  수행하기 위한 해당 자원의 이용이 허용되지 않았을 경우에 발생함.
	-->
	
	제목: <input type="text" name="title"/><br/>
	내용: <textarea name="content"></textarea>
		<br/><input type="submit"/>
</form>
</body>
</html>