<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 21/12/2020
  Time: 08:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.Cartelera" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<Cartelera> listaCartelera = (ArrayList<Cartelera>) request.getAttribute("lista");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' />
        <title>Cartelera</title>
    </head>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp"/>
            <div class="row mb-5 mt-4">
                <div class="col-lg-6">
                    <h1 class=''>Cartelera</h1>
                </div>
                <div class="col-lg-6 my-auto text-lg-right">
                    <a href="<%= request.getContextPath()%>/PartidosServlet?action=crear" class="btn btn-primary">Crear Función</a>
                </div>
            </div>
            <table class="table">
                <tr>
                    <th>#</th>
                    <th>Cadena</th>
                    <th>Cine</th>
                    <th>Película</th>
                    <th>Horario</th>
                </tr>
                <%
                    for (Cartelera cartelera : listaCartelera) {
                %>
                <tr>
                    <td><%=cartelera.getIdCartelera()%></td>
                    <td><%=cartelera.getCine().getCadena().getNombreComercial()%></td>
                    <td><%=cartelera.getCine().getNombre()%></td>
                    <td><%=cartelera.getPelicula().getNombre()%> + <%=()%></td>
                    <td><%=cartelera.getHorario()%></td>
                </tr>

                <%
                    }
                %>

            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>




    </body>
</html>
