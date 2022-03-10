<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<%-- ���� jQuery --%>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>ȸ�� ���� �߰�</h1>
		
		<div class="form-group">
			<label for="name"><b>�̸�</b></label>
			<div class="d-flex">
				<input type="text" id="name" name="name" class="form-control col-3" placeholder="�̸��� �Է��ϼ���">
				<button type="button" class="btn btn-info" id="nameCheckBtn">�ߺ�Ȯ��</button>	
			</div>
			<small id="nameStatusArea"></small>
		</div>
		
		<button type="button" class="btn btn-success" id="joinBtn">�����ϱ�</button>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(e) {
			$('#nameCheckBtn').on('click', function() {
				// #nameStatusArea ���� �±׵��� �ʱ�ȭ
				$('#nameStatusArea').empty(); // �ڽ� �±׵��� ��� ���
				
				let name = $('#name').val().trim();
				
				// �̸��� �ԷµǾ� �ִ��� Ȯ��
				if (name == '') {
					$('#nameStatusArea').append('<span class="text-danger">�̸��� ����ֽ��ϴ�.</span>');
					return;
				}
				
				// �̸��� �ߺ����� DB���� ��ȸ => ajax ���
				$.ajax({
					type : "GET"
					, url : "/lesson06/ex02/is_duplication"
					, data : {"name" : name}
					, success: function(data) {
						if (data.is_duplication == true) { // �ߺ��̸�
							$('#nameStatusArea').append('<span class="text-danger">�ߺ��� �̸��Դϴ�.</span>');
						}
					},
					error : function(e) {
						alert("���� : " + e);
					} 
				});
			});
			
			// ȸ�� ���� ��ư Ŭ��
			$('#joinBtn').on('click', function() {
				
				console.log($('#nameStatusArea').children().length);
				
				if ($('#nameStatusArea').children().length < 1) {
					alert("����� ����");
				} else {
					alert("����� �Ұ�")
				} 
			});
		});
	</script>
</body>
</html>