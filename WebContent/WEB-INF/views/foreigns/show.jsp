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


            <div id="map"></div>
            <!-- 地図を表示する div 要素（id="map"）-->
            <script>
                var map;
                function initMap() {
                    map = new google.maps.Map(document.getElementById('map'), {
                        center : {
                            lat : <c:out value="${foreign.lat}" />,
                            lng : <c:out value="${foreign.lng}" />
                        },
                        zoom : 8
                    });
                }
            </script>
            <script
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBPiYYC9GRrpemqgmat65d5RXu_V3ZcQDc&callback=initMap"
                async defer></script>


        <p>
            あらすじ<br />
            <c:out value="${foreign.contents}" />
        </p>

        <p>
            <a href="${pageContext.request.contextPath}/index">一覧に戻る</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/edit?id=${foreign.id}">編集</a>
        </p>

    </c:param>
</c:import>