<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>

<style>
	table#tbl-dev{   //demo--> dev로 수정
		margin:0 auto;
		width:50%;
	}
   </style>
	<table class="table" id="tbl-dev">
		<tr>
			<th scope="col">이름</th>
			<td><c:out value="${dev.devName }"/></td>
		</tr>
		<tr>
			<th scope="col">나이</th>
			<td><c:out value="${dev.devAge }"/></td>
		</tr>
		<tr>
			<th scope="col">이메일</th>
			<td><c:out value="${dev.devEmail }"/></td>
		</tr>
		<tr>
			<th scope="col">성별</th>
			<td><c:out value="${dev.devGender=='M' ? '남' : '여' }"/></td>
		</tr>
		<tr>
			<th scope="col">개발 언어</th>
			<td>
				<c:forEach var="lang" items="${dev.devLang }" varStatus="status">
					<c:out value='${status.index != 0 ? ", " : "" } ${lang }'/>
				</c:forEach>
			</td>
		</tr>
	</table>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>