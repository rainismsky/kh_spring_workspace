<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 작성</title>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script> <!-- 좌측 코드는 자바 스크립트를 쓰기 위해 꼭 필요한 명령 선언 -->
<script>
$(document).ready(function (){
	$("#btnSave").click(function(){
		
		//var title=document.form.title.value; ==> name속성으로 처리할 경우
		//var content=document.form.content.value;
		//var writer=document.form.writer.value;
		
		var title=$("#title").val();
		var content=$("#content").val();
		var writer=$("#writer").val();
		
/* 		console.log("title --> "+title);
		console.log("content --> "+content);
		console.log("writer --> "+writer); */
		
		if(title == ""){
			alert("제목을 입력 하세요");
			document.form.content.focus();
			return false;
		
		}else if(content==""){
			alert("내용을 입력 하세요");
			document.form.title.focus();
			return false;
			
		}else if(writer == ""){
			alert("이름을 입력하세요");
			document.form.writer.focus();
			return false;
		}
	});
});
		//폼에 입력한 데이터 서버로 전송!
</script>
</head>
<body>

<%-- <a href="${pageContext.request.contextPath}/board/list.do">게시글 작성</a> --%> <!-- <= 로고를 눌러 메인화면으로 보낼때 쓰면 유용할것 같다 -->

<h2>게시글 작성</h2>

<form name="form" method="post" action="${pageContext.request.contextPath}/board/insert.do">

	<div>
		제목 
		<input name="title" id="title" size="80" placeholder="제목을 입력하세요">
	</div>
	<div>
		내용
		<textarea name="content" id="content" rows="4" cols="80"
			placeholder="내용을 입력 하세요"></textarea>
	</div>
	<div>
		이름 
		<input name="writer" id="writer" placeholder="이름을 입력하세요">
		</div>
	<div style="width:650px; text-align:center;">
		<button type="submit" id="btnSave">확인</button>
		<button type="reset">재 작성</button>	
		
		<input type="button" value="글 목록"
       onclick="document.location.href='list.do'"> <!-- onclick페이지 넘길때 쓴다 -->
	
	</div>
</form>
</body>
</html>