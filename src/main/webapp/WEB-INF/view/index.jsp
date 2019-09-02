<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:include page="./index.jsp" />--%>

<%@include file="./index.html" %>

<spring:url value="/resources/view/RegisterView.js" var="RegView" />
<spring:url value="/resources/model/UserModel.js" var="UserModel" />
<spring:url value="/resources/model/AuthModel.js" var="AuthModel" />
<spring:url value="/resources/view/LoginView.js" var="LoginView" />

<script src="${RegView}"></script>
<script src="${UserModel}"></script>
<script src="${AuthModel}"></script>
<script src="${LoginView}"></script>

