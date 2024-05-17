package pe.edu.vallegrande.sessionproject.controller;

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
          System.out.println("Usuario en la sesión actual: " + usuario);
          System.out.println("Session actual: " + session);
          List<String> ciudades = (List<String>) session.getAttribute("ciudades");
          if (ciudades == null) {
               ciudades = new ArrayList<>();
          }
          ciudades.add(ciudad);
          System.out.println("Ciudades agregadas: " + ciudad);
          System.out.println("Ciudades totales en la lista: " + ciudades.size());
          session.setAttribute("ciudades", ciudades);

          // Contar usuarios
          List<String> usuarios = (List<String>) session.getServletContext().getAttribute("usuarios");
          if (usuarios == null) {
               usuarios = new ArrayList<>();
          }
          if (!usuarios.contains(usuario)) {
               usuarios.add(usuario);
               session.getServletContext().setAttribute("usuarios", usuarios);
               System.out.println("Cantidad de usuarios: " + usuarios.size());
          }

          resp.sendRedirect(req.getContextPath() + "/carrito.jsp");
          // RequestDispatcher rd = req.getRequestDispatcher("carrito.jsp");
          // rd.forward(req, resp);
     }

     private void clean(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
          HttpSession session = req.getSession();
          session.removeAttribute("ciudades");

          session.getServletContext().removeAttribute("usuarios");

          System.out.println("Lista de ciudades limpiada.");
          System.out.println("Sesión actual después de limpiar: " + session);
          resp.sendRedirect(req.getContextPath() + "/carrito.jsp");
          // RequestDispatcher rd = req.getRequestDispatcher("carrito.jsp");
          // rd.forward(req, resp);
     }

     private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          HttpSession session = req.getSession();
          List<String> ciudades = (List<String>) session.getAttribute("ciudades");
          req.setAttribute("ciudades", ciudades);
          System.out.println("Lista de ciudades:");
          if (ciudades != null) {
               for (String ciudad : ciudades) {
                    System.out.println(ciudad);
               }
          } else {
               System.out.println("La lista de ciudades está vacía.");
          }
          System.out.println("Sesión actual: " + session);
          req.getRequestDispatcher("carrito.jsp").forward(req, resp);
          // RequestDispatcher rd = req.getRequestDispatcher("carrito.jsp");
          // rd.forward(req, resp);
     }

     private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String ciudad = req.getParameter("ciudad");
          HttpSession session = req.getSession();
          List<String> ciudades = (List<String>) session.getAttribute("ciudades");
          if (ciudades != null) {
               ciudades.remove(ciudad);
               System.out.println("Ciudad eliminada: " + ciudad);
               System.out.println("Ciudades restantes en la lista: " + ciudades.size());
               session.setAttribute("ciudades", ciudades);
          }
          resp.sendRedirect(req.getContextPath() + "/carrito.jsp");
          // RequestDispatcher rd = req.getRequestDispatcher("carrito.jsp");
          // rd.forward(req, resp);
     }

}
