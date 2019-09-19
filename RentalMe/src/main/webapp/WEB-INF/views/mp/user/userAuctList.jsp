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
            width:150px;
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
</style>
<jsp:include page="../../template/headerMp.jsp"></jsp:include>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
	window.onload = function () {

		 // ���� ���
	       $('#myModal').on('shown.bs.modal', function (e) {
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
				$(e.currentTarget).find('input[name="crudGbCd"]').val("UUPC");
				$(e.currentTarget).find('input[name="odrGbCd"]').val("10");
				$(e.currentTarget).find('input[name="gdsCd"]').val(gdsCd);
				$(e.currentTarget).find('input[name="gdsNm"]').val(gdsNm);
				$(e.currentTarget).find('input[name="bidPrice"]').val(bidPrice);
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

	// �����ϱ� ��� 
	$(document).on("click", "#realSubmit", function(){
		var amount = $('#realBidPrice').val();	// ������ ���� �ݾ�
		var userId = "${loginUserId}";
		var crudGbCd = "II";
		var odrGbCd = "30";
		var payGbCd = radioVal;
		var seq	= "001";
		var mbNo = "${sessionMbNo}";
		alert(mbNo);
		return false;
		var gdsSclassCd = $('#realGdsSclassCd').val();
		var gdsCd = "";
		var gdsPrice = $('#realGdsPrice').val();
		var agreeTerm = $('#realAgreeTerm').val();
		var deliverCost = "";
		var instalCost = "";
		var asCondition = "";
		var odrQty = $('#realOdrQty').val();

		<c:forEach items="${list1}" var="list1">
			gdsCd = "${list1.gdsCd}";
		 	deliverCost = "${list1.deliverCost}";
		 	instalCost = "${list1.instalCost}";
		 	asCondition = "${list1.asCondition}";
		</c:forEach>

		// ī��(īī������ ����)
		if(payGbCd == 10) {
			var IMP = window.IMP;
			IMP.init('imp86711610');
			
			IMP.request_pay({
			    pg : 'kakaopay',
			    pay_method : 'vbank',
			    merchant_uid : 'merchant_' + new Date().getTime(),
			    name : '��Ż�� ��Ż��ǰ ����',
			    amount : amount,
			    buyer_name : userId
			}, function(rsp) {
			    if ( rsp.success ) {
			        var msg = '������ �Ϸ�Ǿ����ϴ�.';
			        
					$.ajax({
						url: "/rental/Appli/lg/detail/odr",
						type: "post",
						data: { "totOdrAmt"  	: rsp.paid_amount,
								"crudGbCd"		: crudGbCd,
								"odrGbCd"		: odrGbCd,
								"payGbCd"		: payGbCd,
								"seq"			: seq,
						         "mbNo"			: mbNo,
						         "gdsSclassCd"	: gdsSclassCd,
						         "gdsCd"  		: gdsCd,
						         "gdsPrice"		: gdsPrice,
						         "agreeTerm"	: agreeTerm,
						         "deliverCost"  : deliverCost,
						         "instalCost"  	: instalCost,
						         "asCondition" 	: asCondition,
						         "odrQty"  		: odrQty
							 },
						success : function(){
							//location.href = "/rental/Appli/lg/"+gdsSclassCd+"/detail/"+gdsCd;
							location.href="/mp/";
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
					url: "/rental/Appli/lg/detail/odr",
					type: "post",
					data: { "totOdrAmt"  	: amount,
							"crudGbCd"		: crudGbCd,
							"odrGbCd"		: odrGbCd,
							"payGbCd"		: payGbCd,
							"seq"			: seq,
					         "mbNo"			: mbNo,
					         "gdsCd"  		: gdsCd,
					         "gdsSclassCd"	: gdsSclassCd,
					         "gdsPrice"		: gdsPrice,
					         "agreeTerm"	: agreeTerm,
					         "deliverCost"  : deliverCost,
					         "instalCost"  	: instalCost,
					         "asCondition" 	: asCondition,
					         "odrQty"  		: odrQty
						 },
					success : function(){
						//location.href = "/rental/Appli/lg/"+gdsSclassCd+"/detail/"+gdsCd;
						location.href="/mp/";
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
       			<th>�ֹ�</th>
       		</tr>
       	</thead>
       	<tbody>
       	<c:forEach items="${alist}" var="bean" varStatus="status">
       		<tr>  
       			<td style="vertical-align:middle;">${bean.gdsCd }</td>
       			<td style="text-align:left; vertical-align:middle;">
	                <a style="text-decoration:none; color:black;"href="/rental/Appli/lg/${fn:substring(bean.gdsCd,4,6) }/detail/${bean.gdsCdDetail}">
	                <img class="ordimg" src="${bean.img1}"/><textarea rows="2" cols="30" style="vertical-align:middle; border:0; cursor:pointer; resize: none;" readonly="readonly" >${bean.gdsNm }</textarea>
	                <input type=hidden value="${bean.gdsCd}"/></a>
                </td>
       			<td style="vertical-align:middle;">${bean.bidTime}</td>
       			<td style="vertical-align:middle;"><fmt:formatNumber pattern="##,###.##">${bean.bidPrice}</fmt:formatNumber> ��
       				<input id="auctPrice" type="hidden" value="${bean.bidPrice}"/>
       			</td>
       			<c:if test="${bean.actBidStsCd eq 1}">
       				<td style="vertical-align:middle;">����</td>
       				<td style="vertical-align:middle;">
	       				<button id="odrBtn${status.index }" type="button" class="btn btn-primary" style="font-size: 9pt;" data-toggle="modal" data-target="#myModal" data-gds-cd="${bean.gdsCd }" data-gds-nm="${bean.gdsNm }" data-bid-price="${bean.bidPrice }"  >����</button>
	       				<!-- 
	       				<form action="/act/cancel" method="post">
	 						<button type="submit" class="btn btn-danger" style="font-size: 9pt;" >����</button>
	 					</form>
	 					 -->
	 					 <button id="odrBtn${status.index }" type="button" class="btn btn-danger" style="font-size: 9pt;" data-toggle="modal" data-target="#myModal2" data-gds-cd="${bean.gdsCd }">����</button>
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
					    	<input type="text" class="form-control" id="realGdsCd" name="gdsCd" value="${bean.gdsCd }" style="display: none;">
							<input type="text" class="btn btn-defalut" style="background-color:white; text-align:left;" name="gdsNm" value="gdsNm"  >
							<fmt:setLocale value="ko_KR"></fmt:setLocale>
							<input type="text" class="btn btn-defalut" id="realGdsPrice2" disabled="disabled" style="background-color:white; text-align:left;" name="bidPrice" value="bidPrice"/>
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
						<h5><label id="bankInfo">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; * �������Ա��� �ֹ��ϱ� �� �Ա��� �Ϸ�Ǿ�� ���� �ֹ�Ȯ��ó�� �˴ϴ�.</label></h5>
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
	<!-- ��ǰ ��� -->
	<form id="target" action="/mp/decision" method="post">
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel2">�����û</h4>
			    </div>
			    		<label class="radio-inline">
					  		<input type="radio" name="inlineRadioOptions5" id="inlineRadio1" checked="checked" value="90">�������Ա�
						</label>
						<label class="radio-inline">
					  		<input type="radio" name="inlineRadioOptions5" id="inlineRadio2" value="10">īī������
						</label>
				<div class="modal-body">
					<input type="hidden" name="gdsCd" value="gdsCd"/>
				</div>
				<div class="form-group">
			    	<label for="name" id="cartConfirm">&nbsp;&nbsp;&nbsp;�����û �Ͻðڽ��ϱ�?</label>
				</div>
			    <div class="modal-footer">
			    	<button type="submit" id="questSubmit" class="btn btn-danger">��û</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">���</button>
			    </div>
			</div>
	    </div>
	</div>
	</form>
	<!-- ��� �� -->
</body>
</html>