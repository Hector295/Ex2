<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 21/12/2020
  Time: 08:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
        <title>Lista empleados</title>
    </head>
    <body>
        <div class='container'>
            <jsp:include page="../includes/navbar.jsp">
                <jsp:param name="currentPage" value="emp"/>
            </jsp:include>
            <div class="row mb-5 mt-4">
                <div class="col-lg-6">
                    <h1 class=''>Lista de empleados</h1>
                </div>
                <div class="col-lg-6 my-auto text-lg-right">
                    <% if(employee.getEmployeeId() > 0){ %>
                    <a href="<%= request.getContextPath()%>/EmployeeServlet?action=agregar" class="btn btn-primary">
                        Agregar nuevo empleado</a>
                    <% } %>
                </div>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Employee</th>
                        <th>Email</th>
                        <th>Job ID</th>
                        <th>Salary</th>
                        <th>Commision</th>
                        <th>Manager ID</th>
                        <th>Department ID</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int i = 1;
                        for (Employee e : listaEmpleados) {
                    %>
                    <tr>
                        <td><%= i%>
                        </td>
                        <td><%= e.getFirstName() + " " + e.getLastName()%>
                        </td>
                        <td><%= e.getEmail()%>
                        </td>
                        <td><%= e.getJob().getJobTitle()%>
                        </td>
                        <td><%= e.getSalary()%>
                        </td>
                        <td><%= e.getCommissionPct() == null ? "Sin comisión" : e.getCommissionPct()%>
                        </td>
                        <td><%= e.getManager().getEmployeeId() == 0 ? "Sin jefe" : (e.getManager().getFirstName() + " " + e.getManager().getLastName())%>
                        </td>
                        <td><%= e.getDepartment().getDepartmentName()%>
                        </td>
                        <td><a href="EmployeeServlet?action=editar&id=<%= e.getEmployeeId()%>">Editar</a></td>
                        <td><a href="EmployeeServlet?action=borrar&id=<%= e.getEmployeeId()%>">Borrar</a></td>
                    </tr>
                    <%
                            i++;
                        }
                    %>
                </tbody>
            </table>

            <div class="row mb-5 mt-4">
                <div class="col">
                    <h1 class=''>Lista de empleados por Región</h1>
                </div>
            </div>
            <table class="table col-6">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Región</th>
                        <th>Cantidad de empleados</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int j = 1;
                        for (EmpleadosPorRegionDto e : listaEmpleadosPorRegion) {
                    %>
                    <tr>
                        <td><%= j%>
                        </td>
                        <td><%= e.getRegionName()%>
                        </td>
                        <td><%= e.getNumeroEmpleados()%>
                        </td>
                    </tr>
                    <%
                            j++;
                        }
                    %>
                </tbody>
            </table>
            <hr/>
            <div class="row mb-5 mt-4">
                <div class="col">
                    <h1 class=''>Lista de empleados por con su país</h1>
                </div>
            </div>
            <table class="table col-6">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Empleado</th>
                        <th>Pais</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int k = 1;
                        for (EmpleadoConSuPaisDto e : listaEmpleadosConSuPais) {
                    %>
                    <tr>
                        <td><%= k%>
                        </td>
                        <td><%= e.getFirstName() + " " + e.getLastName()%>
                        </td>
                        <td><%= e.getCountryName() == null ? "-- sin país --" : e.getCountryName()%>
                        </td>
                    </tr>
                    <%
                            k++;
                        }
                    %>
                </tbody>
            </table>
            <jsp:include page="../includes/footer.jsp"/>
        </div>
    </body>
</html>