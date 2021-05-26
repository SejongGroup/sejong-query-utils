<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@ page isELIgnored="false" %>

        <div id="Contents">
          <link href="${pageContext.request.contextPath}/resources/css/util.css" rel="stylesheet" type="text/css" />
          <div class="container util-page form">
            <a href="javascript:getAjaxNodate('./query/create')"> 쿼리생성 </a>
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                </tr>
              </thead>
              <c:if test="${data.query2 != null}">
                <c:forEach items="${data.query2}" var="row">
                  <tr>
                    <td>
                      <c:out value="${row.sequence}" />
                    </td>
                    <td>
                      <a href="javascript:getAjaxNodate('./query/view?sequence=${row.sequence}')">
                        <c:out value="${row.title}" />
                      </a>
                    </td>
                    <td>
                      <c:out value="${row.userId}" />
                    </td>
                  </tr>
                </c:forEach>
              </c:if>
            </table>
          </div>
        </div>