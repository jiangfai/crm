<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

</head>

<body class="emp_body">
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[添加/编辑咨询学生]</td>
   
    <td width="52%"align="right">
    	<!--<a href="listLog.html"><img src="${pageContext.request.contextPath}/images/button/find.gif" class="img"/></a>
        <a href="addLog.html"><img src="${pageContext.request.contextPath}/images/button/add.gif" class="img"/></a>~-->
        
       <!-- <a href="#"><img src="${pageContext.request.contextPath}/images/button/close.gif" class="img"/></a>-->
       <%--保存 --%>
       <a href="javascript:void(0)" onclick="document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/save.gif" /></a>
       <a href="#"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<form  action="referAction_addOrEdit">
	<input type="hidden"  name="referId" value=""/>
	<%--状态只有编班之后才修改 --%>
	<input type="hidden"  name="status" value=""/>
	<table width="89%" class="emp_table"    style="" align="left" cellspacing="0">
	  <tr>
	    <td width="120px" height="35" align="left" >姓名：</td>
	    <td width="300px" align="left">
	    	<input type="text" name="name"/>
	    </td>
	    <td>
	    	<%-- 状态：咨询中--%>
	    </td>
	  </tr>
	  <tr>
	    <td>电话：</td>
	    <td><input type="text" name="telephone"/></td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>QQ：</td>
	    <td><input type="text" name="qq"/></td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>咨询人：</td>
	    <td><input type="text" name="staffName" value=""/></td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>意向级别：</td>
	    <td>
	    	<select name="select" id="select">
			    <option value="t">1</option>
			  </select>
	    </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>意向学科：</td>
	    <td>
	    <select name="courseTypeId" id="courseName">
		    <option value="t">1</option>
		  </select>
	    	&nbsp;&nbsp;&nbsp;意向班级：
	    	<select name="courseTypeId" id="classId">
		    <option value="t">1</option>
		  </select>
	    </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td height="41" align="left">来源：</td>
	    <td align="left">
	    	
			<select name="courseTypeId" id="classId">
		    <option value="t">1</option>
		  </select>	    	
	    </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td align="left">备注：</td>
	    <td align="left">
	    	<textarea rows="5" cols="60" name="remark"></textarea>
	    </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td colspan="3">&nbsp;</td>
	  </tr>
	</table>
</form>

	<script type="text/javascript">
		function changeClass(courseTypeObj){
			//1 选择的部门id
			var courseTypeId = courseTypeObj.value;
			
			//2 发送ajax 通过部门id 查询对应职务
			var url = "${pageContext.request.contextPath}/classesm/classAction_ajaxGetClass?crmCourseType.courseTypeId=" + courseTypeId;
			
			//2.1 创建核心对象
			var xmlhttp=null;
			if (window.XMLHttpRequest) {
				xmlhttp=new XMLHttpRequest();
			}else if (window.ActiveXObject) {// code for IE5 and IE6
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			// 2.2 设置回调函数，当ajax请求完成之后，进行处理
			xmlhttp.onreadystatechange = function(){
				// * 发送成功， 并发送的正常页面
				if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					
					var classSelectObject = document.getElementById("classSelectId");
					classSelectObject.innerHTML = "<option>----请--选--择----</option>";
					
					//获得数据 json，并处理
					//@1 获得普通文本数据
					var textData = xmlhttp.responseText;
					//@2 将文本转换成json数据  eval()  ,但兼容  eval("("+...+")")
					var jsonData = eval("("+textData+")");
					//@3 遍历数据，将数据添加到“职务”select
					for(var i = 0 ; i < jsonData.length ; i ++){
						var classObj = jsonData[i];
						// @3.1 编号
						var classId = classObj.classId;
						// @3.2 名称
						var className = classObj.name;
						// @3.3 追加
						classSelectObject.innerHTML = classSelectObject.innerHTML + "<option value='"+classId+"'>"+className+"</option>";
					}
				}
			};
			
			// 2.3 打开连接 ,以get请求方式发送数据
			xmlhttp.open("get",url);
			
			// 2.4 发送 , 没有请求体的内容，设置成null
			xmlhttp.send(null);
		}
	</script>

</body>
</html>
