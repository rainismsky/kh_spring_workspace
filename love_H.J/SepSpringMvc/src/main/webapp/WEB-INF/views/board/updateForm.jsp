<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<title>게시판</title>

<script language="JavaScript" src="script.js"></script>
</head>


<center><b>글수정</b>
<br>
<form class="form-horizontal" method="post" name="writeform" action="updatePro.do" onsubmit="return writeSave()">
<table width="400" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td  width="70" align="center">이 름</td>
    <td align="left" width="330">
       <input type="text" size="10" maxlength="10" name="writer" value="${board.writer}">
   	<input type="hidden" name="num" value="${board.num}">
    </td>
  </tr>
  <tr>
    <td  width="70" align="center" >제 목</td>
    <td align="left" width="330">
       <input type="text" size="40" maxlength="50" name="subject" value="${board.subject}"></td>
  </tr>
  
  <tr>
    <td  width="70" align="center" >내 용</td>
    <td align="left" width="330">
     <textarea name="content" rows="13" cols="40">${board.content}</textarea></td>
  </tr>
  
  </tr>
  <tr>     
   <td colspan=2 align="center">
     <input type="submit" value="글수정" > 
     <input type="reset" value="다시작성">
     <input type="button" value="목록보기"
       onclick="document.location.href='list.do'">
   </td>
</tr>
</table>
</form>
</body>
</html> 