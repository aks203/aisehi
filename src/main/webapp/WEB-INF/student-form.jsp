<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .error{
        color: red;
    }
</style>
<body>

<form:form action="processForm" modelAttribute="student1">
    <table>
        <tr>
            <td><form:label path="name">Name: </form:label></td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssClass="error"></form:errors></td>
        </tr>
        <tr>
            <td><form:label path="address">Address: </form:label></td>
            <td><form:input path="address"/></td>
            <td><form:errors path="address" cssClass="error"></form:errors></td>
        </tr>
        <tr>
            <td><form:label path="number">
                Contact Number: </form:label></td>
            <td><form:input path="number"/></td>
            <td><form:errors path="number" cssClass="error"></form:errors></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
