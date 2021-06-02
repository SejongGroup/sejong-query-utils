<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			<%@ page isELIgnored="false" %>

				<div id="Contents">
					<link href="${pageContext.request.contextPath}/resources/css/util.css" rel="stylesheet"
						type="text/css" />
					<section class="post-full-content">
						<div class="post-title util-page form2">
							<h3>글수정</h3>
						</div>
						<form id="tmpSendFrm" class="util-page form2" method="post">
							<div class="mb-3 post-content">
								<label for="exampleInputEmail1" class="form-label highlighter-rouge">BNO</label>
								<c:out value="${data.board[0].bno}" />
								<input type="text" name="bno" value="${data.board[0].bno}" hidden="true">
								<br>
							</div>
							<div class="mb-3 post-content">
								<label for="exampleInputPassword1" class="form-label highlighter-rouge">Title</label>
								<input type="text" class="form-control input-size-up" name="title"
									value="${data.board[0].title}">
							</div>
							<div class="mb-3 post-content">
								<label for="exampleInputEmail1" class="form-label highlighter-rouge">Content</label>
								<input type="text" class="form-control input-size-up" name="content"
									value="${data.board[0].content}">
								<br>
							</div>
							<div class="mb-3 post-content">
								<label for="exampleInputPassword1" class="form-label highlighter-rouge">Writer</label>
								<c:out value="${data.board[0].writer}" />
							</div>
							<div class="mb-3 post-content">
								<label for="exampleInputEmail1" class="form-label highlighter-rouge">RegDate</label>
								<input type="text" class="form-control input-size-up" name="regdate">
								<br>
							</div>
							<div class="center">
								<button type="button" class="btn btn-primary btn-size-up"
									onclick="postAjax($('#tmpSendFrm'), './board/freeboard/modify?responseType=html')">modify</button>
								<button type="button" class="btn btn-primary btn-size-up"
									onclick="postAjax($('#tmpSendFrm'), './board/freeboard/delete?responseType=html')">delete</button>
							</div>
							<br>
						</form>
						<br>
					</section>
				</div>