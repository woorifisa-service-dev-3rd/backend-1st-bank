<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
    <table>
       <tr>
          <th>계좌 아이디</th>
          <th>계좌번호</th>
          <th>계좌 타입</th>
          <th>계좌 잔액</th>
       </tr>

       <c:choose>
          <c:when test="${empty requestScope.accountList || fn:length(accountList) == 0}">
             <tr>
                <td>등록된 계좌 정보가 없습니다.</td>
             </tr>
          </c:when>
          <c:otherwise>
             <c:forEach items="${requestScope.accountList}" var="account">
                <tr>
                   <td>${account.id}</td>
                   <td>${account.number}</td>
                   <td>${account.type}</td>
                   <td>${account.total_money}</td>
                </tr>
             </c:forEach>
          </c:otherwise>
       </c:choose>

    </table>
</body>
</html>