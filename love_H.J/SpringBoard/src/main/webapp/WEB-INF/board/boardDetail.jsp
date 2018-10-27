<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
</style>
</head>
<body>
<div style="width:1080px;"align="center">
<h2>상세페이지</h2>
</div>
<table>
	<tr>
		<td>제목</td>
		<td>${list.title}</td>
		<td>파일첨부</td>
		<td><a href="file.do?no=${list.no}">${list.filename}</a></td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${list.name }</td>
		<td>등록일</td>
		<td>${list.bdate }</td>
	</tr>
	<tr>
		<td colspan="4"><textarea name="content" style="resize:none;" rows="20" cols="150" readonly>${list.content}</textarea></td>
</table>
	<br>
	<div style="width:1080px;"align="right">
	<input type="button" value="목록" onclick="javacript:location.href='list.do'" >
	<input type="button" value="수정" onclick="javacript:location.href='updateFrom.do?no=${list.no}'" >
	</div>
</body>
</html>