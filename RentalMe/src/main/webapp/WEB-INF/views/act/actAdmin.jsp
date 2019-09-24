<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="root" value="/"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>RentalMe - ������ ���</title>
<jsp:include page="../template/header.jsp"></jsp:include>
<style type="text/css">
	#headAct{
		clear: both;
		width: 800px;
		height: 100%;
		margin-top:100px;
	}
	#countimg{
		width:100px;
		padding:10px;
	}
 	#actLive{
 		height: 500px;
 		overflow: auto;
 	}
 	#bidListDiv{
 		height: 500px;
 	}
 	.sendMsg{
 		width: 20%;
		background-color: white;
		height: 50px;
		color: black;
		border: 2px solid black;
		transition-duration: 0.4s;
		float: left;
		font-weight: bold;
		font-size: 30px;
	}
	.sendMsg:hover {
		background-color: black;
  		color: white;
	}
/*	
	#countDown{
		background-color: white;
		color: black;
		border: 2px solid #4CAF50;
		transition-duration: 0.4s;
	}
	#countDown:hover{
		background-color: #4CAF50;
  		color: white;
	} 
	 */
	 #countDownDiv{
	 	text-align: center;
	 }
	 #countDown{
	margin: 0px auto;
  position:relative;
  display:inline-block;
  margin:20px;
  cursor: pointer;
}

#countDown a{
  color:white;
  font-family:Helvetica, sans-serif;
  font-weight:bold;
  font-size:20px;
  text-align: center;
  text-decoration:none;
  background-color:#FFA12B;
  display:block;
  position:relative;
  padding:20px 30px;
  width: 200px;
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  text-shadow: 0px 1px 0px #000;
  filter: dropshadow(color=#000, offx=0px, offy=1px);
  
  -webkit-box-shadow:inset 0 1px 0 #FFE5C4, 0 10px 0 #915100;
  -moz-box-shadow:inset 0 1px 0 #FFE5C4, 0 10px 0 #915100;
  box-shadow:inset 0 1px 0 #FFE5C4, 0 10px 0 #915100;
  
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  border-radius: 5px;
}

#countDown a:active{
  top:10px;
  background-color:#F78900;
  
  -webkit-box-shadow:inset 0 1px 0 #FFE5C4, inset 0 -3px 0 #915100;
  -moz-box-shadow:inset 0 1px 0 #FFE5C4, inset 0 -3pxpx 0 #915100;
  box-shadow:inset 0 1px 0 #FFE5C4, inset 0 -3px 0 #915100;
}

#countDown:after{
  content:"";
  height:100%;
  width:104%;
  padding:4px;
  position: absolute;
  bottom:-15px;
  left:-4px;
  z-index:-1;
  background-color:#2B1800;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  border-radius: 5px;
}
#bidEndBtn{
	margin-top: -10px;
	float: right;
}

#moneyIn{
	font-family:"nanumB";
	font-weight: bold;
	font-size: 17px;
}
#userMsg{
	clear: both;
}
#adMsg{
	float: right;
	clear: both;
}
</style>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
<script type="text/javascript">
	var sock=new SockJS("${root}act/ac");
	sock.onopen=function(event){
		sendEnterServer($('#stPrice').text());
	};
	sock.onmessage=function(event){			//�� �������� �޽����� �޾��� ��
		
		console.log("���� ������"+event.data);
		console.log("Ÿ��:"+typeof(event.data));
		var msg = JSON.parse(event.data);
		var id= msg.id;
		var text=msg.text;
		var type=msg.type;
		
		$('#liveviewcnt').text(msg.cnt);
		if(type=='bid'){
			$('#actLive').append('<div id="userMsg">'+id+"�Բ��� �����ϼ̽��ϴ�</div>");
			$('#bidList').append("<li>"+id+"</li>");
			$('#countView').text('');
		}else if(type=='enter'){
			$('#actLive').append(id+"���� ����忡 �����ϼ̽��ϴ�<br/>");
		}else if(type=='adminMsg'){
			$('#actLive').append('<div id="adMsg"><span id="moneyIn">'+text+"</span>�� �����Ͻ� ��?</div>");
			$('#nowPrice').text('');
			$('#nowPrice').append("���簡��: <span id='moneyIn'>"+text+"<span>��");
			$('#bidList').empty();
		}else if(typeof(msg)=='number'){
			$('#countView').text('');
			$('#countView').append('<img id="countimg" alt="count" src="/imgs/'+msg+'.png">');
		}else if(type=='endMsg'){
			$('#sendMsg').attr('disabled', true);
			$('#countView').text('');
			$('#countView').append(text+'�� �����Ǿ����ϴ�.');
		}else if(type=='listMsg'){
			$('#listMsg').text('');
			text=text.slice(1,-1);				//�յ� �߰�ȣ���ֱ�
			var textSplit=text.split(', ');
			for (var i in textSplit){
				$('#listMsg').append('<li>'+textSplit[i]+'</li>');	
			}
		}else if(type=='bidResult'){
			text=text.split('�ٲ�').join('"');
			
			$('#bidresult').val(text);
		}
	};

	function sendEnterServer(who){
		var msg={
			type: "adminMsg",
			text: who,
			id: "admin",
			cnt: 0
		};
		
		sock.send(JSON.stringify(msg));
	}
	
	function sendServer(who){
		var msg={
			type: "adminMsg",
			text: who.val(),
			id: "admin",
			cnt: 0
		};
		
		sock.send(JSON.stringify(msg));
	}
	function countDown(){
		var msg={
			type: "countDown",
			text: 'countDown',
			id: "admin",
			cnt: 0
		};
		sock.send(JSON.stringify(msg));
	}
	function endBid(){
		var msg={
			type: "endBid",
			text: 'endBid',
			id: 'admin',
			cnt: 0
		};
		sock.send(JSON.stringify(msg));
	}
	
	$(function(){
		$('.sendMsg').click(function(){
			sendServer($(this));
		});
		$('#countDown').click(function(){
			countDown();
		});
		$('#bidEndBtn').click(function(){
			endBid();
		});
		$('#actLive').bind("DOMSubtreeModified",function(){
			$('#actLive').scrollTop($('#actLive').prop('scrollHeight'));
		});
	});
</script>
</head>
<body>
<div id="headAct" class="container">
	<div class="row">
	<h3 style="text-align:center;">��� ������ ������</h3>
		<table class="table">
			<tr>
				<th>��ǰ�ڵ�</th>
				<th>��ǰ��</th>
				<th>�귣���</th>
				<th>���۰�</th>
			</tr>
			<tr>
				<td>${list1.gdsCd }</td>
				<td>${list1.gdsNm }</td>
				<td>${list1.brandNm }</td>
				<td id="stPrice">${list1.gdsStPrice }</td>
			</tr>
		</table>
		<div id="actLive" class="col-md-9" style="border:1px solid black;"></div>
		<div id="bidListDiv" class="col-md-3" style="border:1px solid black;"><div id="nowPrice"></div><ol id="bidList"></ol></div>
		<div style="border:1px solid lightgrey; padding:30px;">
			<input type="button" class="sendMsg" value="1000">
			<input type="button" class="sendMsg" value="5000">
			<input type="button" class="sendMsg" value="10000">
			<input type="button" class="sendMsg" value="50000">
			<input type="button" class="sendMsg" value="100000">
			<div id="countView"></div>
			<div id="countDownDiv"><div id="countDown"><a>������ ī��Ʈ</a></div></div>
			<ol id="listMsg">
			</ol>
			<form action="/act/result" method="post">
			<input type="hidden" name="gdsCd" value="${list1.gdsCd }">
			<input type="hidden" id="bidresult" name="bidresult">
			<button id="bidEndBtn" class="btn btn-danger">�������</button>
			</form>
		</div>
	</div>
</div>
<jsp:include page="../template/footer.jsp"></jsp:include>
</body>
</html>