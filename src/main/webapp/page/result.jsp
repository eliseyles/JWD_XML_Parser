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
        <c:forEach var="candy" items="${candies}">
            <tr>
                <td>${candy.name}</td>
                <td>${candy.candyType.type}</td>
                <td>${candy.production}</td>
                <td>${candy.value.fat}</td>
                <td>${candy.value.protein}</td>
                <td>${candy.value.carbohydrates}</td>
                <td>${candy.energy}</td>
                <td>${candy.ingredient.water}</td>
                <td>${candy.ingredient.sugar}</td>
                <td>${candy.ingredient.fructose}</td>
                <td>${candy.ingredient.chocolateType}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
