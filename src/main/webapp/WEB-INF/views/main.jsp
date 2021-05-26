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
      background-image: url("https://unsplash.it/1600/846?image=512");
    }
    .scene.two {
      background-image: url("https://unsplash.it/1600/846?image=656");
    }
    .scene.three {
      background-image: url("https://unsplash.it/1600/846?image=576");
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
      <h1>Lorem ipsum dolor sit amet.</h1>
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Totam suscipit
      sint ab beatae nihi
    </header>
  </section>
  <section class="scene two">
    <header>
      <h1>Lorem ipsum dolor sit amet.</h1>
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Totam suscipit
      sint ab beatae nihi
    </header>
  </section>
  <section class="scene three">
    <header>
      <h1>Lorem ipsum dolor sit amet.</h1>
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Totam suscipit
      sint ab beatae nihi
    </header>
  </section>
</div>
