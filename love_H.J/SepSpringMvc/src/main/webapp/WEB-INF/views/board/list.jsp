<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>자유 게시판</title>
<link rel="stylesheet" type="text/css">
</head>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<body>


	<br>
	<br>
	<div align="center">
		<h3>자유 게시판</h3>
		<button class="btn btn-success btn-md">
			<a href="writeForm.do">글작성</a>
		</button>
	</div>
<br>
<br>
<div id="board">

	<table class="table table-hover" cellpadding="0" cellspacing="0"
		align="center">
		<tr height="35">
			<td align="center" width="40">번 호</td>
			<td align="center" width="200">제 목</td>
			<td align="center" width="100">작성자</td>
			<td align="center" width="50">조 회</td>
			<td align="center" width="150">작성일</td>
			<td align="center" width="40">수 정</td>
			<td align="center" width="40">삭 제</td>


		</tr>

		<tbody style="padding-left: 10px">
			<c:forEach var="board" items="${boardlist}">
				<tr>
					<td><c:out value="${number}"/>
  	<c:set var="number" value="${number - 1}"/></td>
					<td><a href="detail.do?num=${board.num}&pageNum=${pageNum}">${board.subject}</a></td>
					<td align="center" width="100">${board.writer}</a>
					</td>
					<td align="center" width="50">${board.readcount}</td>
					<td align="center" width="150">${board.reg_date}</td>
					<td align="center" width="40"><input type="button" value="수 정"
						onclick="document.location.href='updateForm.do?num=${board.num}&pageNum=${pageNum}'"></td>
					<td align="center" width="40"><input type="button" value="글삭제"
						onclick="document.location.href='delete.do?num=${board.num}'"></td>


				</tr>
			</c:forEach>
	</table>
	</tbody>
	</table>

	<tr>
		<td><br> <br> 
		</td>
	</tr>

	<div align="center">
	
		<form method="post" style="display: inline" action="list.do">
			<select name="search">
				<option selected="selected">제목</option>
				<option>내용</option>
			</select> <input type="text" size="20" name="string"> <input
				type="submit" class="btn btn-info" value="검색">
		</form>
		<button class="btn btn-success" OnClick="window.location='list.do?pageNum=${pageNum}'">목록보기</button>
	</div>
	</table>
	</div>
	

<c:if test="${count > 0}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if>
         
   <c:if test="${startPage > 10}">
        <a href="list.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="list.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="list.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>	
	
	


</body>
</html>