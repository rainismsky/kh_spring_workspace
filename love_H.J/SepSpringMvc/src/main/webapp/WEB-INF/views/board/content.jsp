<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<title>게시판</title>
<link rel="stylesheet" type="text/css">
<style type='text/css'>
<!--
a:link { color:black; text-decoration:none; }
a:visited {  }
a:active { text-decoration:underline; }
a:hover { text-decoration:underline; background-repeat:repeat-x; background-position:50% 100%; }
-->
</style>
<style>
<!--
@font-face {font-family:굴림; src:url();}
body,td,a,div,p,pre,input,textarea {font-family:굴림;font-size:9pt;}
-->
</style>
</head>

<center><b>글내용 보기</b>
<br>
<form>
<table width="500" border="1" cellspacing="0" cellpadding="0" align="center"> 
  <tr height="30">
    <td align="center" width="125">글번호</td>
    <td align="center" width="125" align="center">${board.num}</td>
    <td align="center" width="125">조회수</td>
    <td align="center" width="125" align="center">${board.readcount}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125">작성자</td>
    <td align="center" width="125" align="center">${board.writer}</td>
    <td align="center" width="125">작성일</td>
    <td align="center" width="125" align="center">${board.reg_date}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125">글제목</td>
    <td align="center" width="375" align="center" colspan="3">${board.subject}</td>
  </tr>
  <tr>
    <td align="center" width="125">글내용</td>
    <td align="left" width="375" colspan="3"><pre>${board.content}</pre></td>
  </tr>
  <tr height="30">     
    <td colspan="4" align="right" >
  <input type="button" value="글수정"
       onclick="document.location.href='updateForm.do?num=${board.num}'">
   &nbsp;&nbsp;&nbsp;&nbsp;
  <input type="button" value="글삭제"
       onclick="document.location.href='delete.do?num=${board.num}'">
   &nbsp;&nbsp;&nbsp;&nbsp;
      <input type="button" value="답글쓰기"
       onclick="document.location.href='SepSpringMvc/board/writeForm.do?num=${article.num}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}'">
   &nbsp;&nbsp;&nbsp;&nbsp;
       <input type="button" value="글목록"
       onclick="document.location.href='list.do?pageNum=${pageNum}'">
    </td>
  </tr>
</table>   
</form>     
</body>
</html> 