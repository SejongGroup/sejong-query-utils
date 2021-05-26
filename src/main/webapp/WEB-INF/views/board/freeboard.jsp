<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			<%@ page isELIgnored="false" %>

				<div id="Contents">
					<link href="${pageContext.request.contextPath}/resources/css/util.css" rel="stylesheet"
						type="text/css" />
					<div class="container util-page form2">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>이름</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>
							<c:forEach items="${data.board}" var="row">
								<tr>
									<td>
										<c:out value="${row.bno}" />
									</td>
									<td><a href="javascript:getAjaxNodate('./board/freeboard/view?bno=${row.bno}')">
											<c:out value="${row.title}" />
										</a></td>
									<td>
										<c:out value="${row.writer}" />
									</td>
									<td>
										<fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
									</td>

									<td>
										<c:out value="${row.viewcount}" />
									</td>
								</tr>

							</c:forEach>
						</table>
						<br>
						<a href="javascript:getAjaxNodate('./board/freeboard/write')"
							class="btn btn-default pull-right">글쓰기</a>
					</div>
				</div>