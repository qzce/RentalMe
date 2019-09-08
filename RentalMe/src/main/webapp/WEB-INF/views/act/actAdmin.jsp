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
		
		console.log(event.data);
		var msg = JSON.parse(event.data);
		var id= msg.id;
		var text=msg.text;
		var type=msg.type;
		
		$('#liveviewcnt').text(msg.cnt);
		if(type=='bid'){
			$('#actLive').append(id+"�Բ��� �����ϼ̽��ϴ�<br/>");
			$('#bidList').append("<li>"+id+"</li>");
		}
		if(type=='enter'){
			$('#actLive').append(id+"���� ����忡 �����ϼ̽��ϴ�<br/>");
		}
		if(type=='adminMsg'){
			$('#actLive').append(text+"�� �����Ͻ� ��?<br/>");
			$('#nowPrice').text('');
			$('#nowPirce').append("���簡��: "+text+"��");
			$('#bidList').empty();
		}
	};
	function sendServer(){
		var msg={
			type: "adminMsg",
			text: $('#money').val(),
			id: "admin",
			cnt: 0
		};
		sock.send(JSON.stringify(msg));
	}
	$(function(){
		$('#sendMsg').click(function(){
			sendServer();
		});
	});
</script>
</head>
<div id="headAct"></div>
<body>
	<div id="nowPirce"></div>
	<div id="actLive"></div>
	<input type="number" id="money"><button id="sendMsg">����</button>
</body>
</html>