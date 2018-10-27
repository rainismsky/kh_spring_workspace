<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 List</title>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script> 

<!-- jquery를 쓰려면 꼭 필요한 선언이다 명시를 하지 않으면 jqury,java Script를 사용할 수 없다 -->

<script>
$(document).ready(function (){
	$("#btnWrite").click(function(){
		//페이지 주소 변경(이동)
		location.href="${pageContext.request.contextPath}/board/write.do";
	
	});
	});
	
</script>
</head>
<body>

	<h2>게시글 목록</h2>
	<button type="button" id="btnWrite" align="right">글쓰기</button>
	<table border="1" width="600px">
		
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		
			<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.bno}</td>
				<td><a href="${pageContext.request.contextPath}/board/view.do?bno=${row.bno}">${row.title}</a></td>
				<td>${row.writer}</td>	
				<td>
				
<!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->

				<fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${row.viewcnt}</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>