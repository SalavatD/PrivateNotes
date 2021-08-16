package com.anytrash.privatenotes.servlets;

import com.anytrash.privatenotes.models.FileStorage;
import com.anytrash.privatenotes.models.objects.File;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.nio.file.Paths;

import static com.anytrash.privatenotes.models.Util.inputStreamToByteArray;

@WebServlet(
        name = "fileLinkServlet",
        value = "/file_link"
)
@MultipartConfig
public class FileLinkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("file");
        String name = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        byte[] content = inputStreamToByteArray(part.getInputStream());
        String id = FileStorage.getInstance().putFile(new File(name, content));
        request.setAttribute("id", id);
        request.getRequestDispatcher("views/file_link.jsp").forward(request, response);
    }
}
