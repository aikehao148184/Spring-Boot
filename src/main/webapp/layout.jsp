<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'layout.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		function urlClick(myName,myUrl){
			 var ifExist= $("#myTabs").tabs("exists",myName);
			 if(!ifExist){
			 	$("#myTabs").tabs("add",{
					title:myName,
					closable:true,
					content:'<iframe frameborder=0 width="100%" height="100%" scrolling="no"  src="'+myUrl+'"></iframe>'
				})
			 }
			 $("#myTabs").tabs("select",myName);
		}
	</script>
  </head>
  
  <body style="margin: 1px;padding: 1px">
    <div class="easyui-layout" style="width:100%;height:100%;">
		<div data-options="region:'north'" style="height:13%">
			<div><img src="001.jpg" width="100%" height="100%"></div>
		</div>
		<div data-options="region:'west',split:true" title="导航菜单" style="width:15%;">
			<div class="easyui-accordion" style="width:500px;height:300px;">
				<div title="权限管理"  style="overflow:auto;padding:10px;">
					<a href="#" style="text-decoration: none;"><img src="themes/icons/man.png">用户管理 <br/></a>
					<a href="javascript:urlClick('学生管理','crud.jsp')"  style="text-decoration: none;"><img src="themes/icons/tip.png" style="margin-top:5px">学生管理<br/></a>
					<a href="javascript:urlClick('企业管理','tree.jsp')"  style="text-decoration: none;"><img src="themes/icons/tip.png" style="margin-top:7px">企业管理</a>
				</div>
				<div title="系统设置"  style="padding:10px;"></div>
		    </div>
		</div>
		<div data-options="region:'center',iconCls:'icon-ok'">
		  <div id="myTabs" class="easyui-tabs" style="width:100%;height:100%">
		     <div title="欢迎使用" style="padding:10px" ></div>
		  </div>
		</div>
	</div>
  </body>
</html>
