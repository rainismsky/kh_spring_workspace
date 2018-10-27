<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>구매관리</title>
<link rel="stylesheet" type="text/css">

</head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<body>


	<br>
	<br>
	<div align="center">
		<h3>비품 폐기 관리</h3>
	</div>
	<br>
	<br>
	<div id="disposal">

		<table class="table table-hover" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="35">

				<td align="center" width="80">비품 고유 번호</td>
				<td align="center" width="100">비품명</td>
				<td align="center" width="100">폐기 사유</td>

			</tr>

			<tbody style="padding-left: 10px">
				<c:forEach var="disposal" items="${disposallist}">
					<tr>

						<td align="center" width="60">${disposal.eq_no}</td>
						<td align="center" width="80">${disposal.eq_name}</td>
						<td align="center" width="80">${disposal.di_reason}</td>

				</c:forEach>
				

				</td>
		</table>
		</tbody>
		</table>

		<tr>
			<td><br> <br></td>
		</tr>


		</table>
	</div>


	<c:if test="${count > 0}">
		<c:set var="pageCount"
			value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
		<c:set var="pageBlock" value="${10}" />
		<fmt:parseNumber var="result" value="${currentPage / 10}"
			integerOnly="true" />
		<c:set var="startPage" value="${result * 10 + 1}" />
		<c:set var="endPage" value="${startPage + pageBlock-1}" />
		<c:if test="${endPage > pageCount}">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>

		<c:if test="${startPage > 10}">
			<a href="disposallist.do?pageNum=${startPage - 10}">[이전]</a>
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="disposallist.do?pageNum=${i}">[${i}]</a>
		</c:forEach>

		<c:if test="${endPage < pageCount}">
			<a href="disposallist.do?pageNum=${startPage + 10}">[다음]</a>
		</c:if>
	</c:if>




</body>
</html>