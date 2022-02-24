<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 정보</title>
  <!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	
	<div class="container">
		<h1 class="display-4">${subject}</h1>
		
		<%-- class: table-striped 짝수번째 행에 색 적용 --%>
		<table class="table table-striped">
			<tr>
				<th>번호</th>
				<td>${result.id}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${result.name}</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>${result.yyyymmdd}</td>
			</tr>
			<tr>
				<th>자기소개</th>
				<td>${result.introduce}</td>
			</tr>
			<tr>
				<th>이메일 주소</th>
				<td>${result.email}</td>
			</tr>
			<tr>
				<th>생성일</th>
				<td>${result.createdAt}</td>
			</tr>
			<tr>
				<th>수정일</th>
				<td>${result.updatedAt}</td>
			</tr>
		</table>
	</div>
</body>
</html>