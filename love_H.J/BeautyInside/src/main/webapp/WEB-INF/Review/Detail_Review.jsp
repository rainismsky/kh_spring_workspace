<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!--원하는 날짜 형식으로 지정할때 사용한다.-->

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beauty Inside</title>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

<script>
$(document).ready(function (){
	$("#R_delete").click(function(){
		if(confirm("삭제할까요?")){
			document.form.action="${pageContext.request.contextPath}/Review/delete";
			document.form.submit();
		}
	});
	$("#R_update").click(function(){
		if(confirm("수정할까요?")){
			document.form.action="${pageContext.request.contextPath}/Review/update";
			document.form.submit();
		}
				
		var rcontents=$("#rcontents").val();
		var ra_contents=$("#ra_contents").val();
	
		if(rcontents==""){
			alert("글 내용을 입력 하세요");
			document.form.rcontents.focus();
			return;
		}
		if(ra_contents == ""){
			alert("답글을 입력 하세요");
			document.form.ra_contents.focus();
			return;
		}
		document.form.action="${pageContext.request.contextPath}/Review/update"
		//폼에 입력한 데이터 서버로 전송!
		document.form.submit();
	});
	});
</script>
</head>

<body>
	<form name="form" method="post" action="${pageContext.request.contextPath}/create">
		
		 <%-- <form name="form" method="post" action="${pageContext.request.contextPath}/create" --%>
		
	<h3>나의 후기</h3>
	<hr>
	
	<c:forEach var="dto" items="${list}">
		<tr>
	<%-- 	<td>업체명 : ${dto.ent_name}</td>
			
			<td>담당자 : ${dto.emp_name}</td>
			
			 --%>
				<!-- 원하는 날짜 형식으로 출력을 하기 위한 fmt태그 사용 -->
		<fmt:formatDate value="${dto.r_regdate}" pattern="yyyy-MM-dd a HH:mm:ss"/><br/>
			<!-- 날짜 형식 => yyyy 4자리 연도,mm월,dd일,a 오전/오후, HH 24시간제,hh 12시간제,mm분,ss초-->
			
			<td>평점 : ${dto.r_grade}</td>		
		
		<div style="width: 650px; text-align: right;">
		
		<!-- 내용 -->
		<textarea name="content" id="content" rows="30" cols="100"
			placeholder="내용을 입력 하세요">${dto.rcontents}</textarea>
		
		<div>
			<!-- 게시물 번호를 hidden으로 처리 -->
			<input type="hidden" name="rno" id="content" value="${dto.rno}">
			<button type="submit" id="update" name="update" >수정</button>	
			<button type="submit" id="delete" name="delete">삭제</button>	
			<button type="button" onclick="document.location.href='list_Review'" >목록</button>
		
				<!-- style="margin-center:40%;" 마진영역에 40%효과로 가운대로 맞추는 것? -->
		</div>
		
		<input type="hidden" name="content" value="${dto.r_regdate}">
		<textarea name="content" id="content" rows="5" cols="100"
		placeholder="내용을 등록하세요">${dto.ra_contents}</textarea>	
	</div>
	</c:forEach>
		
		<!-- <button type="reset">재 작성</button> -->
<%-- 	
		<우리 효댕이가 만들어 준 Delete기능>
		<input type="button" value="글 삭제"
       onclick="document.location.href='delete.do?num=${dto.bno}'"> 
--%>

<%-- 	<div>
		제목 <input name="title" id="title" size="80" value="${dto.title}"
			placeholder="제목을 입력하세요">
	</div> 
--%>

	<%-- 이름 :<input name="writer" id="writer" value="${dto.mid}"
			placeholder="재호님">
		 --%>	
		
</form>
</body>
</html>