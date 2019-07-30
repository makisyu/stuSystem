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
        		<span style="display: none">
        			<label>学生姓名:</label> 
		            <input id="search-stuName"  class="easyui-combobox"  data-options="editable: false,valueField:'stuId',textField:'stuName',url:'${pageContext.request.contextPath}/admin/student/getStudentNameList'" style="width:100px" />
		            &nbsp;&nbsp;
        		</span>
	            
	            <label>学生姓名:</label> 
	            <input  id="search-studentName" name="studentName" class="wu-text" style="width:100px">
	            
	            &nbsp;&nbsp;
	            
	            <label>企业名称:</label> 
	            <input id="search-companyName"  class="easyui-combobox"  data-options="editable: false,valueField:'companyId',textField:'companyName',url:'${pageContext.request.contextPath}/admin/company/getCompanyNameList'" style="width: 150px;">
	             &nbsp;&nbsp;
	            
	            <label>班级名称:</label> 
	            <input id="search-clazzName"  class="easyui-combobox"  data-options="editable: false,valueField:'clazzId',textField:'clazzName',url:'${pageContext.request.contextPath}/admin/clazz/getClazzNameList'" style="width:100px" />
	            &nbsp;&nbsp;
	            
	            <label>按时间搜索</label> 
	            <input type="text" id="search-startDate" name="startDate" class="easyui-datebox" editable="fasle" style="width: 100px;"/>
	            
	            <label>至</label> 
	            <input type="text" id="search-endDate" name="endtDate" class="easyui-datebox" editable="fasle" style="width: 100px;"/>
	             &nbsp;&nbsp;
	            
	            <a href="#" id="search-btn" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
	            <a href="#" id="clear_search-btn" class="easyui-linkbutton" iconCls="icon-search">清空搜索</a>
		</div>
    </div>
    <!-- End of toolbar -->
    <table id="data-datagrid" class="easyui-datagrid" toolbar="#wu-toolbar"></table>
</div>
<!-- Begin of easyui-dialog -->
<!-- 修改窗口 -->
<div id="edit-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:360px; height:435px; padding:10px;">
	<div id="fs1">
		<table width="100%" style="border-collapse:separate; border-spacing:0px 15px;">
				<tr align="center">
					<td>学生姓名：<label id="show_stuName"></label></td>
					<td>出勤时间：<label id="show_adate"></label></td>
				</tr>
		</table>
	</div>
	
	<div id="fs2">
		全选/全不选：<input type="checkbox" checked="checked" id="allCheck" />
		<form id="edit-form" method="post">
		
			<input id="aId" type="hidden" name="aId">
			<input id="stuId" type="hidden" name="stuId">
			<input id="aDate" type="hidden" name="aDate">
			<input id="companyId" type="hidden" name="companyId">
			<input id="clazzId" type="hidden" name="clazzId">
		
			<table width="100%" align="center" style="border-collapse:separate; border-spacing:0px 10px;">
				<tr>
					<td colspan="4">
						缺勤原因：
						<input class="easyui-combobox" id="aType" name="aType" editable="fasle"
						data-options="required:true, missingMessage:'请选择缺勤原因',valueField:'lable',textField:'value',data:[{lable:'0',value:'出勤'},{lable:'1',value:'迟到'},{lable:'2',value:'旷课'},{lable:'3',value:'早退'},{lable:'4',value:'病假'},{lable:'5',value:'事假'}]" style="width: 170px;"/>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;1</td>
					<td>&nbsp;&nbsp;2</td>
					<td>&nbsp;&nbsp;3</td>
					<td>&nbsp;&nbsp;4</td>
				</tr>
				<tr>
					<td>
						 <input type="checkbox" id="a1" value="O" name="a1" />
					</td>
					<td> 
						<input type="checkbox" id="a2"  value="O" name="a2" />
					</td>
					<td>
						<input type="checkbox" id="a3" value="O" name="a3" />
					</td>
					<td>
						 <input type="checkbox" id="a4" value="O" name="a4" />
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;5</td>
					<td>&nbsp;&nbsp;6</td>
					<td>&nbsp;&nbsp;7</td>
					<td>&nbsp;&nbsp;8</td>
				</tr>
				<tr>
					<td>
						 <input type="checkbox" id="a5" value="O" name="a5" />
					</td>
					<td> 
						<input type="checkbox" id="a6" value="O" name="a6" />
					</td>
					<td>
						<input type="checkbox" id="a7" value="O" name="a7" />
					</td>
					<td>
						 <input type="checkbox" id="a8" value="O" name="a8" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>

<%@include file="../common/footer.jsp"%>

<!-- End of easyui-dialog -->
<script type="text/javascript">
	$(function(){
		//点击全选或全不选
	    $("#allCheck").click(function(){
	    	if($('#allCheck').attr('checked')){
				// 选中所有
	    		 $("#edit-form input[type=checkbox]").prop("checked", true);
	    	}else{
	    		 // 取消选中所有
	    		$("#edit-form input[type=checkbox]").prop("checked", false);
	    	}
	    });
	    
	    
		$("#fs1").lqfieldset({
			title:'个人信息',
			collapsible:true,
			collapsed:false,
			checkboxToggle:false
		});
		$("#fs2").lqfieldset({
			title:'考勤信息',
			collapsible:true,
			collapsed:false,
			checkboxToggle:false
		});
	});
	

	/**
	*  修改记录
	*/
	function update(){
		var validate = $("#edit-form").form("validate");
		if(!validate){
			$.messager.alert("消息提醒","请检查你输入的数据!","warning");
			return;
		}
		
		$("#edit-form input[type=checkbox]").find(":checkbox").each(function () {
			   if($(this).is(':checked')){
			    	$(this).val("O");
			   }else{
			    	$(this).val("X");
			   }
		});
		
		var data = $("#edit-form").serialize();
		$.ajax({
			url:'update',
			dataType:'json',
			type:'post',
			data:data,
			success:function(data){
				if(data.type == 'success'){
					$.messager.alert('信息提示','添加成功！','info');
					$('#edit-dialog').dialog('close');
					$('#data-datagrid').datagrid('reload');
				}else{
					$.messager.alert('信息提示',data.msg,'warning');
				}
			}
		});
	}
	
	/**
	* Name 打开修改窗口
	*/
	
	function openEdit(){
		//$('#edit-form').form('clear');
		var item = $('#data-datagrid').datagrid('getSelections');
		
		if(item == null || item.length == 0){
			$.messager.alert('信息提示','请选择要修改的数据！','info');
			return;
		}
		if(item.length > 1){
			$.messager.alert('信息提示','请选择一条数据！','info');
			return;
		}
		item = item[0];
		
		///////////////////////显示考勤状态开始////////////////////////
		
		if(item.a1 == 'O'){
			$("#a1").prop("checked",true); 
		}else{
			$("#a1").prop("checked",false); 
		}
		
		if(item.a2 == 'O'){
			$("#a2").prop("checked",true); 
		}else{
			$("#a2").prop("checked",false); 
		}
		if(item.a3 == 'O'){
			$("#a3").prop("checked",true); 
		}else{
			$("#a3").prop("checked",false); 
		}
		if(item.a4 == 'O'){
			$("#a4").prop("checked",true); 
		}else{
			$("#a4").prop("checked",false); 
		}
		if(item.a5 == 'O'){
			$("#a5").prop("checked",true); 
		}else{
			$("#a5").prop("checked",false); 
		}
		if(item.a6 == 'O'){
			$("#a6").prop("checked",true); 
		}else{
			$("#a6").prop("checked",false); 
		}
		if(item.a7 == 'O'){
			$("#a7").prop("checked",true); 
		}else{
			$("#a7").prop("checked",false); 
		}
		if(item.a8 == 'O'){
			$("#a8").prop("checked",true); 
		}else{
			$("#a8").prop("checked",false); 
		}
		
		///////////////////////显示考勤状态结束////////////////////////
		$('#aType').combobox('setValue',item.aType);
		
		var stuList = $("#search-stuName").combobox("getData");
		
		for(var i=0;i<stuList.length;i++ ){
			if(item.stuId == stuList[i].stuId){
				$("#show_stuName").html(stuList[i].stuName);
				$("#show_adate").html(item.aDate);
				break;
			}
		}
		
		
		$('#edit-dialog').dialog({
			closed: false,
			modal:true,
            title: "添加考勤信息",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: update
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#edit-dialog').dialog('close');                    
                }
            }],
            onBeforeOpen:function(){
            	//打开添加 窗口之前给隐藏域赋值
            	//默认全选
				//$("#edit-form input[type=checkbox]").prop("checked", true);
            	$("#show_stuId").val(item.stuId);
            	$("#show_aDate").val(item.aDate);
            	$("#aId").val(item.aId);
            	
            	$("#stuId").val(item.stuId);
            	$("#aDate").val(item.aDate);
            	$("#companyId").val(item.companyId);
            	$("#clazzId").val(item.clazzId);
            	
            	/**
            	遍历所有的复选框
            	**/
            	$("#edit-form input[type=checkbox]").find(":checkbox").each(function () {
						/* 
						if($(this).is(':checked')){
	     			    	$(this).val("1");
	     			   }else{
	     			    	$(this).val("2");
	     			   } */
	     		});
            }
        });
	}
	
	//搜索按钮监听
	$("#search-btn").click(function(){
		var stuList = $("#search-stuName").combobox("getData");
		var stuIdValue =-1;
		if($("#search-studentName").val().length>0){
			//不为空
			stuIdValue = -2;
		}
		for(var i=0;i<stuList.length;i++ ){
			if(stuList[i].stuName == $("#search-studentName").val()){
				stuIdValue = stuList[i].stuId;
				break;
			}
		}
		
		//$("#studentList").combobox('clear');
		
		$('#data-datagrid').datagrid('load',{
			stuId:stuIdValue,
			companyId:$("#search-companyName").combobox('getValue'),
			clazzId:$("#search-clazzName").combobox('getValue'),
			startDate:$("#search-startDate").datebox('getValue'),
			endDate:$("#search-endDate").datebox('getValue')
  		});
	});
	//“清空”搜索按钮监听
	$("#clear_search-btn").click(function(){
		$("#search-studentName").val('');
		$("#search-companyName").combobox('clear');
		$("#search-clazzName").combobox('clear');
		$("#search-startDate").datebox('clear');
		$("#search-endDate").datebox('clear');
		
		$('#data-datagrid').datagrid('load',{
			stuId:null,
			companyId:$("#search-companyName").combobox('getValue'),
			clazzId:$("#search-clazzName").combobox('getValue'),
			startDate:$("#search-startDate").datebox('getValue'),
			endDate:$("#search-endDate").datebox('getValue')
  		});
	});
	
	/** 
	* 载入数据
	*/
	$('#data-datagrid').datagrid({
		url:'list',
		rownumbers:true,
		nowrap:false, 
		singleSelect:false,
		multiSort:true,
		fitColumns:true,
		idField:'aId',
	    treeField:'name',
		fit:true,
		/* frozenColumns: [[    
            { title: '区域名称', field: 'stuId', width: 80, sortable: true,"colspan":12}    
        ]], */
		columns:[
			[	 {"title":"出勤状况","colspan":15}],
		    [
			{ field:'chk',checkbox:true},
			{ field:'aId',title:'考勤编号',width:70,sortable:true,align:'center',halign:'center'},
			{ field:'stuId',title:'学生姓名',width:70,sortable:true,align:'center',halign:'center',
				formatter: function(value,row,index){
					var stuList = $("#search-stuName").combobox("getData");
					for(var i=0;i<stuList.length;i++ ){
						if(row.stuId == stuList[i].stuId)return stuList[i].stuName;
					}
				}
			},
			{ field:'aDate',title:'出勤时间',width:70,sortable:true,align:'center',halign:'center'},
			{ field:'a1',title:'1',width:50,sortable:true,align:'center',halign:'center'},
			{ field:'a2',title:'2',width:50,sortable:true,align:'center',halign:'center'},
			{ field:'a3',title:'3',width:50,sortable:true,align:'center',halign:'center'},
			{ field:'a4',title:'4',width:50,sortable:true,align:'center',halign:'center'},
			{ field:'a5',title:'5',width:50,sortable:true,align:'center',halign:'center'},
			{ field:'a6',title:'6',width:50,sortable:true,align:'center',halign:'center'},
			{ field:'a7',title:'7',width:50,sortable:true,align:'center',halign:'center'},
			{ field:'a8',title:'8',width:50,sortable:true,align:'center',halign:'center'},
			{ field:'companyId',title:'所属企业',width:150,sortable:true,align:'center',halign:'center',
				formatter: function(value,row,index){
					var companyList = $("#search-companyName").combobox("getData");
					for(var i=0;i<companyList.length;i++ ){
						if(row.companyId == companyList[i].companyId)return companyList[i].companyName;
					}
				}
			},
		 	{ field:'clazzId',title:'所属班级',width:70,sortable:true,
				formatter: function(value,row,index){
					var clazzList = $("#search-clazzName").combobox("getData");
					for(var i=0;i<clazzList.length;i++ ){
						if(row.clazzId == clazzList[i].clazzId)return clazzList[i].clazzName;
					}
				}
			},
			{ field:'signature',title:'学生签字',width:70,sortable:true,align:'center',halign:'center'},
		]],onDblClickCell: function (rowIndex, field, value) {
			alert(rowIndex+","+field+","+value);
		}
	});
	//onDblClickCell 双击
	/*
	行合并：
	tableID:表格的ID
	colList：需要合并的列，如果有多个，可以以,分开
	*/
	function mergeCellsByField(tableID, colList) {
	    var ColArray = colList.split(",");
	    var tTable = $("#" + tableID);
	    var TableRowCnts = tTable.datagrid("getRows").length;
	    var tmpA;
	    var tmpB;
	    var PerTxt = "";
	    var CurTxt = "";
	    var alertStr = "";
	    for (j = ColArray.length - 1; j >= 0; j--) {
	        PerTxt = "";
	        tmpA = 1;
	        tmpB = 0;
	 
	        for (i = 0; i <= TableRowCnts; i++) {
	            if (i == TableRowCnts) {
	                CurTxt = "";
	            }
	            else {
	                CurTxt = tTable.datagrid("getRows")[i][ColArray[j]];
	            }
	            if (PerTxt == CurTxt) {
	                tmpA += 1;
	            }
	            else {
	                tmpB += tmpA;
	 
	                tTable.datagrid("mergeCells", {
	                    index: i - tmpA,
	                    field: ColArray[j],//合并字段
	                    rowspan: tmpA,
	                    colspan: null
	                });
	                tTable.datagrid("mergeCells", { //根据ColArray[j]进行合并
	                    index: i - tmpA,
	                    field: "Ideparture",
	                    rowspan: tmpA,
	                    colspan: null
	                });
	 
	                tmpA = 1;
	            }
	            PerTxt = CurTxt;
	        }
	    }
	}
	
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