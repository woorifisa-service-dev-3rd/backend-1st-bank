<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>은행 선택</title>
</head>
<body>
    <h1>이체기능</h1>
    <form action="bank" method="POST">
        <p>은행을 선택해주세요</p>
        <input type="radio" id="hana" name="bankId" value="1">
        <label for="hana">하나은행</label><br>
        
        <input type="radio" id="shinhan" name="bankId" value="2">
        <label for="shinhan">신한은행</label><br>
        
        <input type="radio" id="woori" name="bankId" value="3">
        <label for="woori">우리은행</label><br>
        
        <input type="radio" id="kookmin" name="bankId" value="4">
        <label for="kookmin">국민은행</label><br>
        
        <input type="radio" id="nonghyup" name="bankId" value="5">
        <label for="nonghyup">농협</label><br>
        
        <button type="submit">선택</button>
    </form>
</body>
</html>