<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<STYLE>
.cla1 {
FONT-SIZE: 12px; COLOR: #4b4b4b; LINE-HEIGHT: 18px; TEXT-DECORATION: none
}
.login_msg{
	font-family:serif;
}
.login_msg .msg{
	background-color: #acf;
}
.login_msg .btn{
	background-color: #9be;
	width: 73px;
	font-size: 18px;
	font-family: 微软雅黑;
}
</STYLE>

<TITLE></TITLE>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
	<script type="text/javascript">
	
		if(self != top){
			top.location = self.location;
		}
		
	</script>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="${pageContext.request.contextPath}/css/style.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2600.0" name=GENERATOR></HEAD>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0" background="${pageContext.request.contextPath}/images/rightbg.jpg">
<div ALIGN="center">
	<table border="0" width="1140px" cellspacing="0" cellpadding="0" id="table1">
		<tr>
			<td height="93"></td>
			<td></td>
		</tr>
		<tr>
			<td background="${pageContext.request.contextPath}/images/right.jpg"  width="740" height="412"></td>
			<td class="login_msg" width="400">
				<form action="${pageContext.request.contextPath}/login.do" method="post">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/images/title.png" width="185" height="26"/>
					<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="#ff0000" id="f1">
						${error }
					</font> 
					<br/>
					用户名：<input type="text" name="loginName" class="msg" value="${loginName }" onblur="checkLoginName(this.value)" /><br/><br/>
					密&nbsp;&nbsp;码：<input type="password" class="msg" name="loginPwd"/><br/><br/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" class="btn" value="登录 " />
					
				</form>
			</td>
		</tr>
	</table>
	
	<script type="text/javascript">
	function checkLoginName(loginName){ 
		//直接使用jquery的调用方式
		$.ajax({
			"url" : "${pageContext.request.contextPath}/ajaxLoginName.do",
			"data" : "loginName="+loginName,
			"type" : "post",
			"success" : function(data) {
				if(data==1){
					document.getElementById("f1").innerHTML="该用户名可使用";
				}else if(data==0){
					document.getElementById("f1").innerHTML="该用户名不可用";
				}
				
			},
			"error" : function() {
				alert("请求失败");
			}
			});  
	}
		/* s标签中直接编写JavaScript代码时，不支持el表达式，只能提供单独的函数
		function registerUrl(){
			document.location='${pageContext.request.contextPath}/uiAction_staff_register';
		}
		*/
	</script>
</div>
</BODY></HTML>