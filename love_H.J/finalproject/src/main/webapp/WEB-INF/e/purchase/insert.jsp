<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page trimDirectiveWhitespaces="true"%>

<html>
<head>
<title>게시판</title>
<link rel="stylesheet" type="text/css">

</head>

<title>글쓰기</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

<script>
function cityList() {//메모리에올려놈
	var separate=$("#pc_separate").val();
	
	if(separate=="") {	                // snum에 ""가 선택되어있다면
		$("#pc_name option").each(function() {	//ID가 city이며 option인 요소를 
			$("#pc_name option:eq(1)").remove();	//city option의 1번째를 계속 삭제(0번째만 남기고 모두 지우게 된다) ,  eq : 지정된 index 번째의 엘리먼트 선택
		});


		//$("#city").append("<option value=''>::도시선ㅋ::</option>");	// 위의 반복문으로 모두 삭제되어 있으므로 추가해준다.
		// 위의 명령문은 바로의 위의 엘리먼트가 1이아닌 0이었을 때 사용하면 됨.
		return;
	}
	
	var url="<%=request.getContextPath()%>/HJ/purselect.do";
	var params = "separate=" + separate; //separate='소모품'

		$.ajax({
			type : "post",
			url : url,
			data : params,
			dataType : "json",
			success : function(args) {
				$("#pc_name option").each(function() { //id가 city인 option요소에 적용할 반복문
					$("#pc_name option:eq(0)").remove(); // city option의 0번째 항목이 없을때까지 0번쨰 항목을 지운다. (기존에 있는거 모두 지운다.)
				});

				$("#pc_name").append("<option value=''>::물건선택::</option>"); // 도시선택을 붙인다.

				for (var idx = 0; idx < args.data.length; idx++) { // 새로 가져온 데이터를 데이터 갯수만큼 반복해서 붙여준다.
					var item = args.data[idx];//area2(맵객체)
				

					$("#pc_name").append(
							"<option value='"+item+"'>"
									+ item + "</option>");
					// append : 셀렉터로 선택된 (여기서는 id가 city인 ) 자식에게 계속 내용을 붙여준다. 기존 자식이 있다면 그 뒤에 붙여줌.

					//$("#city").append("<option value='"+args.data1[idx]['AREA2']+"'>"+args.data1[idx]['AREA2']+"</option>");
					//이런 형태도 가능
				}
				$("#pc_name").append("<option value='write'>직접입력</option>"); // 도시선택을 붙인다.
			},
			error : function(e) {
				alert(e.responseText);
			}
		});
	}

</script>

<script>
$(function() {
  $( "#datepicker1" ).datepicker({
    dateFormat: 'yy-mm-dd'
  });
}); //datepicker
</script>

	
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

<b><h3>비품 구매</h3></b>
<br>
<form class="form-horizontal" method="post" 
        action="insertPro.do" name="userinput" onSubmit="return checkIt()">
<table width="400" border="1" cellspacing="0" cellpadding="0">

  <tr>
    <td  width="70" align="center" >구매일</td>
    <td align="left" width="330">
       <input type="text" id="datepicker1" name="pc_buydate"></td>
          </tr>  
  <tr>
    <td  width="70" align="center" >비품</td>
    <td align="left" width="330">
    
       <select id="pc_separate" onchange="cityList();">	
  <option value="">::비품/소모품::</option>
  <option value="비품">비품</option>
  <option value="소모품">소모품</option>
</select>

<select id="pc_name">
  <option value="0">::물건선택::</option>
</select></td>
  </tr>
  
  <tr>
    <td  width="70" align="center">수량</td>
    <td align="left" width="330">
     <input name="text"  placeholder="수량을 입력해주세요." rows="13" cols="80" name="pc_quantity"></td>
  </tr>
  <tr>
  
    <tr>
    <td  width="70" align="center">금액</td>
    <td align="left" width="330">
     <input name="text" placeholder="금액을 입력해주세요." rows="13" cols="80" name="pc_sum"></td>
  </tr>
  <tr>

          
                    
          
          
          
  <tr>     
   <td colspan=2 align="center">
     <input type="submit" value="등록" > 
       <input type="button" value="취소"
       onclick="document.location.href='list.do?pageNum=${pageNum}'">
   </td>
</tr>
</table>
</form>


</div>



</body>
</html>
