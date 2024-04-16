package pe.edu.vallegrande.crudweb.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pe.edu.vallegrande.crudweb.dto.ContactoDTO;
import pe.edu.vallegrande.crudweb.service.ContactoService;

import java.io.IOException;
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
//            case "/ContGetId":
//                getById(req, resp);
//                break;
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
}
