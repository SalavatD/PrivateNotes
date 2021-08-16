package com.anytrash.privatenotes.servlets;

import com.anytrash.privatenotes.models.FileStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "fileGetServlet",
        value = "/file_get"
)
public class FileGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (FileStorage.getInstance().fileExsist(request.getParameter("id"))) {
            request.getRequestDispatcher("views/file_get.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("views/404.jsp").forward(request, response);
        }
    }
}
