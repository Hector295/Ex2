package Servlets;

import Beans.Empleado;
import Beans.Rol;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/Empleado"})
public class EmpleadoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        if (request.getSession().getAttribute("empleado") == null) {
            response.sendRedirect(request.getContextPath());
        } else {
            String accion = request.getParameter("accion") == null ? "lista" : request.getParameter("accion");

            RequestDispatcher view;
            switch (accion){
                case "listar":
                    HttpSession session = request.getSession();
                    Empleado empleado= (Empleado) session.getAttribute("empleado");
                    for (Rol rol : empleado.getRoles()){
                        empleado.getIdEmpleado()
                    }
                    break;
            }

        }
    }
}
