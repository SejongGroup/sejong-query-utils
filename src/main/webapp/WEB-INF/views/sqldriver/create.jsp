<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@ page isELIgnored="false" %>

        <div id="Contents">
          <link href="${pageContext.request.contextPath}/resources/css/util.css" rel="stylesheet" type="text/css" />
          <section id="section-form-parrent">
            <div class="container util-page form2">
              <h4>데이터베이스 드라이버 생성</h4>
            </div>
            <form id="tmpSendFrm_0" class="container util-page form" method="post">
              <div class="mb-3 post-content">
                <label class="form-label highlighter-rouge">url</label>
                <textarea name="databaseurl" id="title" class="form-control input-size-up" cols="30" rows="1"></textarea>
                <br />
                <label class="form-label highlighter-rouge">아이디</label>
                <textarea name="databaseid" id="title" class="form-control input-size-up" cols="30" rows="1"></textarea>
                <br />
                <label class="form-label highlighter-rouge">패스워드</label>
                <textarea name="databasepw" id="title" class="form-control input-size-up" cols="30" rows="1"></textarea>
                <br />
                <button type="button" class="btn btn-primary btn-size-up"
                  onclick="postAjax($('#' + $(this).closest('div').closest('div').closest('form').attr('id')), './sqldriver/submit?responseType=html')">Submit</button>
            </form>
            </section>
        </div>