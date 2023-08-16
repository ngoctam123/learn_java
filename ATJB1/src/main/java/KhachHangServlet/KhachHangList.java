package KhachHangServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.*;

/**
 * Servlet implementation class KhachHangList
 */
@WebServlet(name = "KhachHangLists", urlPatterns = { "/KhachHangLists" })
public class KhachHangList extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	private KhachHangDAO khachHangDAO;

    public void init() {
        khachHangDAO = new KhachHangDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<KhachHang> khachHangList = khachHangDAO.getAllKhachHang();
        request.setAttribute("khachHangList", khachHangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index");
        dispatcher.forward(request, response);
	}

}
