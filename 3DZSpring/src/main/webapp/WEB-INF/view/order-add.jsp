<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Add new order</title>
</head>

<body>
    <form th:action="@{'/order/add'}" th:object="${order}" method="post">
        ID: <input type="number" th:field="*{id}"/>
        <br>
        Date: <input type="number" th:field="*{date}"/>
        <br>
        Cost: <input type="number" th:field="*{cost}"/>
        <br>
        Products: <input type="text" th:field="*{products}"/>
        <br>
        <button type="submit">Save</button>
    </form>
</body>
</html>
