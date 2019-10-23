<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:include page="./index.jsp" />--%>

<%@include file="./index.html" %>

<spring:url value="/resources/app.js" var="Functions" />
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
<spring:url value="/resources/view/CartView.js" var="CartView" />
<spring:url value="/resources/collection/UserCollection.js" var="UserCollection" />
<spring:url value="/resources/view/UserView.js" var="UserView" />
<spring:url value="/resources/view/UserListView.js" var="UserListView" />
<spring:url value="/resources/view/UpdateBookView.js" var="UpdateBookView" />
<spring:url value="/resources/collection/CartCollection.js" var="CartCollection" />
<spring:url value="/resources/view/CartBookView.js" var="CartBookView" />


<script src="resources/mdlComponenthandler.js"></script>
<script src="${Functions}"></script>
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
<script src="${CartView}"></script>
<script src="${UserCollection}"></script>
<script src="${UserView}"></script>
<script src="${UserListView}"></script>
<script src="${UpdateBookView}"></script>
<script src="${CartCollection}"></script>
<script src="${CartBookView}"></script>