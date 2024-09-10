package pe.edu.vallegrande.sessionproject.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({ "/add", "/list", "/delete", "/clean" })
public class CarritoController extends HttpServlet {

     @Override
     protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          HttpSession session = req.getSession(false);
          if (session == null || session.getAttribute("nombre") == null) {
               resp.sendRedirect(req.getContextPath() + "/index.jsp");
               return;
          }

          String path = req.getServletPath();
          switch (path) {
               case "/add":
                    add(req, resp);
                    break;
               case "/list":
                    list(req, resp);
                    break;
               case "/delete":
                    delete(req, resp);
                    break;
               case "/clean":
                    clean(req, resp);
                    break;
               default:
                    break;
          }
     }

     private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
          String ciudad = req.getParameter("ciudad");
          HttpSession session = req.getSession();
          String usuario = (String) session.getAttribute("nombre");
          List<String> ciudades = (List<String>) session.getAttribute("ciudades");
          if (ciudades == null) {
               ciudades = new ArrayList<>();
          }
          ciudades.add(ciudad);
          session.setAttribute("ciudades", ciudades);

          // Contar usuarios
          List<String> usuarios = (List<String>) session.getServletContext().getAttribute("usuarios");
          if (usuarios == null) {
               usuarios = new ArrayList<>();
          }
          if (!usuarios.contains(usuario)) {
               usuarios.add(usuario);
               session.getServletContext().setAttribute("usuarios", usuarios);
          }

          resp.sendRedirect(req.getContextPath() + "/carrito.jsp");
     }

     private void clean(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
          HttpSession session = req.getSession();
          session.removeAttribute("ciudades");
          session.getServletContext().removeAttribute("usuarios");

          RequestDispatcher rd = req.getRequestDispatcher("carrito.jsp");
          rd.forward(req, resp);
     }

     private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          HttpSession session = req.getSession();
          List<String> ciudades = (List<String>) session.getAttribute("ciudades");
          req.setAttribute("ciudades", ciudades);

          req.getRequestDispatcher("carrito.jsp").forward(req, resp);
     }

     private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String indexStr = req.getParameter("index");
          HttpSession session = req.getSession();
          List<String> ciudades = (List<String>) session.getAttribute("ciudades");
          if (ciudades != null) {
               int index = Integer.parseInt(indexStr);
               ciudades.remove(index - 1);
               session.setAttribute("ciudades", ciudades);
          }
          resp.sendRedirect(req.getContextPath() + "/carrito.jsp");
     }
}
