<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 입력</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<%-- 원본 jQuery --%>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<form method="post" action="/lesson06/ex01/add_user">
			<div class="form-group">
				<label for="name"><b>이름</b></label>
				<input type="text" id="name" name="name" class="form-control col-3" placeholder="이름을 입력하세요">
			</div>
			<div class="form-group">
				<label for="yyyymmdd"><b>생년월일</b></label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-3" placeholder="예)20190101">
			</div>
			<div class="form-group">
				<label for="email"><b>이메일</b></label>
				<input type="text" id="email" name="email" class="form-control col-3" placeholder="이메일주소를 입력하세요">
			</div>
			<div class="form-group">
				<label for="introduce"><b>자기소개</b></label>
				<textarea id="introduce" name="introduce" class="form-control col-5" rows="10"></textarea>
			</div>
			
			<input type="button" id="addBtn" class="btn btn-success" value="추가">
		</form>
	</div>
	
	<script type="text/javascript">
	$(document).ready(function() {
		
		// (1) jquery의 submit 기능 이용하기
		/* $("form").on("submit", function(e) {
			//e.preventDefault(); // submit 되는 것을 막는다.
			//alert("추가 버튼 클릭");
			
			// validation
			var name = $('#name').val().trim(); // 이름을 가져와서 공백 제거
			//alert(name);
			if (name == '') {
				alert("이름을 입력해주세요.");
				return false;
			}
			
			var yyyymmdd = $('#yyyymmdd').val().trim();
			if (yyyymmdd == '') {
				alert("생년월일을 입력해주세요.");
				return false;
			}
			
			// 여기까지 도달하면 submit
	    }); */
		
	    
	    // (2) jqeury의 AJAX 통신을 이용하기
		$('#addBtn').on('click', function(e) {
			e.preventDefault(); // submit 되는 것을 막는다.
			
			// validation
			var name = $('#name').val().trim(); // 이름을 가져와서 공백 제거
			if (name == '') {
				alert("이름을 입력해주세요.");
				return;
			}
			
			var yyyymmdd = $('#yyyymmdd').val().trim();
			if (yyyymmdd == '') {
				alert("생년월일을 입력해주세요.");
				return;
			}
			
			if (isNaN(yyyymmdd)) { // 모두 숫자인지 확인
				alert("숫자만 입력해주세요.");
				return;
			}
			
			var introduce = $('textarea[name=introduce]').val(); // 이름 속성으로 가져오기
			
			var email = $('#email').val().trim();
			
			// AJAX: 폼태그와 상관없이 비동기로 별도 요청(request)  
			$.ajax({
				type: "POST",
				url: "/lesson06/ex01/add_user",
				data: {"name":name, "yyyymmdd":yyyymmdd, "introduce":introduce, "email":email},
				success: function(data) {
					alert(data);
					location.href = "/lesson06/ex01/get_user_view";
				},
		        complete : function(data) {
		        	alert("완료");
		        },
				error: function(e) {
					alert("error " + e);
				}
			});
		});
	});
	</script>
</body>
</html>