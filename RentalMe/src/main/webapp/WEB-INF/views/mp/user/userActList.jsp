<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<jsp:include page="../../template/headerMp.jsp"></jsp:include>
</head>
<body>
	<div>
	<div class="titlediv">
       <p id="title">��ų���</p>
     </div>
     <div class="hr" style="height:3px; background-color: black;"></div>
       	 <div id="info">
       	 <p>
	       	 <input type="hidden" value="${loginMbNo}">
		     <c:if test="${empty loginUserNM}">
		     	${loginUserId} ���� ��ų����Դϴ�.
		     </c:if>
		     <c:if test="${!empty loginUserNM }">
		     	${loginUserNM} ���� ��ų����Դϴ�.
		     </c:if>
		  </p>
       	 </div>
       <a href="#" id="choosedel">���û���</a>
       	<table class="ordtable table">
       	<thead>
       		<tr class="active">
       			<th><input type="checkbox" name="checkAll" id="th_checkAll" onclick="checkAll();"/></th>
       			<th>��ǰ��/���û���</th>
       			<th>����</th>
       			<th>��Ż�Ⱓ</th>
       			<th>��ǰ�ݾ�</th>
       		</tr>
       	</thead>
       	<tbody>
   		 <c:set var="sumPrice" value="0"/>
       	<c:forEach items="${alist}" var="bean">
       		<tr data-tr_value="${bean.usedGdsNo}">  
       			<td><input type="checkbox" class="checkRow" name="checkRow" data-wishNum="${bean.usedGdsNo}"></td>
       			<td><img class="ordimg" src="imgs/bed1.jpg"/>${bean.gdsNm}</td>
       			<td>${bean.odrQty}</td>
       			<td>${bean.agreeTerm}����</td>
       			<td><fmt:formatNumber pattern="#,###.##">${bean.gdsPrice}</fmt:formatNumber> ��
       			</td>
       		</tr>
       	<c:set var="sumPrice" value="${sumPrice +(bean.gdsPrice * bean.odrQty)}"/>
       	</c:forEach>
       	</tbody>
       	</table>
       </div>
       <div class="hr" style="height:2px;"></div>
       <div class="cartresult">
       	<p>�� �ֹ� �ݾ�: <fmt:formatNumber value="${sumPrice}" pattern="#,###.##"/> ��</p>
       </div>
       <div class="hr" style="height:2px; margin-top:100px;"></div>
		<div class="cartbtn">
			<button type="button" class="delete_btn1 btn">��� �����ϱ�</button>
			<button type="button" class="delete_btn2 btn">�ֹ��ϱ�</button>
		</div>
      
</body>
</html>