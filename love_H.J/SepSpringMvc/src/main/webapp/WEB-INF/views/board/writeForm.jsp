<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">


<script type="text/javascript">


  function writeSave(){

     
     if(document.writeform.subject.value==""){
       alert("제목을 입력하십시요.");
       document.writeform.subject.focus();
       return false;
     }

     if(document.writeform.content.value==""){
       alert("내용을 입력하십시요.");
       document.writeform.content.focus();
       return false;
     }
            
    
     }   
  

    </script> 
<title>글쓰기</title>
<style>
body{font-family: 'Do Hyeon', sans-serif;}
table {
    border-top: 1px solid #444444;
    border-collapse: collapse;
    border-color : #e8e8e8;
    width:700px;
    cellpadding:0;
    cellspacing:0;

    
  }
  th, td {
    border-bottom: 1px solid #e8e8e8;
    padding: 10px;
    border-color : #e8e8e8;
    
  }
 th{
    background-color: #f2eee8;
 }
  a{
     text-decoration:none;
     color : black;
  }
  a:hover{
     color: #657c6b;
  }

</style>   

</head>
<body>

<b><h3>글쓰기</h3></b>
<br>
<form class="form-horizontal" method="post" 
        action="writePro.do" name="userinput" onSubmit="return checkIt()">
<table width="400" border="1" cellspacing="0" cellpadding="0">

  <tr>
    <td  width="70" align="center" >작성자</td>
    <td align="left" width="330">
       <input type="text" size="70" maxlength="50" name="writer"></td>
          </tr>  
  <tr>
    <td  width="70" align="center" >제 목</td>
    <td align="left" width="330">
       <input type="text" size="70" maxlength="50" name="subject"></td>
  </tr>
  
  <tr>
    <td  width="70" align="center" >내 용</td>
    <td align="left" width="330">
     <textarea name="content" rows="13" cols="80"></textarea></td>
  </tr>
  <tr>

          
                    
          
          
          
  <tr>     
   <td colspan=2 align="center">
     <input type="submit" value="글쓰기" > 
     <input type="reset" value="다시작성">
       <input type="button" value="글목록"
       onclick="document.location.href='list.do?pageNum=${pageNum}'">
   </td>
</tr>
</table>
</form>


</div>



</body>
</html>
