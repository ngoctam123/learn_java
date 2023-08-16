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

public class KhachHangDetailServlet extends HttpServlet {
    private KhachHangDAO khachHangDAO;

    public void init() {
        khachHangDAO = new KhachHangDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maKH = request.getParameter("maKH");
        KhachHang khachHang = khachHangDAO.getKhachHangByMaKH(maKH);
        request.setAttribute("khachHang", khachHang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("khachhang-detail.jsp");
        dispatcher.forward(request, response);
    }
}
