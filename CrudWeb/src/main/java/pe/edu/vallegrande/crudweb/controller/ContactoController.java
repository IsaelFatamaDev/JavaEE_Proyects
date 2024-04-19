package pe.edu.vallegrande.crudweb.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pe.edu.vallegrande.crudweb.dto.ContactoDTO;
import pe.edu.vallegrande.crudweb.service.ContactoService;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
@WebServlet({"/ContGetAll", "/ContGetId"})
public class ContactoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/ContGetAll":
                getAll(req, resp);
                break;
            case "/ContGetId":
                getById(req, resp);
                break;
        }
    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ContactoDTO> lista;
        ContactoService service = new ContactoService();
        lista = service.getAll();
        req.setAttribute("lista", lista);
        RequestDispatcher rd = req.getRequestDispatcher("contacto.jsp");
        rd.forward(req, resp);
    }

    private void getById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        ContactoService service = new ContactoService();
        ContactoDTO contacto = service.getById(id);

        if (contacto != null) {
            req.setAttribute("contacto", contacto);
            RequestDispatcher rd = req.getRequestDispatcher("detalleContacto.jsp");
            rd.forward(req, resp);
        } else {
            String mensaje = "El contacto con ID " + id + " no fue encontrado";
            req.setAttribute("mensaje", mensaje);

            resp.sendRedirect(req.getContextPath() + "/index.jsp?mensaje=" + URLEncoder.encode(mensaje, "UTF-8"));
        }
    }


}
