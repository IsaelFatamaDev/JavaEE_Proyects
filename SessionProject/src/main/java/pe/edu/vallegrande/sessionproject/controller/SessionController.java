package pe.edu.vallegrande.sessionproject.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({ "/StartSession", "/EndSession" })
public class SessionController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/StartSession":
                startSession(request, response);
                break;
            case "/EndSession":
                endSession(request, response);
                break;
            default:
                break;
        }
    }

    private void endSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    private void startSession(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Proceso
        String nombre = request.getParameter("nombre");
        HttpSession session = request.getSession();
        session.setAttribute("nombre", nombre);
        // Dispatcher
        RequestDispatcher rd = request.getRequestDispatcher("carrito.jsp");
        rd.forward(request, response);
    }
}
