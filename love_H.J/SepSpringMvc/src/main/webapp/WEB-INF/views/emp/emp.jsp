<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 
    String cp = request.getContextPath(); 
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

<script>
$(function(){
	var url="<%=cp%>/emp/empnolist.do";//주소
	var params="dumi="+new Date();
	
	$.ajax({
		type:"post"
		,url:url	
		,data:params
		,dataType:"json"
		,success:function(args){
			 for(var idx=0; idx<args.data.length; idx++) {
				 $("#empno").append("<option value='"+args.data[idx]+"'>"+args.data[idx]+"</option>"); 
	
			 }
		}
	    ,error:function(e) { 
	    	alert(e.responseText);
	    }
	});
});

function empList() {
	var empno=$("#empno").val();

	/* if(empno=="" && $("#empno").val == "") {	                
		$("#emp").html(); 
		
		return;
	} */
	
	
	    var url="<%=cp%>/emp/empList.do";
		var params = "empno=" + empno + "&dumi=" + new Date();

		$.ajax({
			type : "post",
			url : url,
			data : params,
			dataType : "json",
			success : function(args) {
				var date = new Date(eval(args.emp['hiredate']['time']));
				var hiredateStr
				= date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate();
				$("#emp").html(
						"empno  " + args.emp.empno + 
						"<br>ename  "+ args.emp.ename + 
						"<br>comm  " + args.emp.comm+ 
						"<br>hiredate  " + hiredateStr+ 
						"<br>job  " + args.emp.job + 
						"<br>sal  "+ args.emp.sal + 
						"<br>mgr  " + args.emp.mgr);
				
			/* 	var data in args.emp) {
			if(data==('hiredate')) {
			   var date = new Date(eval(args.emp['hiredate']['time']));
			   var hiredateStr
			= date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate();
			$("#emp table").append("<tr><td>"+data+" : "+hiredateStr+"</td></tr>"
			}else{
			$("#emp table").append("<tr><td>"+data+" : "+args.emp[data]+"</td></tr>"
			} */

			},
			error : function(e) {
				alert(e.responseText);
			}
		});

	}
</script>

</head>
<body>

	<select id="empno" onchange="empList();">
		<!-- onchange로 선택이 될때마다 cityList()실행 -->
		<option value="">::사번선택::</option>
	</select>

	<div id="emp"></div>

</body>
</html>
