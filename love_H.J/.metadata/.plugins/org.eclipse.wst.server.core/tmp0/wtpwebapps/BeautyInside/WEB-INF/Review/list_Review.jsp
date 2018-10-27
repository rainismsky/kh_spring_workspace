<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beauty Inside</title>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

<!-- jquery를 쓰려면 꼭 필요한 선언이다 명시를 하지 않으면 jqury,java Script를 사용할 수 없다 -->

<script>
 $(document).ready(function() {
	$("#R_Write").click(function() {
	//페이지 주소 변경(이동)
	location.href = "${pageContext.request.contextPath}/Review/write_Review";
	
	});
});
 
</script>
</head>
<body>

	<h2>Beauty Inside</h2>

	<p align="center">
		<input type="button" value="업체 상세" >
		<input type="button" value="서비스" >
		<input type="button" value="후기" >
	</p>
	
	<h3>후기 게시판</h3> 
	
	<table border="1" width="800px">

		<tr>
			<th>No.</th>
			<th>내용</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>평점</th>
		</tr>

		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.rno}</td>
				<td><a href="<c:url value='/Review/view_Review?rno=${row.rno}'/>">${row.rcontents}</a></td>
				<td>${row.mid}</td>
				<%-- <fmt:formatDate value="${row.r_regdate}" pattern="yyyy-MM-dd HH:mm:ss"/> --%>
				<!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
				<td>${row.r_regdate}</td>
				<td>${row.r_grade}</td>


				<%-- <td>${row.r_regdate}</td> --%>

			</tr>
		</c:forEach>
	</table>
	<!-- <button type="button" id="R_Write">글쓰기</button> -->
	<p align="right">
	<input type="button" value="글 쓰기" id="R_Write"/></p>
</body>
</html>