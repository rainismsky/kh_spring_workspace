<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<body>

<h2>HI ~</h2>
<a href="hello.do">hello.do</a><br/>
<a href="article/newArticle.do">파라미터 값 저장</a><br/>
<a href="order/order.do">list에 파라미터 값 저장</a><br/>
<a href="search/internal.do?query=abc&p=10">@RequestParam1</a><br/>
<a href="search/external.do">@RequestParam2</a><br/>
<a href="cookie/make.do">쿠키 생성</a><br/>
<a href="cookie/view.do">쿠키 보기</a><br/>
<a href="header/check.do">헤더정보 확인</a><br/>
<a href="search/main.do">@ModelAttribute로 모델 생성</a><br/>
<a href="game/game/users/hello/characters/1234">@PathVariable</a><br/>
<a href="account/create.do">유효성 검사</a><br/>
<a href="login/login.do">login@Valid</a><br/>
<a href="report/submission.do">file Upload</a><br/>
<a href="log/query.do">Date저장</a><br>
<a href="event/list.do">인터셉터</a><br>
<a href="math/divide.do?op1=10&op2=0">예외처리</a><br/>
<a href="test/simpleTest.do">ㅋ</a><br>
<a href="city/city.do">city</a><br/>
<a href="emp/emp.do">emplist</a><br/>
<a href="jsp/member/regist">라벨 태그 예제</a><br/>
<a href="jsp/login/login"> 로그인 &lt;form:* /&gt; 태그 및 &lt;spring:massage&gt; 태그 예제</a><br/>
<a href="jsp/login/login?language=en">영문</a><br/>
<a href="jsp/login/login?language=ko">한글</a><br/>
<a href="tiles/login/login.do">tiles/login</a><br/>
<a href="tiles/member/regist.do">regist</a><br/>
<a href="download/file">파일 다운로드</a><br/>
<a href="download/list">dbtable 다운로드</a>
<a href="download/pageRanks">엑셀파일 다운로드</a><br/>
<a href="download/pageReport">pdf다운로드</a><br/>
<a href="download/pageXmlReport">xml전송</a><br/>
<a href="download/pageJsonReport">json전송</a><br/>
<a href="list.do?pageNum=1">게시판</a>

</body>
</html>