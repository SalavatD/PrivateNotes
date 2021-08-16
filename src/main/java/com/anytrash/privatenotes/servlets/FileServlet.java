package com.anytrash.privatenotes.servlets;

import com.anytrash.privatenotes.models.FileStorage;
import com.anytrash.privatenotes.models.objects.File;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(
        name = "fileServlet",
        value = "/file"
)
public class FileServlet extends HttpServlet {
    private static final int BUFFER_SIZE = 0xFFFF;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (FileStorage.getInstance().fileExsist(request.getParameter("id"))) {
            File file = FileStorage.getInstance().popFile(request.getParameter("id"));
            response.setHeader("Content-disposition", "attachment; filename=" + file.getName());
            OutputStream outputStream = response.getOutputStream();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(file.getContent());
            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ((length = byteArrayInputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            byteArrayInputStream.close();
            outputStream.flush();
        } else {
            request.getRequestDispatcher("views/404.jsp").forward(request, response);
        }
    }
}
