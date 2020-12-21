package Servlets;

import Beans.Cartelera;
import Daos.DaoCartelera;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CarteleraServlet", urlPatterns = {"/CarteleraServlet"})
public class CarteleraServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoCartelera daocartelera=new DaoCartelera();
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;
        switch (action) {
            case "lista":
                ArrayList<Cartelera> listaCartelera = daocartelera.listaCartelera();
                request.setAttribute("lista", listaCartelera);
                view = request.getRequestDispatcher("/Cartelera/cartelera.jsp");
                view.forward(request, response);
                break;
            case "crear":
                break;
        }
    }
}
