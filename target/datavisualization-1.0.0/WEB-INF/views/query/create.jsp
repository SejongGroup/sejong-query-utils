<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@ page isELIgnored="false" %>

        <div id="Contents">
          <link href="${pageContext.request.contextPath}/resources/css/util.css" rel="stylesheet" type="text/css" />
          <sectio id="section-form-parrent">
            <div class="container util-page form2">
              <h4>쿼리 생성</h4>
              <a href="javascript:addForm()">추가하기</a>
              <a href="javascript:removeForm()">삭제하기</a>
              <a href="javascript:saveForm()">저장하기</a>
            </div>
            <form id="tmpSendFrm_0" class="container util-page form" method="post">
              <div class="mb-3 post-content">
                <label for="exampleInputEmail1" class="form-label highlighter-rouge">제목</label>
                <textarea name="title" id="title" class="form-control input-size-up" cols="30" rows="1"></textarea>
                <br />
                <label for="exampleInputEmail1" class="form-label highlighter-rouge">데이터베이스 URL</label><br>
                <select name="databaseurl" id="databaseurl">
                	
                </select>
                <br />
                <label for="exampleInputEmail1" class="form-label highlighter-rouge">쿼리문</label>
                <textarea name="query" id="query" class="form-control input-size-up" cols="30" rows="4"></textarea>
                <br />
                <div class="mb-3 post-content">
                  <label for="exampleInputPassword1" class="form-label highlighter-rouge">파라미터 값(?, ?, ?, ?)</label>
                  <textarea name="param" id="param" class="form-control input-size-up" cols="30" rows="1"></textarea>
                </div>
                <div class="mb-3 post-content">
                  <label for="exampleInputEmail1" class="form-label highlighter-rouge">결과 값</label>
                  <div id="result" >
                  </div>
                  <br>
                  <div class="center">
                    <button type="button" class="btn btn-primary btn-size-up"
                      onclick="postAjax_test($('#' + $(this).closest('div').closest('div').closest('form').attr('id')), './query/submit?responseType=html')">Submit</button>
            </form>
            </section>
            <script>
              $(function () {
                /* db url 추가 */
                <c:forEach var="list" items="${data.sqldriver}">
                	console.log("gdgD")
                	var option = "<option>" + '<c:out value="${list.databaseurl}" />' + "</option>"
                	$(databaseurl).append(option)
                	console.log('<c:out value="${list.databaseurl}" />')
                </c:forEach>
            	  
            	  
                let query = '<c:out value="${data.query2[0]}" />';
                let sqldriver = '<c:out value="${data.sqldriver}" />';
                
                let param = '';
                if (query != null) {
                  query = escapeParsr('<c:out value="${data.query2[0].query}" />');
                  param = escapeParsr('<c:out value="${data.query2[0].param}" />');
                  $('#title').text(escapeParsr('<c:out value="${data.query2[0].title}" />'));
                } else {
                  return;
                }

                /* 쿼리문과 param문을 각각의 배열에 넣어준다 */
                let queryCount = stringCount(query);
                let queryArray = query.split('!@#')
                let paramArray = param.split('!@#');

                /* 먼저 객체 하나만 선택해서 넣어준다 */
                var forms = $('#section-form-parrent').children('form');
                $("textarea[name=query]").text(dbTostr(queryArray[0]));
                $("textarea[name=param]").text(dbTostr(paramArray[0]));

                /* 값이 여러개 있으면 추가해서 넣어준다. */
                if (queryCount >= 2) {
                  for (let index = 1; index < queryCount; index++) {
                    current_form_id = addForm();
                    console.log(queryArray[index])
                    console.log($(current_form_id))
                    $(current_form_id).find('#query').text(dbTostr(queryArray[index]));
                    $(current_form_id).find('#param').text(dbTostr(paramArray[index]));
                  }
                }
            
              });

              function stringCount(text) {
                let searchChar = '!@#'
                let pos = text.indexOf(searchChar);
                var count = 0;
                while (pos !== -1) {
                  count++;
                  pos = text.indexOf(searchChar, pos + 1); // 첫 번째 a 이후의 인덱스부터 a를 찾습니다.
                }
                return count;
              }

              function escapeParsr(a) {
                var b = '';

                b = a.replace(/&lt;/g, '<');
                b = b.replace(/&gt;/g, '>');
                b = b.replace(/&nbsp;/g, ' ');
                b = b.replace(/&amp;/g, '&');
                b = b.replace(/&quot;/g, '"');
                b = b.replace(/&#039;/g, '\'');

                return b;
              }

              function strTodb(str) {
                var new_str = '';
                new_str = str.replace(/(?:\r\n:\r|\n)/gi, '<br />');
                new_str = new_str.replace(/,/g, '&fancy');
                return new_str;
              }

              function dbTostr(str) {
                var new_str = '';
                new_str = str.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
                new_str = new_str.replace(/&fancy/g, ',');
                return new_str;
              }

              function saveForm() {
                var forms = $('#section-form-parrent').children('form');
                var userId = '<c:out value="${data.member.userId}" />';
                var query_sequence = '<c:out value="${data.query[0].sequence}" />';
                var query = [];
                var param = [];
                var title = $('#title').val();

                console.log(title)

                if (typeof query_sequence != Number && !query_sequence) {
                  query_sequence = '<c:out value="${data.query2[0].sequence}" />';
                }


                $(forms).each(function (index, item) {

                  var client_query = $(item).find('#query').val();
                  var client_param = $(item).find('#param').val();
                  console.log(client_query);
                  query[index] = strTodb(client_query);
                  console.log(query[index]);
                  param[index] = strTodb(client_param);
                });

                $.post("./query/createaction", {
                  'sequence': query_sequence,
                  'userId': userId,
                  'title': title,
                  'query': query,
                  'param': param
                },
                
                  function (data) {
                    alert("success");
                    $('#Contents').children().remove();
                    // Contents 영역 교체
                    $('#Contents').html(data);
                    console.log(data);
                  });
              }
            </script>
        </div>