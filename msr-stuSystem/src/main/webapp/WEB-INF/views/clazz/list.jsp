<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../common/header.jsp"%>
<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="wu-toolbar">
        <div class="wu-toolbar-button">
            <%@include file="../common/menus.jsp"%>
        </div>
       
        <div class="wu-toolbar-search">
        		<label>班级名称:</label> 
	            <input id="search-clazzName"  class="easyui-combobox"  data-options="editable: false,valueField:'clazzId',textField:'clazzName',url:'${pageContext.request.contextPath}/admin/clazz/getClazzNameList'" style="width:100px" />
	            &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
	            <label>授课老师:</label> 
	            <input id="search-teacherName"  class="easyui-combobox"  data-options="editable: false,valueField:'teacherId',textField:'teacherName',url:'${pageContext.request.contextPath}/admin/teacher/getTeacherNameList'" style="width:100px" />
	             &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
	            <a href="#" id="search-btn" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
		</div>
    </div>
    <!-- End of toolbar -->
    <table id="data-datagrid" class="easyui-datagrid" toolbar="#wu-toolbar"></table>
</div>
<!-- Begin of easyui-dialog -->
<!-- 添加窗口 -->
<div id="add-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:400px; padding:10px;">
	<form id="add-form" method="post">
			<table cellpadding="8">
				<tr>
	                <td width="60" align="right">班级名称:</td>
	                <td><input type="text" name="clazzName" class="wu-text easyui-validatebox" data-options="required:true, missingMessage:'请填写班级名称'" style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">班级位置:</td>
	                <td><input type="text" name="clazzAddress" class="wu-text easyui-validatebox" data-options="required:true, missingMessage:'请填写班级位置'" style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">开班时间</td>
	                <td><input name="clazzStarttime"   class="easyui-datebox" type="text"  editable="fasle" data-options="required:true, missingMessage:'请输入开班日期'" style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">结课时间</td>
	                <td><input name="clazzEndtime"  class="easyui-datebox" type="text"  editable="fasle" data-options="required:true, missingMessage:'请输入结课日期'" style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">授课老师</td>
	                <td>
	                	<input name="teacherId"  class="easyui-combobox"  data-options="editable: false,valueField:'teacherId',textField:'teacherName',url:'${pageContext.request.contextPath}/admin/teacher/getTeacherNameList'" style="width: 200px;" />
	                </td>
	            </tr>
	            <tr>
	                <td width="60" align="right">备注:</td>
	                <td><input type="text" name="clazzNote" class="wu-text easyui-validatebox" placeholder="请输入备注" style="width: 200px;"/></td>
	            </tr>
			</table>
		</form>
	</div>


<!-- 修改窗口 -->
<div id="edit-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:400px; padding:10px;">
	<form id="edit-form" method="post">
        <input type="hidden" name="clazzId" id="edit-id">
       <table cellpadding="8">
				<tr>
	                <td width="60" align="right">班级名称:</td>
	                <td><input type="text" id="edit-clazzName" name="clazzName" class="wu-text easyui-validatebox" data-options="required:true, missingMessage:'请填写企业名称'" style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">班级地址:</td>
	                <td><input type="text" id="edit-clazzAddress" name="clazzAddress" class="wu-text easyui-validatebox" data-options="required:true, missingMessage:'请填写企业地址'" style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">开班时间:</td>
	                <td><input id="edit-clazzStarttime" name="clazzStarttime"  class="easyui-datebox" type="text"  editable="fasle" data-options="required:true, missingMessage:'请输入开班日期'" style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">结课时间:</td>
	                <td><input id="edit-clazzEndtime" name="clazzEndtime"  class="easyui-datebox" type="text"  editable="fasle" data-options="required:true, missingMessage:'请输入开班日期'" style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">授课老师</td>
	                <td>
	                	<input id="edit-teacherId" name="teacherId"  class="easyui-combobox"  data-options="editable: false,valueField:'teacherId',textField:'teacherName',url:'${pageContext.request.contextPath}/admin/teacher/getTeacherNameList'" style="width: 200px;" />
	                </td>
	            </tr>
	            
	            <tr>
	                <td width="60" align="right">备注:</td>
	                <td><input type="text" id="edit-clazzNote" name="clazzNote" class="wu-text easyui-validatebox" placeholder="请输入备注" style="width: 200px;"/></td>
	            </tr>
		</table>
    </form>
</div>


<!-- <div id="importExcel-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:450px; padding:10px;">
	<form method="post" enctype="multipart/form-data">
       		<input type="file" id="upfile" name="upfile" placeholder=""/>
         	<button onclick="importExcel();">导入</button>
	</form>
</div> -->

<div id="process-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-upload',title:'正在上传图片'" style="width:450px; padding:10px;">
<div id="p" class="easyui-progressbar" style="width:400px;" data-options="text:'正在上传中...'"></div>
</div>
<input type="file" id="photo-file" style="display:none;" onchange="upload()">
<%@include file="../common/footer.jsp"%>

<!-- End of easyui-dialog -->
<script type="text/javascript">
	/**
	*  添加记录
	*/
	function add(){
		var validate = $("#add-form").form("validate");
		if(!validate){
			$.messager.alert("消息提醒","请检查你输入的数据!","warning");
			return;
		}
		var data = $("#add-form").serialize();
		$.ajax({
			url:'add',
			dataType:'json',
			type:'post',
			data:data,
			success:function(data){
				if(data.type == 'success'){
					$.messager.alert('信息提示','添加成功！','info');
					$('#add-dialog').dialog('close');
					$('#data-datagrid').datagrid('reload');
				}else{
					$.messager.alert('信息提示',data.msg,'warning');
				}
			}
		});
	}
	
	/**
	* Name 修改记录
	*/
	function edit(){
		var validate = $("#edit-form").form("validate");
		if(!validate){
			$.messager.alert("消息提醒","请检查你输入的数据!","warning");
			return;
		}
		var data = $("#edit-form").serialize();
		$.ajax({
			url:'edit',
			dataType:'json',
			type:'post',
			data:data,
			success:function(data){
				if(data.type == 'success'){
					$.messager.alert('信息提示','修改成功！','info');
					$('#edit-dialog').dialog('close');
					$('#data-datagrid').datagrid('reload');
				}else{
					$.messager.alert('信息提示',data.msg,'warning');
				}
			}
		});
	}
	
	/**
	* 删除记录
	*/
	function remove(){
		var item = $('#data-datagrid').datagrid('getSelections');
		if(item == null || item.length == 0){
			$.messager.alert('信息提示','请选择要删除的数据！','info');
			return;
		}
		$.messager.confirm('信息提示','确定要删除该记录？', function(result){
			if(result){
				var ids = '';
				for(var i=0;i<item.length;i++){
					ids += item[i].clazzId + ',';
				}
				$.ajax({
					url:'delete',
					dataType:'json',
					type:'post',
					data:{ids:ids},
					success:function(data){
						if(data.type == 'success'){
							$.messager.alert('信息提示','删除成功！','info');
							$('#data-datagrid').datagrid('reload');
						}else{
							$.messager.alert('信息提示',data.msg,'warning');
						}
					}
				});
			}	
		});
	}
	
	/**
	* Name 打开添加窗口
	*/
	function openAdd(){
		//$('#add-form').form('clear');
		$('#add-dialog').dialog({
			closed: false,
			modal:true,
            title: "添加企业信息",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#add-dialog').dialog('close');                    
                }
            }],
            onBeforeOpen:function(){
            	//打开添加 窗口之前清空里面的数据
            	$("#add-form input").val('');
            }
        });
	}
	
	/**
	* 打开修改窗口
	*/
	function openEdit(){
		//$('#edit-form').form('clear');
		var item = $('#data-datagrid').datagrid('getSelections');
		if(item == null || item.length == 0){
			$.messager.alert('信息提示','请选择要修改的数据！','info');
			return;
		}
		if(item.length > 1){
			$.messager.alert('信息提示','请选择一条数据进行修改！','info');
			return;
		}
		item = item[0];
		$('#edit-dialog').dialog({
			closed: false,
			modal:true,
            title: "修改企业信息",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: edit
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#edit-dialog').dialog('close');                    
                }
            }],
            onBeforeOpen:function(){
            	$("#edit-id").val(item.clazzId);
            	$("#edit-clazzName").val(item.clazzName);
            	$("#edit-clazzAddress").val(item.clazzAddress);
            	$("#edit-clazzStarttime").datebox('setValue',item.clazzStarttime);
            	$("#edit-clazzEndtime").datebox('setValue',item.clazzEndtime);
            	$("#edit-clazzNote").val(item.clazzNote);
            	$("#edit-teacherId").combobox('setValue',item.teacherId);
            }
        });
	}	
	
	//搜索按钮监听
	$("#search-btn").click(function(){
		$('#data-datagrid').datagrid('load',{
			teacherId:$("#search-teacherName").combobox('getValue'),
			clazzName:$("#search-clazzName").combobox('getText')
  		});
	});
	
	/** 
	* 载入数据
	*/
	$('#data-datagrid').datagrid({
		url:'list',
		rownumbers:true,
		singleSelect:false,
		pageSize:20,           
		pagination:true,
		multiSort:true,
		fitColumns:true,
		idField:'clazzId',
	    treeField:'name',
		fit:true,
		columns:[[
			{ field:'chk',checkbox:true},
			{ field:'clazzId',title:'班级编号',width:70,sortable:true},
			{ field:'clazzName',title:'班级名称',width:200,sortable:true},
			{ field:'clazzAddress',title:'班级位置',width:250},
			{ field:'clazzStarttime',title:'开班时间',width:150},
			{ field:'clazzEndtime',title:'结课时间',width:150},
			{ field:'teacherId',title:'授课老师',width:100,
				formatter: function(value,row,index){
					var teacherList = $("#search-teacherName").combobox("getData");
					for(var i=0;i<teacherList.length;i++ ){
						if(row.teacherId == teacherList[i].teacherId)return teacherList[i].teacherName;
					}
				}
			},
			{ field:'clazzNote',title:'备注',width:300},
			{ field:'clazzStatus',title:'班级状态',width:100,sortable:true,
				formatter:function(value,row,index){
						if (value == 1) {
				            return '<font color="blue">授课中</font>';
				        }else {
				            return '<font color="gray">已结课</font>';
				        }
			        }
			}
		]],
		onLoadSuccess:function(data){  
			//$('.authority-edit').linkbutton({text:'编辑权限',plain:true,iconCls:'icon-edit'});  
		 }  
	});
	
	//打开Excel上传窗口
	function OepnImportExcel(){
		alert('未实现！！！');
	}
	
	/*
	导出Excel
	*/
	function exportExcel(){
		alert('未实现');
	}
</script>