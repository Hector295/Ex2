package Servlets;

import Beans.Empleado;
import Daos.LoginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"","/Login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dni= request.getParameter("dni");
        String pass= request.getParameter("pass");
        LoginDao loginDao = new LoginDao();
        Empleado empleado=loginDao.obteneEmpleado(dni,pass);

        if (empleado != null) {
            HttpSession session = request.getSession();
            session.setAttribute("empleado", empleado);
            response.sendRedirect(request.getContextPath() + "/Empleado");
        } else {
            response.sendRedirect(request.getContextPath() + "/Login?error");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion") == null ? "login" : request.getParameter("accion");
        switch (accion) {
            case "login":
                if (request.getSession().getAttribute("empleado") != null) {
                    response.sendRedirect(request.getContextPath() + "/Empleado");
                } else {
                    RequestDispatcher view = request.getRequestDispatcher("includes/login.jsp");
                    view.forward(request, response);
                }
                break;
            case "logout":
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect(request.getContextPath());
                break;
        }
    }
}
