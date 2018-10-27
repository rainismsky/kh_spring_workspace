<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>구매관리</title>
<link rel="stylesheet" type="text/css">
</head>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<body>

	<div align="center">
		<h3>비품 상세(재고:${count})</h3>
	</div>
	<br>
	<br>
	<div id="purchase">

<select id="eq_no" onchange="cityList();">	
  <option value="">::비품고유번호::</option>
</select>

		<table class="table table-hover" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="35">

				<td align="center" width="80">비품 고유번호</td>
				<td align="center" width="80">비품명</td>
				<td align="center" width="80">사용부서</td>
				<td align="center" width="80">비품상태</td>
			</tr>
			       
  <tr>     
       <input type="button" value="취소"
       onclick="document.location.href='list.do?pageNum=${pageNum}'">
   </td>
</tr>
</table>
</form>


</div>



</body>
</html>
