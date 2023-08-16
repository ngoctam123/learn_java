package KhachHangServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.KhachHang;
import Entities.KhachHangDAO;

/**
 * Servlet implementation class KhachHangDetail
 */
@WebServlet(name = "KhachHangDetail1", urlPatterns = { "/KhachHangDetail1" })
public class KhachHangDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachHangDAO khachHangDAO;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		khachHangDAO = new KhachHangDAO();
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKH = request.getParameter("maKH");
        KhachHang khachHang = khachHangDAO.getKhachHangByMaKH(maKH);
        request.setAttribute("khachHang", khachHang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("KhachHangDetail1.jsp");
        dispatcher.forward(request, response);
	}

}
