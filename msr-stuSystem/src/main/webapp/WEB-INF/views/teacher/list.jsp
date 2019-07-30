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
	                <td width="60" align="right">姓&nbsp;&nbsp;&nbsp;&nbsp;名</td>
	                <td><input type="text" name="teacherName" class="wu-text easyui-validatebox" style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
	                <td>
			            <input class="easyui-combobox" name="teacherSex" editable="fasle"
			            data-options="valueField:'lable',textField:'value',data:[{lable:'1',value:'男'},{lable:'2',value:'女'}]" style="width: 210px;"/></td>
	                </td>  
	                
	            </tr>
	            <tr>
	                <td width="60" align="right">出生日期</td>
	                <td><input name="teacherBirthday"   class="easyui-datebox" type="text"  editable="fasle" style="width: 210px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">电话号码</td>
	                <td><input type="text" name="teacherTel" class="wu-text easyui-validatebox"  style="width: 200px;" validType="number"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">家庭住址</td>
	                <td><input type="text" name="teacherAddress" class="wu-text easyui-validatebox"  style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">入职时间</td>
	                <td><input name="hiredate"  class="easyui-datebox" type="text"  editable="fasle"  style="width: 210px;"/></td>
	            </tr>
	             <tr>
	                <td width="60" align="right">授课班级</td>
	                <td>
	                	<input name="clazzId"  class="easyui-combobox"  data-options="editable: false,valueField:'clazzId',textField:'clazzName',url:'${pageContext.request.contextPath}/admin/clazz/getClazzNameList'" style="width: 210px;" />
	                </td>
	            </tr>
	            <tr>
	                <td width="60" align="right">备&nbsp;&nbsp;&nbsp;&nbsp;注</td>
	                <td><input type="text" name="teacherNote" class="wu-text easyui-validatebox" placeholder="请输入备注" style="width: 200px;"/></td>
	            </tr>
			</table>
		</form>
	</div>


<!-- 修改窗口 -->
<div id="edit-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:650px; padding:10px;">
	<form id="edit-form" method="post">
        <input type="hidden" name="teacherId" id="edit-id">
       <table cellpadding="8">
				<tr>
	                <td width="60" align="right">姓&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
	                <td><input type="text" id="edit-teacherName"  name="teacherName" class="wu-text easyui-validatebox"  style="width: 200px;"/></td>
	                <td width="60" align="right">性&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
	                <td>
			            <input class="easyui-combobox" id="edit-teacherSex" name="teacherSex" editable="fasle"
			            data-options="valueField:'lable',textField:'value',data:[{lable:'1',value:'男'},{lable:'2',value:'女'}]" style="width: 210px;"/>
	                </td>
	            </tr>
	            <tr>
	                <td width="60" align="right">出生生日:</td>
	                <td><input id="edit-teacherBirthday" name="teacherBirthday"  class="easyui-datebox" type="text"  editable="fasle"  style="width: 210px;"/></td>
	                 <td width="60" align="right">家庭住址:</td>
	                <td><input id="edit-teacherAddress" name="teacherAddress"  class="wu-text easyui-validatebox" type="text"  editable="fasle"  style="width: 200px;"/></td>
	            </tr>
	             <tr>
	                <td width="60" align="right">电话号码:</td>
	                <td><input id="edit-teacherTel" name="teacherTel"  class="wu-text easyui-validatebox" type="text"  editable="fasle" style="width: 200px;" validType="number"/></td>
	                <td width="60" align="right">授课班级:</td>
	                <td>
	                	<input id="edit-clazzId" name="clazzId"  class="easyui-combobox"  data-options="editable: false,valueField:'clazzId',textField:'clazzName',url:'${pageContext.request.contextPath}/admin/clazz/getClazzNameList'" style="width: 210px;" />
	                </td>
	            </tr>
	            <tr>
	                <td width="60" align="right">离职日期:</td>
	                <td><input type="text" id="edit-leavedate" name="leavedate" class="easyui-datebox" editable="fasle"  style="width: 210px;"/></td>
	                <td width="60" align="right">入职日期:</td>
	                <td>
	                	<input id="edit-hiredate" name="hiredate"  class="easyui-datebox"  data-options="editable: false,valueField:'teacherId',textField:'teacherName',url:'${pageContext.request.contextPath}/admin/teacher/getTeacherNameList'" style="width: 210px;" />
	                </td>
	            </tr>
	            <tr>
	                <td width="60" align="right">是否在职:</td>
	                <td>
			            <input class="easyui-combobox" editable="fasle" id="edit-teacherStatus" name="teacherStatus" 
			            data-options="valueField:'lable',textField:'value',data:[{lable:'1',value:'在职'},{lable:'2',value:'离职'}]" style="width: 210px;"/>
	                </td>
	                <td width="60" align="right">备注:</td>
	                <td><input id="edit-teacherNote" name="teacherNote"  class="wu-text easyui-validatebox" type="text"  editable="fasle" style="width: 200px;"/></td>
	            </tr>
			</table>
    </form>
</div>

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
					ids += item[i].teacherId + ',';
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
            title: "添加老师信息",
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
		//alert(item.length);
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
            title: "修改老师信息",
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
            	$("#edit-id").val(item.teacherId);
            	$("#edit-teacherName").val(item.teacherName);
            	$("#edit-teacherSex").combobox('setValue',item.teacherSex);
            	
            	$("#edit-teacherBirthday").datebox('setValue',item.teacherBirthday);
            	$("#edit-teacherAddress").val(item.teacherAddress);
            	$("#edit-hiredate").datebox('setValue',item.hiredate);
            	$("#edit-leavedate").datebox('setValue',item.leavedate);
            	$("#edit-clazzId").combobox('setValue',item.clazzId);
            	
            	$("#edit-teacherStatus").combobox('setValue',item.teacherStatus);
            	
            	$("#edit-teacherTel").val(item.teacherTel);
            	$("#edit-teacherNote").val(item.teacherNote);
            }
        });
	}	
	
	//搜索按钮监听
	$("#search-btn").click(function(){
		$('#data-datagrid').datagrid('load',{
			teacherName:$("#search-teacherName").combobox('getText'),
			clazzId:$("#search-clazzName").combobox('getValue')
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
		idField:'teacherId',
	    treeField:'name',
		fit:true,
		columns:[[
			{ field:'chk',checkbox:true},
			{ field:'teacherId',title:'编号',width:50,sortable:true},
			{ field:'teacherName',title:'姓名',width:50,sortable:true},
			{ field:'teacherSex',title:'性别',width:50,
				formatter:function(value,row,index){
					if (value == 1) {
			            return '男';
			        }else {
			            return '女';
			        }
		        }
			},
			{ field:'teacherBirthday',title:'生日',width:100,sortable:true},
			{ field:'teacherTel',title:'电话',width:100,sortable:true},
			{ field:'teacherAddress',title:'住址',width:200,sortable:true},
			{ field:'hiredate',title:'入职日期',width:100,sortable:true},
			{ field:'leavedate',title:'离职日期',width:100,sortable:true},
			{ field:'clazzId',title:'授课班级',width:100,sortable:true,
				formatter: function(value,row,index){
					var clazzList = $("#search-clazzName").combobox("getData");
					for(var i=0;i<clazzList.length;i++ ){
						if(row.clazzId == clazzList[i].clazzId)return clazzList[i].clazzName;
					}
				}
			},
			{ field:'teacherStatus',title:'状态',width:100,
				formatter:function(value,row,index){
					if (value == 1) {
			            return '<font color="blue">在职</font>';
			        }else {
			            return '<font color="gray">离职</font>';
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