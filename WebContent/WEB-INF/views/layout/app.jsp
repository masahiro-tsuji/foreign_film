<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>海外ドラマ・映画の撮影場所</title>
<link rel="stylesheet" href="<c:url value='/css/reset.css' />">
<link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <div id="header">
                <h1>海外ドラマ・映画の撮影場所</h1>
            </div>
            <div id="title">${param.title}</div>
            <div id="contents">${param.contents}</div>
            <div id="footer">by kinak</div>
        </div>
    </div>
</body>
</html>