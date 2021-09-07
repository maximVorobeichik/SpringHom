<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>order</title>
    </head>

    <body>
        <h1>Order_</h1>
        <ul>
            <c:forEach items="${orders}" var="order">
                <li>
                    <p>ID: <c:out value="${order.id}"/></p>
                    <p>Date: <c:out value="${order.date}"/></p>
                    <p>Cost: <c:out value="${order.cost}"/></p>
                    <p>Cost: <c:out value="${order.products}"/></p>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>