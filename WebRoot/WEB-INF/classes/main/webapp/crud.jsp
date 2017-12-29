<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'crud.jsp' starting page</title>
    
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
		function sexFormatter(value,row,index){
           if(value==1){
		      return '男';
		    }else{
		      return '女';
		    }
        }
        
        //自定义验证 
        $.extend($.fn.validatebox.defaults.rules, {    
		    isNum: {    
		        validator: function(value, param){ 
		        	if(isNaN(value)){
		        		return false;
		        	} 
		        	return true;  
		        },    
		        message: '没啥用'  
		    }    
		});
        
        function querystudent(){
        	var stuname = $("#cha").textbox("getValue");
        	$("#tb").datagrid("load",{
        		sname:stuname
        	});
        }
        
        function updatestudent(){
        	var updatestu = $("#tb").datagrid("getSelected");
        	$('#ff').form('submit', {
				url:"update/"+updatestu.sid,
				success: function(msg){
					msg = JSON.parse(msg);
					if(msg.code==0){
						$.messager.alert("提示消息","修改成功");
						querystudent();
						$("#w").window('close');
					}else{
						$.messager.alert("错误消息",msg.message);
					}
				}
			});
        }
        
        function savestudent(){
        	$('#fo').form('submit', {
				url:"save",
				success: function(msg){
					$.messager.alert("提示消息","新增成功");
					querystudent();
					$("#d").window('close');
				}
			});
        }
        
        function clearupdate(){
        	var clear = $("#tb").datagrid("getSelected");
        	$("#ff").form('load',clear);
        }
        
        function clearsave(){
        	$('#fo').form('clear');
        }
        
        $(function(){
        	$("#tb").datagrid({
        		rownubers:true,
        		toolbar: [
	        		{
						iconCls: 'icon-edit',
						text:"修改",
						onClick:function(){
							var update = $("#tb").datagrid("getSelected");
							if(update==null){
								$.messager.alert("提示消息","请选择一行数据");
								return;
							}
							$("#w").window('open');
							$("#ff").form('load',update);
						}
					}
					,
					{
						iconCls: 'icon-remove',
						text:"删除",
						onClick:function(){
							//获取当前选中的行
							var select = $("#tb").datagrid("getSelected");
							if(select==null){
								$.messager.alert("提示消息","请选择一行数据");
								return;
							}
							var sid = select.sid;
							$.ajax({
							   type: "POST",
							   url: "delete/"+sid,
							   dataType: "json",
							   data:'_method=delete',
							   success: function(msg){
							    	if(msg.code==0){
							    		$.messager.alert("提示消息","删除成功");
							    		querystudent();
							    	}else{
							    		$.messager.alert("错误消息",msg.message);
							    	}
								}    	
							});
						}
					}
					,
					{
						iconCls: 'icon-add',
						text:"新增",
						onClick:function(){
							$("#d").window('open');
						}
					}
				]
        		
        	})
        })
	</script>
  </head>
  
  <body style="margin: 2px">
  	学生姓名:<input id="cha" class="easyui-textbox" type="text" name="name" data-options="required:true"></input>
  	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="querystudent()" style="width: 50px;">搜&nbsp;索</a><tr/>
  	<div style="height: 2px"></div>
    <table id="tb" class="easyui-datagrid" title="学生信息:" style="width:50%;height:50%"
			data-options="singleSelect:false,collapsible:true,url:'query',method:'get',pagination:true,rownumbers:true,striped:true">
		<thead>
			<tr>
				<th data-options="field:'sid',width:80">学生编号</th>
				<th data-options="field:'sname',width:100">学生姓名</th>
				<th data-options="field:'ssex',width:80,align:'right',formatter:sexFormatter">性别</th>
				<th data-options="field:'saddress',width:250">地址</th>
			</tr>
		</thead>
	</table>
	
	<div id="w" class="easyui-window" title="学生信息修改:" data-options="iconCls:'icon-save',closed:true" style="width:300px;height:200px;padding:5px;">
		<div class="easyui-layout" data-options="fit:true">
			<form id="ff" method="post">
	    	<table cellpadding="5">
	    		<input type="hidden" name="_method" value="put"/> 
	    		<tr>
	    			<td>名字:</td>
	    			<td><input class="easyui-textbox" type="text" name="sname" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td>
	    				<select class="easyui-combobox" name="ssex" style="width: 160px">
	    					<option value="0">女</option>
	    					<option value="1">男</option>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>地址:</td>
	    			<td><input class="easyui-textbox" type="text" name="saddress" data-options="required:true"></input></td>
	    		</tr>
	    	</table>
	    	</form>
	    	<div style="text-align:center;padding:5px">
	    		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="updatestudent()">修改</a>
	    		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearupdate()">重置</a>
	    	</div>
		</div>
	</div>
	
	<div id="d" class="easyui-window" title="新增学生信息:" data-options="iconCls:'icon-save',closed:true" style="width:300px;height:250px;padding:5px;">
		<div class="easyui-layout" data-options="fit:true">
			<form id="fo" method="post" enctype="multipart/form-data">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>名字:</td>		<!-- missingMessage 当文本框未填写时出现的提示信息。 -->
	    			<td><input class="easyui-textbox" type="text" name="sname" data-options="required:true,missingMessage:'此项不能为空'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td>
	    				<select class="easyui-combobox" name="ssex" style="width: 160px">
	    					<option value="0">女</option>
	    					<option value="1">男</option>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>地址:</td>			<!-- invalidMessage 当文本框的内容被验证为无效时出现的提示。 -->
	    									<!-- easyUI中默认的日期格式是 d/m/y  需要改成通用的 y-m-d
	    										$.fn.datebox.defaults.formatter = function(date){
													var y = date.getFullYear();
													var m = date.getMonth()+1;
													var d = date.getDate();
													return y+"-"+m+"-"+d;
												 } 
											-->
	    			<td><input class="easyui-textbox" type="text" name="saddress" data-options="required:true,invalidMessage:'必须是4~6位的数字',validType:['isNum','length[4,6]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td>个人照片:</td>
	    			<td><input class="easyui-filebox" name="file" data-options="prompt:'选择一张照片...'" style="width:100%"></td>
	    		</tr>
	    	</table>
	    	</form>
	    	<div style="text-align:center;padding:5px">
	    		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="savestudent()">保存</a>
	    		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearsave()">重置</a>
	    	</div>
		</div>
	</div>
  </body>
</html>
