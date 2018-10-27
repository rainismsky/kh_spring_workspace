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
<h2>글 등록</h2>
</div>
<form action="insert.do" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<td>제목</td>
		<td><input type="text" name="title"/></td>
		<td>파일첨부</td>
		<td><input type="file" name="filename"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name"/></td>
		<td>패스워드</td>
		<td><input type="password" name="pwd"/></td>
	</tr>
	<tr>
		<td colspan="4"><textarea name="content" style="resize:none;" rows="20" cols="150"></textarea></td>
</table>

	<div style="width:1080px;"align="right">
	<br><input type="submit" value="등록">
		<input type="button" value="목록" onclick="javacript:location.href='list.do'" >
	</div>
</form>
</body>
</html>