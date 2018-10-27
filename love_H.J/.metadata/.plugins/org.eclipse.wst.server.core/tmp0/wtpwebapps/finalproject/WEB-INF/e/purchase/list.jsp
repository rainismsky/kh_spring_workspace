<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>구매관리</title>
<link rel="stylesheet" type="text/css">
<script type="text/javascript">
	function regist(){
		var url = "insert.do"
		window.open
	}
</script>
</head>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<body>


	<br>
	<br>
	<div align="center">
		<h3>구매관리(게시글:${count})</h3>
	</div>
	<br>
	<br>
	<div id="purchase">

		<table class="table table-hover" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="35">

				<td align="center" width="80">비품구분</td>
				<td align="center" width="100">비품명</td>
				<td align="center" width="100">수량</td>
				<td align="center" width="80">금액</td>
				<td align="center" width="100">구매일</td>
				<td align="center" width="80">등록상태</td>
			</tr>

			<tbody style="padding-left: 10px">
				<c:forEach var="purchase" items="${purchaselist}">
					<tr>

						<td align="center" width="80">${purchase.pc_separate}</td>
						<td align="center" width="100">${purchase.pc_name}</td>
						<td align="center" width="100">${purchase.pc_quantity}</a>
						</td>
						<td align="center" width="80">${purchase.pc_sum}</td>
						<td align="center" width="100">${purchase.pc_buydate}</td>

						<c:if test="${purchase.pc_state eq '등록'}">
							<td align="center" width="80">등록완료</td>
						</c:if>

						<c:if test="${purchase.pc_state eq '미등록'}">
							<c:choose>
								<c:when test="${purchase.pc_separate eq '비품'}">
									<td align="center" width="80"><input type="button"
										value="비품등록"
										onclick="document.location.href='updateForm.do?num=${purchase.pc_no}&pageNum=${pageNum}'"></td>
								</c:when>

								<c:when test="${purchase.pc_separate eq '소모품'}">
									<td align="center" width="80"><input type="button"
										value="소모품등록"
										onclick="document.location.href='updateForm.do?num=${purchase.pc_no}&pageNum=${pageNum}'"></td>
								</c:when>
							</c:choose>
						</c:if>
					</tr>
				</c:forEach>
				<input type="button" value="등록하기"
					onclick="regist()">
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
			<a href="purchaselist.do?pageNum=${startPage - 10}">[이전]</a>
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="purchaselist.do?pageNum=${i}">[${i}]</a>
		</c:forEach>

		<c:if test="${endPage < pageCount}">
			<a href="purchaselist.do?pageNum=${startPage + 10}">[다음]</a>
		</c:if>
	</c:if>




</body>
</html>