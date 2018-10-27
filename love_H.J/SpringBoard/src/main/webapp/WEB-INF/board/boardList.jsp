<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<style>
  table {
    width: 1080px;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
  	colspan:center;
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
</style>
</head>
<body>
<div style="width:1080px;"align="center">
<h2>게시판</h2>
</div>
<div style="width:1080px;"align="right">
<form action="list.do" method="post">

<input type="text" name="search">
<input type="submit" value = "검색">
</form>
</div>
<table>
	<tr>
		<th>순번</th>
		<th>이름</th>
		<th>제목</th>
		<th>파일이름</th>
		<th>등록날짜</th>
		<th>조회수</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="board" items="${list}">
	<tr>
		<td><c:out value="${number }"/>
			<c:set var="number" value="${number-1}"/></td>
		<td>${board.name}</td>
		<td><a href="detail.do?no=${board.no}"style="color: black;">${board.title}</a></td>
		<td>${board.filename}</td>
		<td>${board.bdate}</td>
		<td>${board.vcount}</td>
		<td><input type="button" value="삭제" onclick="javacript:location.href='delete.do?no=${board.no}'"></td>
	</tr>
	</c:forEach>
</table>
	 <c:choose>
					    <c:when test="${empty search}">
					     <div style="width:1080px;"align="center">
						<table >
						  	<tr>
						  		<td align="center" style="border: 0px" >
								<c:set var="pageCount" value="${count/pageSize+(count%pageSize==0 ? 0:1)}"/>
								<c:set var="pageBlock" value="${10}"/>
								<fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />   
								<c:set var="startPage" value="${result *10 +1}"/>   
								<c:set var="endPage" value="${startPage + pageBlock-1}"/>
								<c:if test="${endPage > pageCount}">
									<c:set var="endPage" value="${pageCount}"/>
								</c:if>
								<c:if test="${startPage>10}">
									<a href="list.do?pageNum=${startPage-10}" style="color: black;">[이전]</a>
								</c:if>
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<a href="list.do?pageNum=${i}"style="color: black;">[${i}]</a>
								</c:forEach>
								<c:if test="${endpage<pageCount}">
									<a href=list.do?pageNum=${startPage+10}" style="color: black;">[다음]</a>
								</c:if>
							</td>
						</tr>
						</table>
						</div>	    
						</c:when>
					
					    <c:otherwise>
					    <div  style="width:1080px;"align="center" >
					      	<table>
						  	<tr>
						  		<td style="border: 0px" >
								<c:set var="pageCount" value="${count/pageSize+(count%pageSize==0 ? 0:1)}"/>
								<c:set var="pageBlock" value="${10}"/>
								<fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />   
								<c:set var="startPage" value="${result *10 +1}"/>
								<c:set var="endPage" value="${startPage + pageBlock-1}"/>
								<c:if test="${endPage > pageCount}">
									<c:set var="endPage" value="${pageCount}"/>
								</c:if>
								<c:if test="${startPage>10}">
									<a href="list.do?pageNum=${startPage-10}&search=${search}" style="color: black;">[이전]</a>
								</c:if>
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<a href="list.do?pageNum=${i}&search=${search}"style="color: black;">[${i}]</a>
								</c:forEach>
								<c:if test="${endpage<pageCount}">
									<a href="list.do?pageNum=${startPage+10}&search=${search}" style="color: black;">[다음]</a>
								</c:if>
								</td>
							</tr>
							</table>
						</div>
					    </c:otherwise>
					</c:choose>
<br>
<div style="width:1080px;"align="right">

<input type="button" value="글등록" onclick="javacript:location.href='boardInsert.do'">
</div>


</body>
</html>