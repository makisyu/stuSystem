<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			$.ajax({
				url:'mac',
				dataType:'json',
				type:'post',
				data:{"macCode":$("#macCode").val()},
				success:function(data){
					
					if(data.type == 'warning'){
						$.messager.alert('信息提示','激活失败，您输入的MAC值有误，请重新输入！！！','info',function(){
							window.parent.location = 'mac';
						});
						return;
					}
					
					if(data.type == 'success'){
						$.messager.alert('信息提示','恭喜，激活成功！','info',function(){
							window.parent.location = 'login';
						});
						return;
					}
				}
			});
		});
	})
</script>
</head>
<body>
	<center style="padding-top: 200px">
		<form id="formMac" name="formMac">
		MAC码：<input type="text" id="macCode" name="macCode"/><br/>
		<input type="button" id="btn" value="激活"/>
	</form>
	</center>
</body>
</html>