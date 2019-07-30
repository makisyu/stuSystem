
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
        		<label>阶段名称:</label> 
	            <input id="search-projectName"  class="easyui-combobox"  editable= "false"  style="width:100px"/>
	            
	            &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
	            
       		    <label>主题名称:</label> 
	            <input id="search-titleName"  class="easyui-combobox"  editable="fasle" data-options="valueField:'courseId',textField:'courseName',url:'${pageContext.request.contextPath}/admin/course/getCourseTitle?projectId=1'" style="width:100px"/>
	           
	            &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
	            <a href="#" id="search-btn" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
		</div>
    </div>
    <!-- End of toolbar -->
     <table id="data-datagrid" class="easyui-datagrid" toolbar="#wu-toolbar">
    </table> 

    
    
</div>

<!-- Begin of easyui-dialog -->
<!-- 添加窗口 -->
<div id="add-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:600px; padding:10px;">
	<form id="add-form" method="post">
			<table cellpadding="8">
			
			 <!--选择阶段-->
				<tr>
	                <td width="60" align="right">阶段名称:</td>
	                <td>
	                	<input id="choose-project"   class="easyui-combobox"  editable= "false" data-options="valueField:'courseId',textField:'courseName',url:'${pageContext.request.contextPath}/admin/course/getCourseLevel'" style="width: 200px;" />
	                </td>
	                <td width="60"><a href="#" class="easyui-linkbutton"  iconCls="icon-add" plain="true" id="changeLevButton"  >添加</a> </td>
	                <!-- <td width="60" align="right"><button id="changeLevButton"  type="button">+</button></td> -->
	            </tr>
	            
	          <!--添加阶段 -->
	          <div >
         		<tr style="display:none;" id="hideLevtr">
         		
	                <td width="60" align="right">请输入:</td>
	                <td width="60">
	                	<input id="levelName" name="levelName" type="text" class="wu-text" style="width:100px"/>
	                	<button type="button" id="add-level" >确定</button>
	                </td> 
	                <!--  <td width="60" align="right"><button type="button" id="add-level" >确定</button></td>  -->
	            </tr>
	            </div>
	           <!--选择课程主题-->  
				<tr>
	                <td width="60" align="right">课程主题:</td>
	                <td><input id="choose-title" type="text" editable= "false" class="easyui-combobox" data-options="valueField:'courseId',textField:'courseName'" style="width: 200px;"/></td>
	                <td width="60"><a href="#" class="easyui-linkbutton"  iconCls="icon-add" plain="true" id="changeTilButton"  >添加</a></td>
	            </tr>
	            
	            <!--添加课程主题 -->
         		<tr style="display:none;" id="hideTiltr">
         		
	                <td width="60" align="right">请输入:</td>
	                <td>
	                	<input id="titleName" name="titleName"  class="wu-text" style="width:100px"/>
	                	<button type="button" id="add-title" >确定</button>
	                </td> 
	                <!-- <td width="60" align="right"><button type="button" id="add-title" >确定</button></td> -->
	            </tr>
	            <!--选择课程名称-->
	            <tr>
	                <td width="60" align="right">课程名称:</td>
	                <td><input id="choose-name" type="text" editable= "false"  class="easyui-combobox" data-options="valueField:'courseId',textField:'courseName'" style="width: 200px;"/></td>
	                <td width="60" ><a href="#" class="easyui-linkbutton"  iconCls="icon-add" plain="true" id="changeNamButton"  >添加</a></td>
	            </tr>
	            
	           <!--添加课程名称 -->
         		<tr style="display:none;" id="hideNamtr">
         		
	                <td width="60" align="right">请输入:</td>
	                <td>
	                	<input id="couName" name="couName"  class="wu-text" style="width:100px"/>
	                	<button type="button" id="add-couName" >确定</button>
	                </td> 
	                <!-- <td width="60" ><button type="button" id="add-couName" >确定</button></td> -->
	            </tr>
	            
	        
	       
	            <!--添加课程内容 -->
         		<tr>
         		
	                <td width="60" align="right">课程内容:</td>
	                <td>
	                	<input id="courseContent" name="courseContent"  class="wu-text" style="width: 190px;"/>
	                </td> 
	               
	            </tr>
	            
	            
	            <tr>
	                <td width="60" align="right">课程时间</td>
	                <td><input id="add-time" name="time"  class="wu-text" type="text"  editable="fasle" data-options="required:true" style="width: 190px;"/></td>
	            </tr>

			</table>
		</form>
	</div>


<!-- 修改窗口 -->
<div id="edit-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:400px; padding:10px;">
	<form id="edit-form" method="post">
	<input id="edit-courseId" name="courseId" type="hidden"/>
        <!-- <input type="hidden" name="clazzId" id="edit-id"> -->
        <table cellpadding="8">
			<tr>
	                <td width="60" align="right">阶段名称:</td>
	                <td><input type="text" id="edit-level" name="levelName" class="wu-text " data-options="required:true" style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">主题名称:</td>
	                <td><input type="text" id="edit-title" name="titleName" class="wu-text " data-options="required:true" style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">课程名称:</td>
	                <td><input id="edit-name" name="couName"  class="wu-text " type="text"  data-options="required:true" style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">课程内容:</td>
	                <td><input id="edit-content" name="courseContent"  class="wu-text " type="text"   data-options="required:true" style="width: 200px;"/></td>
	            </tr>
	            <tr>
	                <td width="60" align="right">课程时间</td>
	                <td>
	                	<input id="edit-time" name="courseDate"  class="wu-text "   style="width: 200px;" />
	                </td>
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
/*
 * 二级联动
 */
$('#search-projectName').combobox({
    url:'${pageContext.request.contextPath}/admin/course/getCourseLevel',
    valueField:'courseId',
    textField:'courseName',
    onSelect: function(){
    	var projectId = $("#search-projectName").combobox("getValue");
    	$("#search-titleName").combobox("clear");
        var url = '${pageContext.request.contextPath}/admin/course/getCourseTitle?projectId='+projectId;
        $('#search-titleName').combobox('reload', url); 
        
        }
});


//添加页面下拉框

$('#choose-project').combobox({
   
    onSelect: function(){
    	var projectId = $("#choose-project").combobox("getValue");
    	$("#choose-title").combobox("clear");
    	$("#choose-name").combobox("clear");
    	$("#choose-content").combobox("clear");
        var url = '${pageContext.request.contextPath}/admin/course/getCourseTitle?projectId='+projectId;
        $('#choose-title').combobox('reload', url);
        $("#choose-title").combobox('enable');
        $("#changeTilButton").removeAttr("disabled",true).css("pointer-events","auto");  
		$("#choose-name").combobox('disable');
		$("#courseContent").attr("disabled","disabled");
		$("#add-time").attr("disabled","disabled");
		$("#changeNamButton").attr("disabled",true).css("pointer-events","none");
        }
});

$('#choose-title').combobox({
	   
    onSelect: function(){
    	var projectId = $("#choose-title").combobox("getValue");
    	$("#choose-name").combobox("clear");
    	$("#choose-content").combobox("clear");
        var url = '${pageContext.request.contextPath}/admin/course/getCourseTitle?projectId='+projectId;
        $('#choose-name').combobox('reload', url); 
		$("#choose-name").combobox('enable');
		$("#changeNamButton").removeAttr("disabled",true).css("pointer-events","auto");	
		$("#courseContent").attr("disabled","disabled");
		$("#add-time").attr("disabled","disabled");
        }
});

$('#choose-name').combobox({
    onSelect: function(){
    	var projectId = $("#choose-name").combobox("getValue");
    	$("#choose-content").combobox("clear");
        var url = '${pageContext.request.contextPath}/admin/course/getCourseTitle?projectId='+projectId;
        $('#choose-content').combobox('reload', url); 
		$("#courseContent").removeAttr("disabled");
		$("#add-time").removeAttr("disabled");
        }
});
   /**
    *  添加页面显示相关
   */

   /* 显示+隐藏按钮 */
   
    //阶段
    $("#changeLevButton").click(function(){
    	$("#hideLevtr").toggle();
    	/* $("#hideLevtr").css("display","table-row"); */
    })
	//主题
	$("#changeTilButton").click(function(){
    	$("#hideTiltr").toggle();
    })
	
	//名称
   $("#changeNamButton").click(function(){
    	$("#hideNamtr").toggle();
    })
   
    //添加阶段确定
   $("#add-level").click(function(){
	   var id=0;
	   var time=0;
	   var name=$("#levelName").val();
	   $.ajax({
			url:'add',
			dataType:'json',
			type:'post',
			data: { // 提交数据
	                "id": id,// 前者为字段名，后者为数据
	                "time":time,
	                "name":name
	            },
			success:function(data){
				if(data.type == 'success'){
					$.messager.alert('信息提示','添加成功！','info');
					$('#data-datagrid').datagrid('reload');
					
					$("#choose-project").combobox({ 
					    editable : false,
					    url:'${pageContext.request.contextPath}/admin/course/getCourseLevel',
					    valueField : 'courseId',
					    textField : 'courseName',
					    onLoadSuccess : function(){
					    	var selData = $('#choose-project').combobox('getData');
					        $('#choose-project').combobox('select',selData[selData.length-1].courseId);
					    }	 
					})
					$("#hideLevtr").css("display","none");
					$("#levelName").val('');
				}else{
					$.messager.alert('信息提示',data.msg,'warning');
				}
			}
		});
   })

   //添加主题确定按钮
   $("#add-title").click(function(){
	   var id= $("#choose-project").combobox('getValue');
	   var time=0;
	   var name=$("#titleName").val();
	   $.ajax({
			url:'add',
			dataType:'json',
			type:'post',
			data: { // 提交数据
	                "id": id,// 前者为字段名，后者为数据
	                "time":time,
	                "name":name
	            },
			
	            success:function(data){
					if(data.type == 'success'){
					var projectId = $("#choose-project").combobox("getValue");
				     var url1 ='${pageContext.request.contextPath}/admin/course/getCourseTitle?projectId='+projectId;
						$.messager.alert('信息提示','添加成功！','info');
						$('#data-datagrid').datagrid('reload');
						
						$("#choose-title").combobox({ 
						    editable : false,
						    url:url1,
						    valueField : 'courseId',
						    textField : 'courseName',
						    onLoadSuccess : function(){
						    	var selData = $('#choose-title').combobox('getData');
						        $('#choose-title').combobox('select',selData[selData.length-1].courseId);
						    }	 
						})
						$("#hideTiltr").css("display","none");
						$("#titleName").val('');
					}else{
						$.messager.alert('信息提示',data.msg,'warning');
					}
				}
	            
		});
   })
   
   //添加课程名称确定按钮
   $("#add-couName").click(function(){
	   var id= $("#choose-title").combobox('getValue');
	   var time=0;
	   var name=$("#couName").val();
	   $.ajax({
			url:'add',
			dataType:'json',
			type:'post',
			data: { // 提交数据
	                "id": id,// 前者为字段名，后者为数据
	                "time":time,
	                "name":name
	            },
	            success:function(data){
					if(data.type == 'success'){
						var projectId = $("#choose-title").combobox("getValue");
						var url = '${pageContext.request.contextPath}/admin/course/getCourseTitle?projectId='+projectId;
						$.messager.alert('信息提示','添加成功！','info');
						$('#data-datagrid').datagrid('reload');
						
						$("#choose-name").combobox({ 
						    editable : false,
						    valueField : 'courseId',
						    textField : 'courseName',
						    onLoadSuccess : function(){
						    	var selData = $('#choose-name').combobox('getData');
						        $('#choose-name').combobox('select',selData[selData.length-1].courseId);
						    }	 
						})
						$("#hideNamtr").css("display","none");
						$("#couName").val('');
					}else{
						$.messager.alert('信息提示',data.msg,'warning');
					}
				}
		});
   })
	  	  

	/**
	*  添加记录
	*/
	 function add(){
		var validate = $("#add-form").form("validate");
		if(!validate){
			$.messager.alert("消息提醒","请检查你输入的数据!","warning");
			return;
		}
		   var id= $("#choose-name").combobox('getValue');
		   var time=$("#add-time").val();;
		   var name=$("#courseContent").val();
		$.ajax({
			url:'add',
			dataType:'json',
			type:'post',
			data: { // 提交数据
                "id": id,// 前者为字段名，后者为数据
                "time":time,
                "name":name
            },
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
					ids += item[i].courseId + ',';
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
		$("#choose-title").combobox('disable');
		$("#choose-name").combobox('disable');
		$("#courseContent").attr("disabled","disabled");
		$("#add-time").attr("disabled","disabled");
		$("#changeTilButton").attr("disabled",true).css("pointer-events","none");
		$("#changeNamButton").attr("disabled",true).css("pointer-events","none");
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
            title: "修改课程信息",
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
            	$("#edit-level").val(item.levelName);
            	$("#edit-title").val(item.titleName);
            	$("#edit-name").val(item.couName);
            	$("#edit-content").val(item.courseContent);
            	$("#edit-time").val(item.courseDate);
            	$("#edit-courseId").val(item.courseId);
            }
        });
	}	
	
	//搜索按钮监听
	$("#search-btn").click(function(){
		$('#data-datagrid').datagrid('load',{
			projectId:$("#search-projectName").combobox('getValue'),
			titleId:$("#search-titleName").combobox('getValue')
  		});
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
	/* 	idField:'courseId',
	    treeField:'name', */
		fit:true,
		columns:[
			[
				{title:'阶段',colspan:4},
			],
			
			[
			{ field:'chk',checkbox:true},
		/* 	{ field:'levelName',title:'阶段名称',width:70,sortable:true}, */
		   /*  { field:'titleName',title:'主题名称',width:200,sortable:true}, */
			{ field:'couName',title:'课程名称',width:250},
			{ field:'courseContent',title:'课程内容',width:150},
			
	     	]
			],
		onLoadSuccess:function(data){ 
	
			 if($("#search-projectName").combobox('getValue') == "" && $("#search-titleName").combobox('getValue') == ""){
			$("#search-projectName").combobox('select',1);
			$("#search-titleName").combobox('select',5);
			}  
			               var mark2=1;
			               var mark3 =1;
			               for (var i=1; i <data.rows.length; i++) {
			         
			 
			                 	/* if (data.rows[i]['titleName'] == data.rows[i-1]['titleName']) {
				                 		mark2 += 1; 
				                 		$(this).datagrid('mergeCells',{ 
				                 			index: i+1-mark2,    
				                 			field: 'titleName',  //需要合并的列
				                 			rowspan:mark2     //纵向合并的格数，如果想要横向合并，就使用colspan：mark
				                 			
				                 		});
				                 		 $(this).datagrid('mergeCells',{ 
				                 			index: i+1-mark2,    
				                 			field: 'levelName',  
				                 			rowspan:mark2    
				                 			
				                 		});
				            
				                 	}else{
				                 		mark2=1;     //一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
				                 	}  */
				 
			                    if (data.rows[i]['couName'] == data.rows[i-1]['couName']) {
				                 		mark3 += 1; 
				                 		$(this).datagrid('mergeCells',{ 
				                 			index: i+1-mark3,    
				                 			field: 'couName',  //需要合并的列
				                 			rowspan:mark3     //纵向合并的格数，如果想要横向合并，就使用colspan：mark
				                 			
				                 		});
				                 		 $(this).datagrid('mergeCells',{ 
				                 			index: i+1-mark3,    
				                 			field: 'couName',  
				                 			rowspan:mark3    
				                 			
				                 		});
				            
				                 	}else{
				                 		mark3=1;     //一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
				                 	}
			 
			    }//for括号
		    }//data括号
    	}); 
</script>