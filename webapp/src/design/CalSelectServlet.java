package design;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalSelectServlet
 */
@WebServlet("/CalSelectServlet")
public class CalSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher;
		HttpSession se =request.getSession();
		userInfoBean ub = (userInfoBean)se.getAttribute("userBean");
		calBean cb = new calBean();
		ArrayList<calBean> list = cb.getRecords(ub.getId());
		//結果ページ
			dispatcher = request.getRequestDispatcher("Shousai.jsp");

		
		//リストのインスタンスを遷移先へ渡す
		request.setAttribute("calList", list);
		request.setAttribute("userBean", ub);
		//処理を遷移
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
