<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:include page="./index.jsp" />--%>
<%@include file="home.html"%>

<spring:url value="/resources/js/app.js" var="Functions" />
<spring:url value="/resources/js/collection/userCollection.js" var="UserCollection"/>
<spring:url value="resources/js/view/HomePage.js" var="homeView"/>
<spring:url value="/resources/js/view/Login.js" var="loginView"/>
<spring:url value="/resources/js/view/Registration.js" var="registrationView"/>
<spring:url value="/resources/js/model/UserModel.js" var="User"/>

<script src="${Functions}"></script>
<script src="${UserCollection}"></script>
<script src="${homeView}"></script>
<script src="${loginView}"></script>
<script src="${registrationView}"></script>
<script src="${User}"></script>