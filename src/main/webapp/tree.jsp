<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tree.jsp' starting page</title>
    
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
		$(function(){
         $("#tt").tree({
            onSelect:function(node){
            	var id=node.id;
            	$("#dg").datagrid("load",{
            	  id:id
            	});
            }
         })
       })
	</script>
  </head>
  
  <body style="margin: 1px;padding: 1px">
    <div class="easyui-layout" style="width:100%;height:100%;">
		<div data-options="region:'west',split:true" title="部门信息" style="width:15%;">
			<ul id="tt" class="easyui-tree" data-options="url:'querydept'">   </ul>
		</div>
		<div data-options="region:'center',iconCls:'icon-ok'">
		 	<table id="dg" class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:250px" 
		 	    data-options="singleSelect:false,collapsible:false,url:'queryemp',method:'get',pagination:true">
				<thead>
					<tr>
						<th data-options="field:'eid',width:80">员工编号</th>
						<th data-options="field:'ename',width:100">员工姓名</th>
						<th data-options="field:'sal',width:80">员工薪水</th>
					</tr>
				</thead>
		   </table>
		</div>
	</div>
  </body>
</html>
