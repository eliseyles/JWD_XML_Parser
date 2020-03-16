<%@ page language="java"  pageEncoding="UTF-8" %>
<html>
<head>
    <title>result_page</title>
    <%@include file="jspheader/header.jsp" %>
</head>
<body>
<%@include file="jspheader/nav.jsp" %>
<div>
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">Candy name</th>
            <th scope="col">Candy type</th>
            <th scope="col">Production</th>
            <th scope="col">Fat</th>
            <th scope="col">Protein</th>
            <th scope="col">Carbohydrates</th>
            <th scope="col">Energy</th>
            <th scope="col">Water</th>
            <th scope="col">Sugar</th>
            <th scope="col">Fructose</th>
            <th scope="col">Chocolate type</th>
        </tr>
        </thead>
        <tbody>
<%--        <c:forEach var="tariff" items="${tariffs}">--%>
<%--            <tr>--%>
<%--                <td>${tariff.name}</td>--%>
<%--                <td>${tariff.operatorName}</td>--%>
<%--                <td>${tariff.pay roll}</td>--%>
<%--                <td>${tariff.SMSPrice}</td>--%>
<%--                <td>${tariff.callPrice.withinNetworkPrice}</td>--%>
<%--                <td>${tariff.callPrice.otherNetworkPrice}</td>--%>
<%--                <td>${tariff.callPrice.standardPhoneNumbersPrice}</td>--%>
<%--                <td>${tariff.parameters.containsFavouritePhoneNumbers}</td>--%>
<%--                <td>${tariff.parameters.tariffing}</td>--%>
<%--                <td>${tariff.parameters.connectionCost}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
        </tbody>
    </table>
</div>
</body>
</html>
