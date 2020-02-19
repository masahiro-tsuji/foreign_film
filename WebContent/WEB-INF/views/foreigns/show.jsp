<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="contents">
        <p>
            <c:out value="${foreign.title}" />
        </p>
        <p>
            撮影場所：
            <c:out value="${foreign.location}" />
        </p>
        <p>
            <c:out value="${foreign.lat}" />
        </p>
        <p>
            <c:out value="${foreign.lng}" />
        </p>
        <p>
            あらすじ<br/>
            <c:out value="${foreign.contents}" />
        </p>

        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>
        <p><a href="${pageContext.request.contextPath}/edit?id=${foreign.id}">削除</a></p>

    </c:param>
</c:import>