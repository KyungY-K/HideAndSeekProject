<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link href="resources/css/mypage/mypage_main.css" rel="stylesheet" type="text/css">


	<jsp:include page="../banner/user_top.jsp" />
 
<main style = "min-height : 100%;;">
<div id = "mypage"> <!-- main 영역 -->
	
	<c:set  var = "user_dto" value = "${user_cont }"/>
	<c:set var = "order_all" value = "${count }" />
	<c:set var = "order_count" value = "${order }" />
	<c:set var = "refund_count" value = "${refund }" />
	<c:set var = "delivery_count" value = "${delivery }" />
	<c:set var = "delivery_complete_count" value = "${delivery_complete }" />
	
	
	<div id = "mypage_wrap" align = "center"> <!-- 컨텐츠 전체 영역 -->
		<div id = "mypage_category"> <!-- 카테고리 영역 / 이름, 포인트, 카테고리 등 -->
			<div id = "mypage_category_user">
				<div class = "mypage_user_name">${userId }<span>님</span></div>
				<div class = "mypage_user_point">
					<span>잔여 포인트</span> 
					<fmt:formatNumber>
						${user_dto.getUser_point() }
					</fmt:formatNumber>
					<span>점</span>
				</div>
			</div>
			
			<div id = "mypage_select">
			
				<div id = "mypage_sub">
					<span>구독관리</span>
					<img src = "resources/image/sub.png" class = "mypage_icon">
				</div>
				
				<div id = "mypage_order">
					<span>주문내역</span>
					<img src = "resources/image/order.png" class = "mypage_icon">
				</div>
				
				<div id = "mypage_user">
					<span>회원정보</span>
					<img src = "resources/image/user.png" class = "mypage_icon">
				</div>
				
				<div id = "mypage_review">
					<span>리뷰</span>
					<img src = "resources/image/review.png" class = "mypage_icon">
				</div>
				
				<div id = "mypage_delivery">
					<span>배송지관리</span>
					<img src = "resources/image/delivery.png" class = "mypage_icon">
				</div>
				
			</div>
		</div>
		<div id = "mypage_content"> <!-- 컨텐츠 영역 (변경되는 부분) -->
		</div>
	</div>
</div>
</main>
    
    
<script>

let page = 1;

function displayoff(){
	$(".sub_main_wrap").slideUp(500);
	$(".order_main_wrap").slideUp(500);
	$(".refund_main_wrap").slideUp(500);
	$(".review_main_wrap").slideUp(500);
	$(".delivery_main_wrap").slideUp(500);
	$(".user_main_wrap").slideUp(500);
	$(".user_modify_wrap").slideUp(500);
	
	$("#mypage_sub-active").attr("id","mypage_sub");
	$("#mypage_order-active").attr("id","mypage_order");
	$("#mypage_refund-active").attr("id","mypage_refund");
	$("#mypage_review-active").attr("id","mypage_review");
	$("#mypage_delivery-active").attr("id","mypage_delivery");
	$("#mypage_user-active").attr("id","mypage_user");
	$("#mypage_user_modify-active").attr("id","mypage_user_modify");
	
	$("#mypage_content").empty();
	
	loading = false;
}


var loading = false; 
var su = false;
var su2 = false;

// 구독관리 ==============================================================================================================
	
$(document).on("click", "#mypage_sub", function(){
	displayoff();
	$("#mypage_sub").attr("id","mypage_sub-active");
	$('.sub_main_wrap').slideDown(1000);
	
	if(!loading){
		var id = '<%=(String)session.getAttribute("userId")%>';
		
		$.ajax({
		    type : 'get',           // 타입 (get, post, put 등등)
		    url : "<%=request.getContextPath() %>/mypage_sub.do",          // 요청할 서버url
		    dataType : 'json',       // 데이터 타입 (html, xml, json, text 등등)
		    data : {userId : id},
		    success : function(result) { // 결과 성공 콜백함수
		    
		    	var res = '';
		    
		    	if(result == 0){
		    		res = "<div class = sub_main_wrap>" + 
		    				"<div id = 'none_sub'>" + 
		    				"<h3 = 'none_sub_title'>아직 구독을 준비중이에요" + "</h3>" +
		    				"<input type = 'button' value = '구독하기' class = 'sub_btn'>" +
		    				"</div>" + "</div>";
		    	}else {
		    		$.each(result, function(index, item){
				    	
			    		res = "<div class = sub_main_wrap>" + 
			    			"<div id = 'mypage_sub_wrap'>" + "<img src = 'resources/image/loading_new.gif' class = 'mypage_loading'>" +
					    			/* "<div class = 'mypage_sub_pacakge_image'> " + "<img src = 'resources/image/" + item.sub_image + "' class = 'sub_image'>" + "</div>" + */
					    			"<div class = 'mypage_sub_info'>" +
						    			"<div class = 'mypage_sub_packagename'> <span class = 'sub_packagename'>현재 구독중인 패키지</span>" +"「"+ item.sub_package + "」</div>" + "<hr>" +
									"<div class ='sub_package' align = 'center'> <span class = 'package_name'>받아보신 패키지 술</span>" + "<hr>"+
									"<div class = 'sub_drinks'>";
			    		
									$.each(result, function(index, sub_item){
		    							res += "<div class = 'sub_drink'>" + 
										"<img src = 'resources/upload/" + sub_item.product_thumbnail + "' class = 'drink1'>" +
										"<span class = 'drink_name'>" + sub_item.product_name + "</span>" +
										"<span class = 'drick_dosu'>도수 : " + sub_item.product_alcohol + "%</span>" +
									"</div>" ;
	    						});
						res +=
								"</div>" +
								"</div>" +
								"<div class = 'mypage_sub_date'>" + item.sub_end + "<span>이후 새로운 패키지가 발송됩니다. </span> " +"</div>" +
					    		"</div>" +
					    		"</div>";
			    		});
		    	}
		    	
		    	res += "</div>";
		    	$('#mypage_content').append(res);
		    	
		    	// 구독으로 하기로 이동
		    	$(document).on("click",".sub_btn", function() {
		    		location.href = "<%=request.getContextPath() %>/sub.do";					
		    	});
		    	
		    },error : function(request, status, error) { // 결과 에러 콜백함수
		    	
		    }
		    
		}); // ajax 끝
		loading = true;
	}
	
}); // 구독관리 열기 - onclick 끝

$(document).on("click", "#mypage_sub-active", function(){
	$("#mypage_sub-active").attr("id","mypage_sub");
	$(".sub_main_wrap").slideUp(500);
	$("#mypage_content").empty();
	$(".user_main_wrap").slideDown(500);
	loading = false;
}); // 구독관리 닫기 - onclick 끝

// 주문내역 ==============================================================================================================
$(document).on("click", "#mypage_order", function(){
	
	su2 = false;
	
	// ajax창 전체 종료(초기화)
	displayoff();
	
	// 주문 건수 div 추가
	$("#mypage_content").append($("<div class = 'order_category_all'></div>"));
	$(".order_category_all").append($("<div class = 'order_category'></div>"));
	$(".order_category").append($("<div class = 'order_title'> 전체 주문 </div>"));
	$(".order_category").append($("<div class = 'order_count'><span>" + ${count} + "</span>건</div>"));
	
	$(".order_category_all").append($("<div class = 'order_orderall'></div>"));
	$(".order_orderall").append($("<div class = 'order_title'> 주문 완료 </div>"));
	$(".order_orderall").append($("<div class = 'order_count'><span>" + ${order} + "</span>건</div>"));
	
	$(".order_category_all").append($("<div class = 'order_refund_all'></div>"));
	$(".order_refund_all").append($("<div class = 'order_title'> 취 소 </div>"));
	$(".order_refund_all").append($("<div class = 'order_count'><span>" + ${refund } + "</span>건</div>"));
	
	$(".order_category_all").append($("<div class = 'order_delivery_all'></div>"));
	$(".order_delivery_all").append($("<div class = 'order_title'> 배송중 </div>"));
	$(".order_delivery_all").append($("<div class = 'order_count'><span>" + ${delivery} + "</span>건</div>"));
	
	$(".order_category_all").append($("<div class = 'order_delivery_complete_all'></div>"));
	$(".order_delivery_complete_all").append($("<div class = 'order_title'> 배송 완료 </div>"));
	$(".order_delivery_complete_all").append($("<div class = 'order_count'><span>" + ${delivery_complete} + "</span>건</div>"));
	
	page = 1;
	
	$("#mypage_order").attr("id","mypage_order-active");
	$('.order_main_wrap').slideDown(1000)
	
	
	
	if(!loading){
		getorder();
	}
	loading = true;
	
}); // 주문내역 열기 onclick 끝

$(document).on("click", "#mypage_order-active", function(){
	$("#mypage_order-active").attr("id","mypage_order");
	$(".order_main_wrap").slideUp(500);
	$("#mypage_content").empty();
	$(".user_main_wrap").slideDown(500);
	loading = false;
	
}); // 주문내역 닫기 - onclick 끝

// 무한스크롤
$(document).on("scroll", function(){
	
		if($(window).scrollTop()+200>=$(document).height() - $(window).height())
	    {	
	    	
	        if(!loading)    //실행 가능 상태라면?
	        {	if(!su){
	        	if(!su2){
	        		loading = true; //실행 불가능 상태로 변경
		            getorder();
		            $("#none_order").css("display","none");	
	        	}
	        	
	        }
	            
	        }
	    }
});

function getorder(){
	var id = '<%=(String)session.getAttribute("userId")%>';
	
	$.ajax({
	    type : 'get',           // 타입 (get, post, put 등등)
	    url : "<%=request.getContextPath() %>/mypage_order.do",          // 요청할 서버url
	    dataType : 'json',       // 데이터 타입 (html, xml, json, text 등등)
	    data : {userId : id,
	    		page : page},
	    success : function(result) { // 결과 성공 콜백함수
	    	
	    	var res = '';
	    
	    	if(result == 0){
	    		if(su) {
	    			res = "<div class = 'order_main_wrap'>" +
    				"<div id = 'none_order'>" + 
    				"<h3 = 'none_order_title'>주문한 술이 없어요" + "</h3>" +
    				"<input type = 'button' value = '구매하러 가기 >' class = 'order_btn'>" +
    				"</div>";
    				su = true;
	    		}
	    	}else {
	    			
	    		$.each(result, function(index, item){
			    	
		    		res += "<div id = 'order_wrap'>";
	    			res += 		"<div id = 'order_image'>";
	    			res += 			"<img src = 'resources/upload/" + item.product_thumbnail + "' class = 'order_thumbnail'>";
	    			res += 		"</div>"
	    			
	    			res += 		"<div id = 'order_info'>"
	    			res += 			"<div id = 'order_info_date'><span>" + item.order_date + "</span><div id = 'order_info_status'>" + item.order_status + "</div>" + "</div>"
	    			res += 			"<div id = 'order_info_title'>" + item.product_name + "</div>"
	    			res += 			"<div id = 'order_info_alchol'>도수 : " + item.product_alcohol + "%</div>"
	    			res += 			"<div id = 'order_info_amount'>수량 : " + item.order_amount + "개</div>"
	    			res += 			"<div id = 'order_info_price'>" + item.product_price + "원</div>"
					res += 		"</div>"
					res += "</div>"
		    		 
	    	});
	    
	    	// 구독페이지로 이동
	    	$(document).on("click",".order_btn", function() {
	    		location.href = "<%=request.getContextPath() %>/sub.do";					
	    	});
	    	
	    	}
	    	
	    	page += 1;
	    	
	    	
	    	loading = false;
	    	
	    	$('#mypage_content').append(res);
	    	
	    },error : function(request, status, error) { // 결과 에러 콜백함수
	    	/* alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); */
	    }
	    
	}); // ajax 끝
} // 주문내역 ajax 메서드 끝


// 회원 정보 =================================================================================================================
$(document).on("click", "#mypage_user", function(){
	
	// ajax창 전체 종료(초기화)
	displayoff();
	
	$("#mypage_content").append($("<div class = 'user_title'></div>"));
	$(".user_title").append($("<h3>회원 정보</h3>"));

	$("#mypage_user").attr("id","mypage_user-active");
	$('.user_main_wrap').slideDown(1000);
	
	if(!loading){
		getUser();
		loading = true;
	} // if(loading)의 end
	
	}); // 회원정보 열기 - onclick 끝
	
	function getUser(){
		
		var id = '<%=(String)session.getAttribute("userId")%>';
		
		$.ajax({
		    type : 'get',           // 타입 (get, post, put 등등)
		    url : "<%=request.getContextPath() %>/mypage_user.do",          // 요청할 서버url
		    dataType : 'json',       // 데이터 타입 (html, xml, json, text 등등)
		    data : {userId : id},
		    success : function(result) { // 결과 성공 콜백함수
		    	
		    	var res = '';
		    
				   var pwd_count = result.user_pwd.length;
				   var count = ""; 
				   for(var i=1; i<=pwd_count; i++){  
					   count += "*";
					}
			    	 
			    		res = "<div class = user_main_wrap>" +
			    				"<div class ='user_info_top'>" +
				    				"<div class = 'user_name_title'><span>" + result.user_name + "</span>님</div>" +
				    				"<hr>" +
			    				"</div>" +
			    				"<div class = 'user_info_middle'>" +
				    				"<div class = 'user_info_middle_left'>" +
				    					"<div class = 'user_id_title'>아이디" + "</div>" +
				    					"<div class = 'user_name_title'>닉네임" + "</div>" + 
				    					"<div class = 'user_pwd_title'>비밀번호" + "</div>" + 
				    					"<div class = 'user_email_title'>이메일" + "</div>" + 
				    					"<div class = 'user_phone_title'>전화번호" + "</div>" + 
				    				"</div>" +
				    				"<div class = 'user_info_middle_right'>" +
					    				"<div class = 'user_id'>" +result.user_id + "</div>" + 
					    				"<div class = 'user_name'>" + result.user_name + "</div>" +
					    				"<div class = 'user_pwd'>" + count + "</div>" +
					    				"<div class = 'user_email'>" + result.user_email + "</div>" +
					    				"<div class = 'user_phone'>" + result.user_phone1 + " - " + result.user_phone2 + " - " + result.user_phone3 + "</div>" +
				    				"</div>" +
				    			"</div>" +
			    				"<div class = 'user_info_bottom'>" +
			    					"<div class = 'user_modify_btn'>수정</div>" +
			    				"</div>" +
			    			"</div>";

		    	$('#mypage_content').append(res);
		    	
		    	//  수정하기로 이동
		    	$(document).on("click",".user_modify_btn", function() {
		    		
		    		$("#mypage_content").empty();
		    		
		    		res =
		    			"<div class = user_main_wrap>" +
    				"<div class ='user_info_top'>" +
	    				"<div class = 'user_name_title'>개인 정보 수정</div>" +
	    				"<hr style = 'color:yellow;'>" +
    				"</div>" +
    				"<div class = 'user_info_middle'>" +
	    				"<div class = 'user_info_middle_left'>" +
							"<div class = 'user_id_title'>아이디" + "</div>" +
							"<div class = 'user_name_title'>닉네임" + "</div>" + 
							"<div class = 'user_pwd_title'>비밀번호" + "</div>" + 
							"<div class = 'user_pwd_new_title'>수정할 비밀번호" + "</div>" + 
							"<div class = 'user_email_title'>이메일" + "</div>" + 
							"<div class = 'user_phone_title'>전화번호" + "</div>" + 
						"</div>" +
						"<div class = 'user_info_middle_right'>" +
						"<input type ='hidden' value = '" + result.user_pwd + "' class = 'user_dto_pwd'>" +
	    					"<div class = 'user_id'>" + result.user_id + "</div>" + 
	    					"<div class = 'user_name'><input class = 'user_name_input' value = '" +result.user_name + "'></div>" +
	    					"<div class = 'user_pwd'><input type = 'password' class = 'user_pwd_old' placeholder ='기존 비밀번호'></div>" +
	    					"<div class = 'user_pwd_modify'><input type = 'password' class = 'user_pwd_new' placeholder ='새로운 비밀번호' required>" + 
	    					"</div>" +
	    					"<div class = 'user_email'>" + result.user_email + "</div>" +
	    					"<div class = 'user_phone'>" + 
	    					"<input class = 'user_phone1' value = '"+ result.user_phone1 + "'>" + " -" +  
	    					"<input class = 'user_phone2' value = '"+ result.user_phone2 + "'>" + " -" + 
	    					"<input class = 'user_phone3' value = '"+ result.user_phone3 + "'>" + "</div>" +
	    				"</div>" +
    				"</div>" +
    				"<div class = 'user_info_bottom'>" +
    					"<div class = 'user_modifyok_btn'>수정</div>" +
    					"<div class = 'user_modifyCancle_btn' style = 'color:red;'>취소</div>" +
    				"</div>" +
    			"</div>";

				$('#mypage_content').append(res);
				
		    	}); // 수정창 이동 onclick 끝;
		    	
		    },
		    error : function(request, status, error) { // 결과 에러 콜백함수
		    	
		    }
		    
		}); // ajax 끝
		
	}// getUser 메서드의 끝
	
		$(document).on("click",".user_modifyok_btn", function(){
			
			var id = '<%=(String)session.getAttribute("userId")%>';
			
			var user_name_input = $(".user_name_input").val();
			var user_pwd_new = $(".user_pwd_new").val();
			var user_pwd_old = $(".user_pwd_old").val();
			var user_email = $(".user_email").val();
			var user_phone1 = $(".user_phone1").val();
			var user_phone2 = $(".user_phone2").val();
			var user_phone3 = $(".user_phone3").val();
			var user_dto_pwd = $(".user_dto_pwd").val();
			
			console.log("user_email >> " + user_email);
			
			$.ajax({
			    type : 'get',           // 타입 (get, post, put 등등)
			    url : "<%=request.getContextPath() %>/mypage_user_modifyOk.do",          // 요청할 서버url
			    dataType : 'json',       // 데이터 타입 (html, xml, json, text 등등)
			    data : {userId : id,
			    		user_name : user_name_input,
			    		user_pwd_new : user_pwd_new,
			    		user_pwd_old : user_pwd_old,
			    		user_email : user_email,
			    		user_phone1 : user_phone1,
			    		user_phone2 : user_phone2,
			    		user_phone3 : user_phone3,
			    		user_dto_pwd : user_dto_pwd
			    		},
			    success : function(check) {
			    	
			    	if(check>0){
			    		
			    		console.log("check >>> " + check);
			    		
			    			$("#mypage_content").empty();
			    			
			    			getUser();
	    			    	swal('개인정보 수정',"정보가 수정되었습니다.",'success');
	    			    	
			    	}else if(check == -1){
			    		swal('비밀번호 오류',"올바른 비밀번호를 입력해주세요.",'warning');
			    	}else {
			    		swal('개인정보 수정 오류',"정보가 수정되지 않았습니다.",'error');
			    	}
			    
			    },
			    error : function(request, status, error){
			    }
			
		}); // 수정하기 ajax 끝;
			
    }); // 수정하기 onclick 끝;
		    	
$(document).on("click", "#mypage_user-active", function(){
	$("#mypage_user-active").attr("id","mypage_user");
	$(".user_main_wrap").slideUp(500);
	$("#mypage_content").empty();
	loading = false;
}); // 회원정보 닫기 - onclick 끝

$(document).on("click", ".user_modifyCancle_btn", function(){
	$("#mypage_content").empty();
	$("#mypage_content").append($("<div class = 'user_title'></div>"));
	$(".user_title").append($("<h3>회원 정보</h3>"));
	getUser();
});

//비밀번호입력시 - 정규식확인 pw
$(document).on("blur", ".user_pwd_new",function(){
	  var pwd = $('.user_pwd_new').val().trim();
	  
	  	  var num = pwd.search(/[0-9]/g);
		  var eng = pwd.search(/[a-zA-Z]/ig);
		  var spe = pwd.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		
		if(pwd.length < 8 || pwd.length > 20){
		let warningTxt = "<font class = 'checkpwd' color='red' size='1.5em'>8자리 ~ 20자리 이내로 입력해주세요.</font>";
		$(".checkpwd").text('');		// span 태그 영역 초기화
		$(".user_pwd_modify").prepend(warningTxt);
		$(".user_pwd_new").text('');
		swal('비밀번호 오류',"8자리 ~ 20자리 이내로 입력해주세요.",'warning');
		
	 }else if(num < 0 || eng < 0 || spe < 0 ){
		 
	  	let warningTxt = "<font class = 'checkpwd' color='red' size='1.5em'>영문, 숫자, 특수문자를 혼합하여 입력해주세요.</font>";
		$(".checkpwd").text('');		// span 태그 영역 초기화
		$(".user_pwd_modify").prepend(warningTxt);
		$(".user_pwd_new").text('');
		swal('비밀번호 오류',"영문, 숫자, 특수문자를 혼합하여 입력해주세요.",'warning');
		
	 }else {
		 
		let warningTxt = "<font class = 'checkpwd' color='green' size='1.5em'>사용 가능한 비밀번호 입니다.</font>";
		$(".checkpwd").text('');		// span 태그 영역 초기화
		$(".user_pwd_modify").prepend(warningTxt);
		swal('비밀번호 수정',"사용 가능한 비밀번호 입니다.",'success');
		
	 }
	});  //비밀번호입력시 - 정규식확인 pw end
	
	

// 리뷰관리 ==============================================================================================================
	
	$(document).on("click", "#mypage_review", function(){
		
		// ajax창 전체 종료(초기화)
		displayoff();
		
		page = 1;
		
		$("#mypage_review").attr("id","mypage_review-active");
		$('.review_main_wrap').slideDown(1000)
		
		if(!loading){
			getreview();
		}
		loading = true;
		
	}); // 리뷰관리 열기 onclick 끝

	$(document).on("click", "#mypage_review-active", function(){
		$("#mypage_review-active").attr("id","mypage_review");
		$(".review_main_wrap").slideUp(500);
		$("#mypage_content").empty();
		$(".review_main_wrap").slideDown(500);
		loading = false;
		
	}); // 리뷰관리 닫기 - onclick 끝

	// 무한스크롤
	$(document).on("scroll", function(){
		
			if($(window).scrollTop()+200>=$(document).height() - $(window).height())
		    {	
		    	
		        if(!loading)    //실행 가능 상태라면?
		        {	if(!su){
		        	if(su2){
		        		loading = true; //실행 불가능 상태로 변경
			            getreview();
			            $("#none_review").css("display","none");	
		        	}
		        	
		        }
		            
		        }
		    }
	});

	function getreview(){
		var id = '<%=(String)session.getAttribute("userId")%>';
		
		$.ajax({
		    type : 'get',           // 타입 (get, post, put 등등)
		    url : "<%=request.getContextPath() %>/mypage_review.do",          // 요청할 서버url
		    dataType : 'json',       // 데이터 타입 (html, xml, json, text 등등)
		    data : {userId : id,
		    		page : page},
		    success : function(result) { // 결과 성공 콜백함수
		    	
		    	var res = '';
		    
		    	if(result == 0){
		    		if(review_su) {
		    			res = "<div class = 'review_main_wrap'>" +
	    				"<div id = 'none_review'>" + 
	    				"<h3 = 'none_review_title'>작성한 리뷰가 없어요" + "</h3>" +
	    				"<input type = 'button' value = '리뷰 쓰기' class = 'review_btn'>" +
	    				"</div>";
	    				su = true;
		    		}
		    	}else {
		    			
		    		$.each(result, function(index, item){
				    	
			    		res += "<div id = 'review_wrap'>";
		    			res += 		"<div id = 'review_image'>";
		    			res += 			"<img src = 'resources/upload/" + item.review_file + "' class = 'review_thumbnail'>";
		    			res += 		"</div>"
		    			
		    			res += 		"<div id = 'review_info'>"
		    			res += 			"<div id = 'review_info_date'><span>" + item.review_date + "</span></div>"
		    			res += 			"<div id = 'review_info_title'>" + item.review_title + "</div>"
		    			res += 			"<div id = 'review_info_cont'>" + item.review_cont + "</div>"
		    			res += 			"<div id = 'review_info_cont'>" + item.product_name + "</div>"
		    			res += 			"<div id = 'review_info_product_amount'>" + item.product_amount + "ml</div>"
		    			res += 			"<div id = 'review_info_star'>" + item.review_star + "</div>"
						res += 		"</div>"
						res += "</div>"
			    		 
		    	});
		    
		    	// 구독페이지로 이동
		    	$(document).on("click",".review_btn", function() {
		    		location.href = "<%=request.getContextPath() %>/review_write.do";					
		    	});
		    	
		    	}
		    	
		    	page += 1;
		    	
		    	
		    	loading = false;
		    	su2 = true;
		    	
		    	$('#mypage_content').append(res);
		    	
		    },error : function(request, status, error) { // 결과 에러 콜백함수
		    	alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
		    }
		    
		}); // ajax 끝
	} // 리뷰관리 ajax 메서드 끝
	
	
	
	
	// 배송지 관리 ==============================================================================================================
	
	$(document).on("click", "#mypage_delivery", function(){
		displayoff();
		$("#mypage_delivery").attr("id","mypage_delivery-active");
		$('.delivery_main_wrap').slideDown(1000);
		
		if(!loading){
			var id = '<%=(String)session.getAttribute("userId")%>';
			
			$.ajax({
			    type : 'get',           // 타입 (get, post, put 등등)
			    url : "<%=request.getContextPath() %>/mypage_delivery.do",          // 요청할 서버url
			    dataType : 'json',       // 데이터 타입 (html, xml, json, text 등등)
			    data : {userId : id},
			    success : function(result) { // 결과 성공 콜백함수
			    
			    	var res = '';
			    
			    	if(result == 0){
			    		res = "<div class = delivery_main_wrap>" + 
			    				"<div id = 'none_delivery'>" + 
			    				"<h3 = 'none_delivery_title'>등록된 배송지가 없어요" + "</h3>" +
			    				"<input type = 'button' value = '등록하기' class = 'delivery_btn'>" +
			    				"</div>" + "</div>";
			    	}else {
			    		$.each(result, function(index, item){
					    	
				    		res += "<div id = 'delivery_wrap'>"
			    			res += 		"<div id = 'delivery_user_id'>"
			    			res += 			item.user_id;
			    			res += 		"</div>"
			    			
			    			res += 		"<div id = 'delivery_info'>"
s			    			res += 			"<div id = 'delivery_info_zipcode'>" + item.deli_zipcode + "</div>"
			    			res += 			"<div id = 'delivery_info_addr1'>" + item.deli_addr1 + "</div>"
			    			res += 			"<div id = 'delivery_info_addr2'>" + item.deli_addr1 + "</div>"
							res += 		"</div>"
							res += "</div>"
			    	});
			    	}
			    	
			    	res += "</div>";
			    	$('#mypage_content').append(res);
			    	
			    	// 배송지 등록하기로 이동
			    	$(document).on("click",".delivery_btn", function() {
			    		location.href = "<%=request.getContextPath() %>/delivery_insert.do";					
			    	});
			    	
			    },error : function(request, status, error) { // 결과 에러 콜백함수
			    	
			    }
			    
			}); // ajax 끝
			loading = true;
		}
		
	}); // 구독관리 열기 - onclick 끝

	$(document).on("click", "#mypage_delivery-active", function(){
		$("#mypage_delivery-active").attr("id","mypage_delivery");
		$(".delivery_main_wrap").slideUp(500);
		$("#mypage_content").empty();
		$(".user_main_wrap").slideDown(500);
		loading = false;
	}); // 구독관리 닫기 - onclick 끝


</script>
<jsp:include page="../banner/bottom.jsp" />
