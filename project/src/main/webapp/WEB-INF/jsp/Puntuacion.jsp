<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Book List</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
<h1>Contador</h1>
<table>
<tr>
    <th>Puntuación</th>
</tr>
    <tr>
        <td>${contador}</td>
    </tr>
</table>
<form method="POST" action="/list-pregs">
    <input type="submit" value="Listar">
</form>
</div>
</body>
</html>