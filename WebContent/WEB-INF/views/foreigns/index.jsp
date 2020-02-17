<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="contents">
        <h2>ドラマ・映画一覧</h2>
        <ul>
            <c:forEach var="foreign" items="${foreigns}">
                <li><a
                    href="${pageContext.request.contextPath}/show?id=${foreign.title}">
                        <c:out value="${foreign.title}" />
                </a>>><c:out value="${foreign.location}"></c:out></li>
            </c:forEach>
        </ul>

        <p>
            <a href="${pageContext.request.contextPath}/new">新規投稿</a>
        </p>
    </c:param>
</c:import>