package com.anytrash.privatenotes.servlets;

import com.anytrash.privatenotes.models.NoteStorage;
import com.anytrash.privatenotes.models.objects.Note;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "noteLinkServlet",
        value = "/note_link"
)
public class NoteLinkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = NoteStorage.getInstance().putNote(new Note(request.getParameter("note_content")));
        request.setAttribute("id", id);
        request.getRequestDispatcher("views/note_link.jsp").forward(request, response);
    }
}
