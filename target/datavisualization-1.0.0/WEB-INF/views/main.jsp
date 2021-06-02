<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div id="Contents">
  <style>
    body {
      margin: 0;
    }
    .scene {
      height: 100vh;
      overflow: hidden;
      background-attachment: fixed;
      background-size: cover;
      font-family: "Source Sans Pro", sans-serif;
      font-weight: 200;
    }
    .scene.one {
      background-image: url("${pageContext.request.contextPath}/resources/img/bg1.jpg");
    }
    .scene.two {
      background-image: url("${pageContext.request.contextPath}/resources/img/bg2.jpg");
    }
    .scene.three {
      background-image: url("${pageContext.request.contextPath}/resources/img/bg3.jpg");
    }
    .scene.four {
      background-image: url("${pageContext.request.contextPath}/resources/img/bg4.jpg");
    }
    .scene.five {
      background-image: url("${pageContext.request.contextPath}/resources/img/bg5.jpg");
    }
    .scene.six {
      background-image: url("${pageContext.request.contextPath}/resources/img/bg6.jpg");
    }
    .scene header {
      color: white;
      max-width: 80%;
      position: relative;
      left: 50%;
      top: 50%;
      transform: translateX(-50%) translateY(-50%);
      font-size: 1.5rem;
      text-align: center;
    }
    .scene header h1 {
      font-size: 2rem;
      margin-bottom: 1rem;
      font-weight: 300;
    }
    .scene header h1:after {
      content: "";
      border-bottom: 1px solid white;
      width: 8rem;
      display: block;
      margin: 0 auto;
      margin-top: 1rem;
    }
  </style>

  <section class="scene one">
    <header>
      <h1>SejongTelecom Query Util</h1>
    </header>
  </section>
  <section class="scene two">
    <header>
    </header>
  </section>
  <section class="scene three">
    <header>
    </header>
  </section>
  <section class="scene four">
    <header>

    </header>
  </section>
  <section class="scene five">
    <header>

    </header>
  </section>
  <section class="scene six">
    <header>

    </header>
  </section>
</div>
