package com.anytrash.privatenotes.servlets;

import com.anytrash.privatenotes.models.NoteStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "noteGetServlet",
        value = "/note_get"
)
public class NoteGetServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (NoteStorage.getInstance().noteExsist(request.getParameter("id"))) {
            String id = request.getParameter("id");
            request.setAttribute("content", NoteStorage.getInstance().popNote(id).getContent());
            request.getRequestDispatcher("views/note_get.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("views/404.jsp").forward(request, response);
        }
    }
}
