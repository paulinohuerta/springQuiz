<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Book List</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
<form action="save-pregs" method="post">
<h1>Preguntas</h1>
<table>
<tr>
    <th>Texto</th>
    <th>op1</th>
    <th>op2</th>
    <th>op3</th>
    <th>op4</th>
    <th>Respuesta</th>
    <th>&nbsp;</th>
</tr>
    <tr>
        <td><a href="${pregunta.link}">${pregunta.texto}</a></td>
        <td>${pregunta.op1}</td>
        <td>${pregunta.op2}</td>
        <td>${pregunta.op3}</td>
        <td>${pregunta.op4}</td>
        <td>
            <select id="unapregunta" name="unapregunta">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
        </td>
    </tr>
</table>
<input id="submit" type="submit" tabindex="5" value="Responder">
</form>
</div>
</body>
</html>
