package KhachHangServlet;
import Entities.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KhachHangListServlet extends HttpServlet {
    private KhachHangDAO khachHangDAO;

    public void init() {
        khachHangDAO = new KhachHangDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KhachHang> khachHangList = khachHangDAO.getAllKhachHang();
        request.setAttribute("khachHangList", khachHangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("khachhang-list.jsp");
        dispatcher.forward(request, response);
    }
}
