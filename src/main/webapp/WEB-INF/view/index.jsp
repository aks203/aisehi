<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:include page="./index.jsp" />--%>

<%@include file="./index.html" %>

<spring:url value="/resources/view/RegisterView.js" var="RegView" />
<spring:url value="/resources/model/BookModel.js" var="BookModel" />
<spring:url value="/resources/collection/BookCollection.js" var="BookCollection" />
<spring:url value="/resources/view/DashboardView.js" var="DashboardView" />
<spring:url value="/resources/model/UserModel.js" var="UserModel" />
<spring:url value="/resources/model/DashboardModel.js" var="DashboardModel" />
<spring:url value="/resources/model/AuthModel.js" var="AuthModel" />
<spring:url value="/resources/view/LoginView.js" var="LoginView" />
<spring:url value="/resources/view/BookView.js" var="BookView" />
<spring:url value="/resources/view/AddBookView.js" var="AddBookView" />
<spring:url value="/resources/view/Library.js" var="LibraryView" />


<script src="resources/mdlComponenthandler.js"></script>
<script src="${BookModel}"></script>
<script src="${BookCollection}"></script>
<script src="${LibraryView}"></script>
<script src="${RegView}"></script>
<script src="${BookView}"></script>
<script src="${UserModel}"></script>
<script src="${AuthModel}"></script>
<script src="${LoginView}"></script>
<script src="${DashboardView}"></script>
<script src="${AddBookView}"></script>
<script src="${DashboardModel}"></script>