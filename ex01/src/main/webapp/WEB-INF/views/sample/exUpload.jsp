<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 파일  업로드 시 파일 선택을 위한 양식을 제공 -->
<!-- POST방식으로 요청이  감 꼭 지정해줘야함-->
<form action='/sample/exUploadPost' method="post"  enctype="multiPART/form-data">
	<div>
		<input type='file' name='files'>
	</div>
	<div>
		<input type='file' name='files'>
	</div>
	<div>
		<input type='file' name='files'>
	</div>
	<div>
		<input type="submit">
	</div>
</form>
</body>
</html>