<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

      <!DOCTYPE html>
      <html>

      <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <title>Insert title here</title>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"
          type="text/css" />
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
        <link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css" />
      </head>

      <body>
        <header id="header">
          <!-- <nav id="navi">
            <h1>
              <a href="javascript:getAjaxNodate('./main')">
                <img src="${pageContext.request.contextPath}/resources/img/logo_sejong.png" />
              </a>
            </h1>
            <ul class="main-nav">
              <li><a href="javascript:getAjaxNodate('./main')">세종텔레콤</a></li>
              <li><a href="javascript:getAjaxNodate('./info')">서비스소개</a></li>
              <li>
                <a href="javascript:getAjax('./board/freeboard')">자유게시판</a>
              </li>
              <li><a href="#">자주하는답변</a></li>
              <li><a href="javascript:getAjaxNodate('./login')">회원사이트</a></li>
            </ul>
          </nav> -->

          <nav>
            <ul>
              <li><a href="javascript:getAjaxNodate('./main')">세종텔레콤</a></li>
              <li><a href="javascript:getAjaxNodate('./info')">서비스소개</a></li>
              <li><a href="javascript:getAjax('./board/freeboard')">자유게시판</a></li>
              <li><a href="#">자주하는답변</a></li>
              <li><a href="javascript:getAjaxNodate('./login')">회원사이트</a></li>
            </ul>
            <a href="#" id="trigger">MENU</a>
          </nav>
        </header>