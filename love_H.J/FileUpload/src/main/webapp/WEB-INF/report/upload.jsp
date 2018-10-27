<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="/AjaxUpload/jquery.form.js"></script>
<script>
$(function(){
	$("#addbutton").click(function(){
		$("input[type='file']:last").after("파일 : <input type='file' name='report' />");		
	});
	$("#delbutton").click(function(){
		$("input[type='file']:last").remove();
	});
	
	
    $("#uploadbutton").click(function(){
        var form = $('form')[0];
        var formData = new FormData(form); /* 중요함 여기다 원하는 폼을 갖다 붙이고 */
            $.ajax({
               url: '/FileUpload/report/ajaxUpload.do',
               processData: false,
               contentType: false,
               data: formData, /*위 주석으로부터 이쪽으로 날려주면됨 */
               type: 'POST',
               success: function(result){
                   alert("업로드 성공!!");
               }

           });
        });
})
</script>
<head>
<title>리포트 제출</title>
</head>
<body>
	<h3>@RequestParam 사용</h3>
	<form method="post" enctype="multipart/form-data">
		학번: <input type="text" name="studentNumber" /> <br />
		 리포트파일: <input type="file" name="report" /> <br /> 
		
		<input type="button" id="addbutton" value="파일 추가" />
		<input type="button" id="delbutton" value="파일 제거" />		
		<input type="button" id="uploadbutton" value="파일 업로드" />
	</form>
</body>
</html>