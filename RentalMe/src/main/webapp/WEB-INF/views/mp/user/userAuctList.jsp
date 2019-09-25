<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- ���� api�����ϱ� (������Ʈ)-->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
<style type="text/css">
	#title2{
            font-size: 15pt;
            font-weight: bolder;
            font-family: "nanumB";
            margin: 60px 0 50px 0;
      }
      
      #choosedel{
            font-family: "nanumR";
            width:55px;
            height:30px;
            float:right;
            color:black;
            font-weight:600;
      }
		
		
       .ordtable>thead>tr>th{
           text-align:center;
        }
        
       .ordtable>tbody>tr>td{
           vertical-align: middle;
           text-align: center;
           display: table-cell;
        }
        
      .ordimg{
            width:100px;
      }
      
       .delete_btn1{
            background-color: #D8D8D8;
            color:black;
            height:30px;
            font-family: "nanumB";   
            font-weight: border;   
      }
      
      .delete_btn2{
            background-color: #4d4d4d;
            color:white;
            height:30px;
            font-family: "nanumB";
            font-weight: border;      
      }
      
      .btn:hover,
      .btn:focus{
            background-color: #D8D8D8;
      }
      #info{
      	width:93%;
      	margin: 20px auto;
      	border:7px solid #E6E6E6;
      	padding: 15px;
      }
      
      #info p{
      	line-height:20px;
      	font-family:"nanumB";
      }
      #realTotPriceTxt {
		width: 570px;
		text-align: center;
		font-weight: bolder;
	    color: darkred;
	}
	#cartConfirm {
		font-size: 15pt;
		font-weight: bolder;
	}
	.titlediv{
            height:40px;
      }
</style>
<jsp:include page="../../template/headerMp.jsp"></jsp:include>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script type="text/javascript">
	window.onload = function () {

		 // ���� ���
	       $('#myModal').on('shown.bs.modal', function (e) {
		       $("#inlineRadio1").prop("checked", true);
	    	   var gdsCd = $(e.relatedTarget).data('gds-cd');
	    	   var gdsNm = $(e.relatedTarget).data('gds-nm'); 
	    	   var bidPrice = $(e.relatedTarget).data('bid-price');
	    	    $(e.currentTarget).find('input[name="realBidPrice"]').val(bidPrice);
	    	   bidPrice = bidPrice+"";
				$(e.currentTarget).find('input[name="crudGbCd"]').val("UUPC");
				$(e.currentTarget).find('input[name="odrGbCd"]').val("10");
				$(e.currentTarget).find('input[name="gdsCd"]').val(gdsCd);
				$(e.currentTarget).find('input[name="gdsNm"]').val(gdsNm);
				$(e.currentTarget).find('input[name="bidPrice"]').val(bidPrice.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,')+"��");
				//$(e.currentTarget).find('input[name="odrStsGbCd"]').val("PC");
	       });
	
	       // ���� ���
	       $('#myModal2').on('shown.bs.modal', function (e) {
	    	   var gdsCd = $(e.relatedTarget).data('gds-cd');
	    	   var gdsNm = $(e.relatedTarget).data('gds-nm');
	    	   var bidPrice = $(e.relatedTarget).data('bid-price');
	    	   var bidStPrice = $(e.relatedTarget).data('gds-st');
				$(e.currentTarget).find('input[name="crudGbCd"]').val("UUPC");
				$(e.currentTarget).find('input[name="odrGbCd"]').val("10");
				$(e.currentTarget).find('input[name="gdsCd"]').val(gdsCd);
				$(e.currentTarget).find('input[name="gdsNm"]').val(gdsNm);
				$(e.currentTarget).find('input[name="bidPrice"]').val(bidPrice);
				$(e.currentTarget).find('input[name="gdsStPrice"]').val(bidStPrice);
				$(e.currentTarget).find('#stPriceAlarm').text('(����) ������'+bidStPrice+'���� ���������ϴ�');
				//$(e.currentTarget).find('input[name="odrStsGbCd"]').val("PC");
	      });
		
	}
	/**************************/
	/**** �������� ������� ***/
	/**************************/
	
	var radioVal = "90";		// �������� (10:ī��  90:������(default))
	
	/**************************/
	/**** �������� ���� *****/
	/**************************/

	// �����ϱ� ������ư(�������Ա�)
	$(document).on("click", "#inlineRadio1", function(){
		radioVal = $('input[name="inlineRadioOptions"]:checked').val();
		$('#bank').show();
		$('#bankInfo').show();
	});

	// �����ϱ� ������ư(īī������)
	$(document).on("click", "#inlineRadio2", function(){
		radioVal = $('input[name="inlineRadioOptions"]:checked').val();
		$('#bank').hide();
		$('#bankInfo').hide();
	});

	$("#inlineRadio1").attr('checked', 'checked');
	
	// �����ϱ� ��� 
	$(document).on("click", "#realSubmit", function(){
		var amount = $('#realBidPrice').val();	// ������ ���� �ݾ�
		var userId = "${loginUserId}";
		var crudGbCd = "IIACTC";
		var odrGbCd = "30";
		var payGbCd = radioVal;
		var seq	= "001";
		var mbNo = "${sessionMbNo}";
		var gdsCd = $('#realGdsCd').val();

		// ī��(īī������ ����)
		if(payGbCd == 10) {
			var IMP = window.IMP;
			IMP.init('imp86711610');
			
			IMP.request_pay({
			    pg : 'kakaopay',
			    pay_method : 'vbank',
			    merchant_uid : 'merchant_' + new Date().getTime(),
			    name : '��Ż�� ��Ż�ǰ ����',
			    amount : amount,
			    buyer_name : userId
			}, function(rsp) {
			    if ( rsp.success ) {
			        var msg = '������ �Ϸ�Ǿ����ϴ�.';
					$.ajax({
						url: "/mp/auctList/odr",
						type: "post",
						data: { "totOdrAmt"  	: amount,
								"crudGbCd"		: crudGbCd,
								"odrGbCd"		: odrGbCd,
								"payGbCd"		: payGbCd,
								"seq"			: seq,
						         "mbNo"			: mbNo,
						         "gdsCd"  		: gdsCd,
							 },
						success : function(){
							//location.href = "/rental/Appli/lg/"+gdsSclassCd+"/detail/"+gdsCd;
							location.href="/mp/auctList";
						}
					});
			    } else {
			        var msg = '������ �����Ͽ����ϴ�.';
			        msg += '�������� : ' + rsp.error_msg;
			    }
			    alert(msg);
			});
		
		} else {
			if(true) {
				var msg = '�ֹ��� �����Ǿ����ϴ�.';
				$.ajax({
					url: "/mp/auctList/odr",
					type: "post",
					data: { "totOdrAmt"  	: amount,
							"crudGbCd"		: crudGbCd,
							"odrGbCd"		: odrGbCd,
							"payGbCd"		: payGbCd,
							"seq"			: seq,
					         "mbNo"			: mbNo,
					         "gdsCd"  		: gdsCd,
						 },
					success : function(){
						//location.href = "/rental/Appli/lg/"+gdsSclassCd+"/detail/"+gdsCd;
						location.href="/mp/auctList";
					}
				});
			} else {
				var msg = '�ֹ��� �����Ͽ����ϴ�.';
		        msg += '�������� : �������Ա� �ֹ����� ERR 900';
			}
			alert(msg);
		}

	});

	

</script>
</head>
<body>
<div style="height:100%;">
	<div>
	<div class="titlediv">
       <p id="title2">��ų���</p>
     </div>
     <div class="hr" style="height:3px; background-color: black;"></div>
       	 <div id="info">
       	 <p>
	       	 <input type="hidden" value="${loginMbNo}">
		     <c:if test="${empty userVo.userNM}">
		     	${loginUserId} ���� ��ų����Դϴ�.
		     </c:if>
		     <c:if test="${!empty userVo.userNM }">
		     	${userVo.userNM} ���� ��ų����Դϴ�.
		     </c:if>
		  </p>
       	 </div>
       	<table class="ordtable table">
       	<thead>
       		<tr class="active">
       			<th>��Ż�ǰ�ڵ�
       			<th>��Ż�ǰ��</th>
       			<th>�����Ͻ�</th>
       			<th>��������</th>
       			<th>��������</th>
       			<th>�ֹ�����/�ֹ���ȣ</th>
       		</tr>
       	</thead>
       	<tbody>
       	<c:forEach items="${alist}" var="bean" varStatus="status">
       		<input type="hidden" class="hiddenPrice" value="${bean.gdsStPrice }">
       		<tr>  
       			<td style="vertical-align:middle;">${bean.gdsCd }</td>
       			<td style="text-align:left; vertical-align:middle;">
	                <a style="text-decoration:none; color:black;"href="/rental/Appli/lg/${fn:substring(bean.gdsCd,4,6) }/detail/${bean.gdsCdDetail}">
	                <img class="ordimg" src="${bean.img1}"/><textarea rows="2" cols="30" style="vertical-align:middle; border:0; cursor:pointer; resize: none;" readonly="readonly" >${bean.gdsNm }</textarea>
	                <input type="hidden" value="${bean.gdsCd}"/></a>
                </td>
       			<td style="vertical-align:middle;">${fn:substring(bean.bidTime,0,10)}
       			<p>${fn:substring(bean.bidTime,11,19)}
       			</td>
       			<td style="vertical-align:middle;"><fmt:formatNumber pattern="##,###.##">${bean.bidPrice}</fmt:formatNumber>��
       			</td>
       			<c:if test="${bean.actBidStsCd eq 1}">
       				<td style="vertical-align:middle;">����</td>
       				<td style="vertical-align:middle;">
       				<c:if test="${empty bean.odrStsGbCd}">
	       				 <button id="odrBtn${status.index }" type="button" class="btn btn-primary" style="font-size: 9pt;" data-toggle="modal" data-target="#myModal" data-gds-cd="${bean.gdsCd }" data-gds-nm="${bean.gdsNm }" data-bid-price="${bean.bidPrice }"  >����</button>
	 					 <button id="odrBtn${status.index }" type="button" class="btn btn-danger" style="font-size: 9pt;" data-toggle="modal" data-target="#myModal2" data-gds-cd="${bean.gdsCd }" data-gds-st="${bean.gdsStPrice}">����</button><br>
       				</c:if>
       				<c:if test="${bean.odrStsGbCd eq 'DW'}">
       					<button id="odrBtn${status.index }" type="button" class="btn btn-primary" style="font-size: 9pt; margin-top:20px; opacity:0.5" disabled="disabled" >�Աݴ��</button><br>
       					<p class="tdtext2" id="odrNo${status.index }" style="text-align:center; color:red; ">
               				<br>${bean.odrNo} &nbsp;
               			</p> 
       				</c:if>
       				<c:if test="${bean.odrStsGbCd eq 'AC'}">
       					<button id="odrBtn${status.index }" type="button" class="btn btn-primary" style="font-size: 9pt; margin-top:20px; opacity:0.5" disabled="disabled" >�ֹ��Ϸ�</button><br>
       					<p class="tdtext2" id="odrNo${status.index }" style="text-align:center; color:red; ">
               				<br>${bean.odrNo} &nbsp;
               			</p> 
       				</c:if>
       				</td>
       			</c:if>
       			<c:if test="${bean.actBidStsCd eq 2}">
       				<td style="vertical-align:middle;">����</td><td></td>
       			</c:if>
       			<c:if test="${bean.actBidStsCd eq 3}">
       				<td style="vertical-align:middle;">����</td><td></td>
       			</c:if>
       		</tr>
       	</c:forEach>
       	</tbody>
       	</table>
       </div>
       </div>
       <div class="hr" style="height:2px;"></div>
       <c:forEach items="${alist }" var="bean" varStatus="status">
      <!-- �����ϱ� ��� -->
	 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		 <div class="modal-dialog" role="document">
		  	<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">�ֹ��ϱ�</h4>
			    </div>
				<div class="modal-body">
				    <div class="row" style="border:0px solid orange;">
 								<h3><label for="realGdsNm">&nbsp;&nbsp;��ǰ����</label></h3>
  							<div id="detailNm" class="col-md-4" style="border:0px solid black;">
					    	<h4><label for="realGdsNm">��ǰ��</label></h4>
					    	<h4><label for="realGdsPrice">��������</label></h4>
						</div>
						<div id="detailNm2" class="col-md-8">
							<input type="text" class="btn btn-default" id="realGdsNm" disabled="disabled" style="background-color:white; border:solid 0px; margin-top:5px;  text-align:left;" name="gdsNm" value="gdsNm"  >
							<fmt:setLocale value="ko_KR"></fmt:setLocale>
							<input type="text" class="btn btn-default" id="realGdsNm" disabled="disabled" style="background-color:white; border:solid 0px; margin-top:4px; text-align:left;" name="bidPrice" value="bidPrice"/>
						</div>
					</div>
					<div class="row" style="border:0px solid orange;">
						<h3><label>&nbsp;&nbsp;��������</label></h3>
						<label class="radio-inline">
					  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="inlineRadioOptions" id="inlineRadio1" checked="checked" value="90">�������Ա�
						</label>
						<label class="radio-inline">
					  		<input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="10">īī������
						</label>
						<h5><label id="bank">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; �����ָ� : (��)��Ż�� &nbsp;&nbsp;&nbsp; �Աݰ��¹�ȣ : 415015-92-928253(����)</label></h5>
						<h5><label id="bankInfo">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; * �������Ա��� �ֹ��ϱ� �� �Ա��� �Ϸ�Ǿ�� ���� �ֹ��Ϸ�ó�� �˴ϴ�.</label></h5>
					</div>
					<div class="form-group" id="realTotPriceTxtCls">
				    	<input type="hidden"  id="realTotPrice" style="border:0px;" name="bidPrice" readonly="readonly"  value="${bean.bidPrice }">
				    	<fmt:setLocale value="ko_KR"></fmt:setLocale>
				    	<h2><input type="text"  id="realTotPriceTxt" style="border:0px;" name="bidPrice" readonly="readonly" value="<fmt:formatNumber value="${bean.bidPrice }" /> "></h2>
				    	<input type="hidden" id="realGdsCd" name="gdsCd" value="gdsCd"/>
				    	<input type="hidden" id="realGdsNm" name="gdsNm" value="gdsNm"/>
				    	<input type="hidden" id="realBidPrice" name="realBidPrice" value="realBidPrice"/>
					</div>
				    <div class="modal-footer">
				    	<button type="button" id="realSubmit" class="btn btn-danger">�ֹ��ϱ�</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">���</button>
				    </div>
		    	</div>
			</div>
    	</div>
	</div>
	
	<!-- ��� �� -->		
	</c:forEach>
	<!-- ���� ��� -->
	<form id="target" action="/act/cancel" method="post">
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel2">��������</h4>
			    </div>
				<div class="modal-body">
					<input type="hidden" name="gdsCd" value="gdsCd"/>
					<input type="hidden" name="mbNo" value="${sessionMbNo }">
					<input type="hidden" name="gdsStPrice" value="gdsStPrice">
				</div>
				<div class="form-group">
			    	<label for="name" id="cartConfirm">&nbsp;&nbsp;&nbsp;���� �Ͻðڽ��ϱ�?</label>
			    	<label id="stPriceAlarm"></label>
				</div>
			    <div class="modal-footer">
			    	<button type="submit" id="questSubmit" class="btn btn-danger">����</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">���</button>
			    </div>
			</div>
	    </div>
	</div>
	</form>
	<!-- ��� �� -->
</body>
</html>