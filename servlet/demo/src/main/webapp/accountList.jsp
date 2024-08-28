<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Selection</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
</head>
<body>
    <h2>계좌 선택</h2>
    <!-- Form 시작 -->
    <form action="accountList" method="POST">
        <table>
            <tr>
                <th>번호</th>
                <th>계좌번호</th>
                <th>잔액</th>
                <th>선택</th>
            </tr>

            <c:choose>
                <c:when test="${empty requestScope.accountList || fn:length(accountList) == 0}">
                    <tr>
                        <td colspan="4">해당 은행에 등록된 계좌 정보가 없습니다.</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${requestScope.accountList}" var="account" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${account.number}</td>
                            <td>${account.total_money}</td>
                            <td><input type="radio" name="acountIndex" value="${status.index + 1}"></td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </table>
        <!-- 폼 제출 버튼 -->
        <button type="submit">계좌 선택</button>
    </form>
    <!-- Form 종료 -->
</body>
</html>
