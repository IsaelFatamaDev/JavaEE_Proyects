package edu.pe.vallegrande.carrito.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/carrito", "/insertarCarrito", "/eliminarCarrito", "/actualizarCarrito", "/listarCarrito"})
public class CarritoController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/carrito":
                break;
            case "/insertarCarrito":
                break;
            case "/eliminarCarrito":
                break;
            case "/actualizarCarrito":
                break;
            case "/listarCarrito":
                listarCarrito(req, resp);
                break;
        }
    }

    private void listarCarrito(HttpServletRequest req, HttpServletResponse resp) {
    }
}
