<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@ page isELIgnored="false" %>


        <div id="Contents" class="login-page">
          <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css" />
          <div class="register-form">
            <div class="form">

              <form id="tmpSendFrm" method="post">
                <div class="mb-3 post-content">
                  <label for="exampleInputEmail1" class="form-label highlighter-rouge">아이디</label>
                  <input type="text" class="form-control input-size-up" name="userId" />
                </div>
                <div class="mb-3 post-content">
                  <label for="exampleInputPassword1" class="form-label highlighter-rouge">패스워드</label>
                  <input type="password" class="form-control input-size-up" name="userPw" />
                </div>
                <div class="mb-3 post-content">
                  <label for="exampleInputEmail1" class="form-label highlighter-rouge">이메일</label>
                  <input type="email" class="form-control input-size-up" name="userEmail" />
                </div>
                <div class="mb-3 post-content">
                  <label for="exampleInputPassword1" class="form-label highlighter-rouge">핸드폰번호</label>
                  <input type="text" class="form-control input-size-up" name="phoneNumber" />
                </div>
                <div class="center">
                  <button type="button" class="btn btn-primary btn-size-up"
                    onclick="postAjax($('#tmpSendFrm'), './login/registeraction?responseType=html')">
                    Submit
                  </button>


              </form>
            </div>
          </div>
        </div>