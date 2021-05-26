<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<div id="wrap">
		<!-- 공통 헤더 부분 -->
		<%@ include file="./include/header.jsp" %>
		
		<!-- 내용 부분 -->
		<div id="Contents">
			<script type="text/javascript">
			window.onload=function() {
				getAjaxNodate('./main')
			}
			</script>
		</div>
		
	<!-- 공통 푸터 부분 -->
	<%@ include file="./include/footer.jsp" %>
