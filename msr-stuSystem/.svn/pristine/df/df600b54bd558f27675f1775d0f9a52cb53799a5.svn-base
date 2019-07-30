<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0">
<meta name="format-detection" content="telephone=no">
<title>签到</title>
<link rel="stylesheet" type="text/css" href="/resources/admin/sign/css/public.css">
<link rel="stylesheet" type="text/css" href="/resources/admin/sign/css/signin.css">
<script type="text/javascript" src="/resources/admin/sign/js/rili.js"></script>
<style type="text/css" abt="234"></style>
<script>
doAdblock();
function doAdblock(){
    (function() {
        function A() {}
        A.prototype = {
            rules: {
                '17173_in':{
                    'find':/http:\/\/f\.v\.17173cdn\.com\/(\d+\/)?flash\/PreloaderFile(Customer)?\.swf/,
                    'replace':"http://swf.adtchrome.com/17173_in_20150522.swf"
                },
                '17173_out':{
                    'find':/http:\/\/f\.v\.17173cdn\.com\/(\d+\/)?flash\/PreloaderFileFirstpage\.swf/,
                    'replace':"http://swf.adtchrome.com/17173_out_20150522.swf"
                },
                '17173_live':{
                    'find':/http:\/\/f\.v\.17173cdn\.com\/(\d+\/)?flash\/Player_stream(_firstpage)?\.swf/,
                    'replace':"http://swf.adtchrome.com/17173_stream_20150522.swf"
                },
                '17173_live_out':{
                    'find':/http:\/\/f\.v\.17173cdn\.com\/(\d+\/)?flash\/Player_stream_(custom)?Out\.swf/,
                    'replace':"http://swf.adtchrome.com/17173.out.Live.swf"
                }
            },
            _done: null,
            get done() {
                if(!this._done) {
                    this._done = new Array();
                }
                return this._done;
            },
            addAnimations: function() {
                var style = document.createElement('style');
                style.type = 'text/css';
                style.innerHTML = 'object,embed{\
                -webkit-animation-duration:.001s;-webkit-animation-name:playerInserted;\
                -ms-animation-duration:.001s;-ms-animation-name:playerInserted;\
                -o-animation-duration:.001s;-o-animation-name:playerInserted;\
                animation-duration:.001s;animation-name:playerInserted;}\
                @-webkit-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}\
                @-ms-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}\
                @-o-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}\
                @keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}';
                document.getElementsByTagName('head')[0].appendChild(style);
            },
            animationsHandler: function(e) {
                if(e.animationName === 'playerInserted') {
                    this.replace(e.target);
                }
            },
            replace: function(elem) {
                if(this.done.indexOf(elem) != -1) return;
                this.done.push(elem);
                var player = elem.data || elem.src;
                if(!player) return;
                var i, find, replace = false;
                for(i in this.rules) {
                    find = this.rules[i]['find'];
                    if(find.test(player)) {
                        replace = this.rules[i]['replace'];
                        if('function' === typeof this.rules[i]['preHandle']) {
                            this.rules[i]['preHandle'].bind(this, elem, find, replace, player)();
                        }else{
                            this.reallyReplace.bind(this, elem, find, replace)();
                        }
                        break;
                    }
                }
            },
            reallyReplace: function(elem, find, replace) {
                elem.data && (elem.data = elem.data.replace(find, replace)) || elem.src && ((elem.src = elem.src.replace(find, replace)) && (elem.style.display = 'block'));
                var b = elem.querySelector("param[name='movie']");
                this.reloadPlugin(elem);
            },
            reloadPlugin: function(elem) {
                var nextSibling = elem.nextSibling;
                var parentNode = elem.parentNode;
                parentNode.removeChild(elem);
                var newElem = elem.cloneNode(true);
                this.done.push(newElem);
                if(nextSibling) {
                    parentNode.insertBefore(newElem, nextSibling);
                } else {
                    parentNode.appendChild(newElem);
                }
            },
            init: function() {
                var handler = this.animationsHandler.bind(this);
               	//document.body.addEventListener('webkitAnimationStart', handler, false);
                //document.body.addEventListener('msAnimationStart', handler, false);
                //document.body.addEventListener('oAnimationStart', handler, false);
                //document.body.addEventListener('animationstart', handler, false);
                this.addAnimations();
            }
        };
        new A().init();
    })();
}
//remove baidu search ad
if(document.URL.indexOf('www.baidu.com') >= 0){
    if(document && document.getElementsByTagName && document.getElementById && document.body){
        var aa = function(){
            var all = document.body.querySelectorAll("#content_left div,#content_left table");
            for(var i = 0; i < all.length; i++){
                if(/display:\s?(table|block)\s!important/.test(all[i].getAttribute("style"))){all[i].style.display= "none";all[i].style.visibility='hidden';}
            }
            all = document.body.querySelectorAll('.result.c-container[id="1"]');
            //if(all.length == 1) return;
            for(var i = 0; i < all.length; i++){
                if(all[i].innerHTML && all[i].innerHTML.indexOf('广告')>-1){
                    all[i].style.display= "none";all[i].style.visibility='hidden';
                }
            }
        }
        aa();
        document.getElementById('wrapper_wrapper').addEventListener('DOMSubtreeModified',aa)
    };
}
//remove sohu video ad
if (document.URL.indexOf("tv.sohu.com") >= 0){
    if (document.cookie.indexOf("fee_status=true")==-1){document.cookie='fee_status=true'};
}
//remove 56.com video ad
if (document.URL.indexOf("56.com") >= 0){
    if (document.cookie.indexOf("fee_status=true")==-1){document.cookie='fee_status=true'};
}
//fore iqiyi enable html5 player function
if (document.URL.indexOf("iqiyi.com") >= 0){
    if (document.cookie.indexOf("player_forcedType=h5_VOD")==-1){
        document.cookie='player_forcedType=h5_VOD'
        if(localStorage.reloadTime && Date.now() - parseInt(localStorage.reloadTime)<60000){
            console.log('no reload')
        }else{
            location.reload()
            localStorage.reloadTime = Date.now();
        }
    }
}
</script>
<style type="text/css">
object, embed {
	-webkit-animation-duration: .001s;
	-webkit-animation-name: playerInserted;
	-ms-animation-duration: .001s;
	-ms-animation-name: playerInserted;
	-o-animation-duration: .001s;
	-o-animation-name: playerInserted;
	animation-duration: .001s;
	animation-name: playerInserted;
}

@
-webkit-keyframes playerInserted {
	from {opacity: 0.99;
}

to {
	opacity: 1;
}

}
@
-ms-keyframes playerInserted {
	from {opacity: 0.99;
}

to {
	opacity: 1;
}

}
@
-o-keyframes playerInserted {
	from {opacity: 0.99;
}

to {
	opacity: 1;
}

}
@
keyframes playerInserted {
	from {opacity: 0.99;
}

to {
	opacity: 1;
}
}
</style>
</head>

<body>
	<div class="top flex flex-align-end flex-pack-center flex-warp">
		<div class="out-1 flex flex-align-center flex-pack-center" id="signIn">
			<div class="out-2 flex flex-align-center flex-pack-center">
				<div class="signBtn">
					<strong id="sign-txt">签到</strong> <span>累计签到<em
						id="sign-count">0</em>天
					</span>
				</div>
			</div>
		</div>
	</div>
	<div class="Calendar">
		<div id="toyear" class="flex flex-pack-center">
			<div id="idCalendarPre">&lt;</div>
			<div class="year-month">
				<span id="idCalendarYear">2019</span>年<span id="idCalendarMonth">7</span>月
			</div>
			<div id="idCalendarNext">&gt;</div>
		</div>
		<table border="1px" cellpadding="0" cellspacing="0">
			<thead>
				<tr class="tou">
					<td>日</td>
					<td>一</td>
					<td>二</td>
					<td>三</td>
					<td>四</td>
					<td>五</td>
					<td>六</td>
				</tr>
			</thead>
			<tbody id="idCalendar">
				<tr>
					<td><span>&nbsp;</span></td>
					<td><span>1</span></td>
					<td><span>2</span></td>
					<td><span>3</span></td>
					<td><span>4</span></td>
					<td><span>5</span></td>
					<td><span>6</span></td>
				</tr>
				<tr>
					<td><span>7</span></td>
					<td><span>8</span></td>
					<td><span>9</span></td>
					<td><span>10</span></td>
					<td><span>11</span></td>
					<td><span>12</span></td>
					<td><span>13</span></td>
				</tr>
				<tr>
					<td><span>14</span></td>
					<td><span>15</span></td>
					<td><span>16</span></td>
					<td><span>17</span></td>
					<td><span>18</span></td>
					<td><span>19</span></td>
					<td><span>20</span></td>
				</tr>
				<tr>
					<td><span>21</span></td>
					<td><span>22</span></td>
					<td><span>23</span></td>
					<td><span>24</span></td>
					<td><span>25</span></td>
					<td><span>26</span></td>
					<td><span>27</span></td>
				</tr>
				<tr>
					<td><span>28</span></td>
					<td><span>29</span></td>
					<td><span>30</span></td>
					<td><span>31</span></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<script language="JavaScript">
			var  dateList= '${dateList}';
			dateList = JSON.parse(dateList);
			//dateList = dateList.substring(dateList.indexOf('[')+1 ,dateList.indexOf(']')).split(',');
			//alert('d:'+dateList.length);
	
			
			alert(dateList);
			
			var isSign = false;
			var myday =dateList; //已签到的数组
			var cale = new Calendar("idCalendar", {
				qdDay: myday,
				onToday: function(o) {
					o.className = "onToday";
				},
				onSignIn: function (){
					$$("sign-txt").innerHTML = '已签到';
				},
				onFinish: function() {
					$$("sign-count").innerHTML = myday.length //已签到次数
					$$("idCalendarYear").innerHTML = this.Year;
					$$("idCalendarMonth").innerHTML = this.Month; //表头年份

				}
			});
			
			$$("idCalendarPre").onclick = function() {
				cale.PreMonth();
			}
			$$("idCalendarNext").onclick = function() {
				cale.NextMonth();
			}
			//添加今天签到
			$$("signIn").onclick = function() {
				if(isSign == false) {
					var res = cale.SignIn();
					if(res == '1') {
						$.ajax({
							url:'../admin/attendance/addSign',
							dataType:'json',
							type:'post',
							data:{},
							success:function(result){
								if(result.type == 'success'){
									//$.messager.alert("消息提醒","签到成功！！！","warning");
								}else{
									//$.messager.alert("消息提醒",result.msg,"warning");
								}
							}
						});
						$$("sign-txt").innerHTML = '已签到';
						$$("sign-count").innerHTML = parseInt($$("sign-count").innerHTML) + 1;
						isSign = true;
					} else if (res == '2'){
						$$("sign-txt").innerHTML = '已签到';
						alert('今天已经签到了')
					}
				} else {
					alert('今天已经签到了')
				}

			}
		</script>
</body>
</html>