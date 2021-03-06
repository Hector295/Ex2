<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 21/12/2020
  Time: 08:33
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Inicio sesión</title>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/css/signin.css" rel="stylesheet">
    </head>

    <body class="text-center">
        <form class="form-signin" method="POST" action="<%=request.getContextPath()%>/Login">
            <h1 class="h3 mb-3 font-weight-normal">Ingreso al sistema 'movies'</h1>
            <input type="text" name="dni" class="form-control" placeholder="DNI..." autofocus="">
            <input type="password" name="pass" class="form-control" placeholder="Contraseña...">
            <% if (request.getParameter("error") != null) { %>
            <div class="text-danger mb-2">Error en DNI o contraseña</div>
            <% } %>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
        </form>
    </body>
</html>
