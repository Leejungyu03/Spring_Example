<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<%-- 원본 jQuery --%>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<div class="form-group">
			<label for="name"><b>이름</b></label>
			<div class="d-flex">
				<input type="text" id="name" name="name" class="form-control col-3" placeholder="이름을 입력하세요">
				<button type="button" class="btn btn-info" id="nameCheckBtn">중복확인</button>	
			</div>
			<small id="nameStatusArea"></small>
		</div>
		
		<button type="button" class="btn btn-success" id="joinBtn">가입하기</button>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(e) {
			$('#nameCheckBtn').on('click', function() {
				// #nameStatusArea 하위 태그들을 초기화
				$('#nameStatusArea').empty(); // 자식 태그들을 모두 비움
				
				let name = $('#name').val().trim();
				
				// 이름이 입력되어 있는지 확인
				if (name == '') {
					$('#nameStatusArea').append('<span class="text-danger">이름이 비어있습니다.</span>');
					return;
				}
				
				// 이름이 중복인지 DB에서 조회 => ajax 통신
				$.ajax({
					type : "GET"
					, url : "/lesson06/ex02/is_duplication"
					, data : {"name" : name}
					, success: function(data) {
						if (data.is_duplication == true) { // 중복이면
							$('#nameStatusArea').append('<span class="text-danger">중복된 이름입니다.</span>');
						}
					},
					error : function(e) {
						alert("실패 : " + e);
					} 
				});
			});
			
			// 회원 가입 버튼 클릭
			$('#joinBtn').on('click', function() {
				
				console.log($('#nameStatusArea').children().length);
				
				if ($('#nameStatusArea').children().length < 1) {
					alert("서브밋 가능");
				} else {
					alert("서브밋 불가")
				} 
			});
		});
	</script>
</body>
</html>