<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@	page import="com.kh.spring.demo.model.vo.Dev, java.util.*" %>   
<%
	Dev dev = (Dev)request.getAttribute("dev");
%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>

<style>
	div#demo-container{
		width:40%;
		padding:15px;
		margin:0 auto;
		border:1px solid lightgray;
		border-radius: 10px;
   }
	input[type="number"]::-webkit-outer-spin-button,
	input[type="number"]::-webkit-inner-spin-button {
    	-webkit-appearance: none;
    	margin: 0;
	}
</style>


<div id="demo-container">
	<form id="devFrm">
		<div class="form-group row">
			<label for="devName" class="col-sm-2 col-form-label">이름</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="devName" name="devName" value="${dev.devName }"/>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="devAge" class="col-sm-2 col-form-label">나이</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="devAge" name="devAge" value="${dev.devAge }"/>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="devEmail" name="devEmail" value="${dev.devEmail }"/>
			</div>
		</div>
	
		<div class="form-group row">
			<label for="devGender" class="col-sm-2 col-form-label">성별</label>
			<div class="col-sm-10">
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" id="devGender0" name="devGender" value="M" <%=dev.getDevGender().equals("M") ? "checked" : "" %>/>
					<label class="form-check-label" for="devGender0">남</label>
					<input class="form-check-input" type="radio" id="devGender1" name="devGender" value="F" <%=dev.getDevGender().equals("F") ? "checked" : "" %>/>
					<label class="form-check-label" for="devGender1">여</label>
				</div>
			</div>
		</div>
		
		<div class="form-group row">
				<label class="col-sm-2 col-form-label">개발언어</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" name="devLang" 
						id="Java" value="Java" <%=Arrays.asList(dev.getDevLang()).contains("Java") ? "checked" : "" %>/>
						<label class="form-check-label" for="devLang0">자바</label>
						<input class="form-check-input" type="checkbox" name="devLang" 
						id="C" value="C" <%=Arrays.asList(dev.getDevLang()).contains("C") ? "checked" : "" %>/>
						<label class="form-check-label" for="devLang1">C</label>
						<input class="form-check-input" type="checkbox" name="devLang" 
						id="JavaScript" value="JavaScript" <%=Arrays.asList(dev.getDevLang()).contains("JavaScript") ? "checked" : "" %>/>
						<label class="form-check-label" for="devLang2">자바스크립트</label>
					</div>
				</div>
			</div>	
		
		<div class="list-group">
			<input type="hidden" name="devNo" value="${dev.devNo }"/>
			<button type="button" onclick="fn_update();" class="list-group-item list-group-item-action" style="text-align:center;">수정</button>	
		</div>
	</form>
</div>

<script>
	function fn_update(){
		$('#devFrm').attr("action","${path}/demo/updateDevEnd.do");
		$('#devFrm').attr("method","post");
		$('#devFrm').submit();
	}
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>