package pl.alex.ksiegagosci;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuestBookController extends HttpServlet {
    private CommentDao commentDao=new CommentDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comment> comments = commentDao.findAll();
            request.setAttribute("comments",comments);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Comment comment = getComment(request);
        commentDao.save(comment);
        response.sendRedirect(request.getContextPath());
    }

    private Comment getComment(HttpServletRequest request) {
        String author = request.getParameter("author");
        String message = request.getParameter("message");
        return new Comment(author,message);
    }
}
