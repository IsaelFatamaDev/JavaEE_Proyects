package edu.pe.vallegrande.importaciones.controller;

import edu.pe.vallegrande.importaciones.dto.OfficeDto;
import edu.pe.vallegrande.importaciones.service.OfficeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/locales")
public class OfficeController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path){
            case "/locales":
                getAll(req, resp);
                break;
            default:
                break;
        }
    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OfficeService officeService = new OfficeService();
        List<OfficeDto> officeList = officeService.getOffice();
        req.setAttribute("lista", officeList);
        req.getRequestDispatcher("locales.jsp").forward(req, resp);
    }


}
