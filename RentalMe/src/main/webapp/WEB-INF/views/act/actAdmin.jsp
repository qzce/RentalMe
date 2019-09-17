<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="root" value="/"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<jsp:include page="../template/header.jsp"></jsp:include>
<style type="text/css">
	#headAct{
		clear: both;
		height: 300px;
	}
</style>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
<script type="text/javascript">
	var sock=new SockJS("${root}act/ac");
	sock.onopen=function(event){
		
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
			$('#actLive').append(id+"�Բ��� �����ϼ̽��ϴ�<br/>");
			$('#bidList').append("<li>"+id+"</li>");
			$('#countView').text('');
		}else if(type=='enter'){
			$('#actLive').append(id+"���� ����忡 �����ϼ̽��ϴ�<br/>");
		}else if(type=='adminMsg'){
			$('#actLive').append(text+"�� �����Ͻ� ��?<br/>");
			$('#nowPrice').text('');
			$('#nowPrice').append("���簡��: "+text+"��");
			$('#bidList').empty();
		}else if(typeof(msg)=='number'){
			$('#countView').text('');
			$('#countView').append('<img alt="count" src="/imgs/'+msg+'.png">');
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
	$(function(){
		$('.sendMsg').click(function(){
			sendServer($(this));
		});
		$('#countDown').click(function(){
			countDown();
		});
	});
</script>
</head>
<div id="headAct"></div>
<body>
	<div id="nowPrice"></div>
	<div id="actLive"></div>
	<input type="button" class="sendMsg" value="1000">
	<input type="button" class="sendMsg" value="5000">
	<input type="button" class="sendMsg" value="10000">
	<input type="button" class="sendMsg" value="50000">
	<input type="button" class="sendMsg" value="100000">
	<div id="countView"></div>
	<button id="countDown">������ ī��Ʈ</button>
	<ol id="bidList"></ol>
	<ol id="listMsg">
	</ol>
	<form action="/act/result" method="post">
	<input type="hidden" name="gdsCd" value="${list1.gdsCd }">
	<input type="hidden" id="bidresult" name="bidresult">
	<button>����</button>
	</form>
</body>
</html>