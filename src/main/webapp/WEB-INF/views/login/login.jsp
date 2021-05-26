<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <div id="Contents">
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css" />
    <div id="Contents" class="login-page">
      <div class="login-page">
        <div class="form">
          <div class="login-form">
            <form id="tmpSendFrm" method="post">
              <input type="text" name="responseType" value="html" hidden="true" />
              <input type="text" name="userId" />
              <input type="password" name="userPw" />
              <button type="button" onclick="postAjax($('#tmpSendFrm'), './login/action?responseType=html')">
                버튼
              </button>
            </form>
            <p class="message"><a href="javascript:getAjaxNodate('./login/register')">회원가입</a></p>
          </div>
        </div>
      </div>
    </div>
    <!-- 
    <div id="Contents">
      <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css" />
      <div class="login-page">
        <div class="form">
          <form class="register-form">
            <input type="text" name="responseType" value="html" hidden="true" />
            <input type="text" placeholder="name" name="userId" />
            <input type="password" placeholder="password" name="userPw" />
            <input type="text" placeholder="email address" />
            <button>create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
          </form>
          <form class="login-form">
            <input type="text" name="responseType" value="html" hidden="true" />
            <input type="text" placeholder="username" name="userId" />
            <input type="password" placeholder="password" name="userPw" />
            <button type="button"
              onclick="postAjax($('#tmpSendFrm'), './login/action?responseType=html')">login</button>
            <p class="message">Not registered? <a href="#">Create an account</a></p>
          </form>
        </div>
      </div>
    </div> -->
  </div>