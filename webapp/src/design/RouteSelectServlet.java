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
 * Servlet implementation class RouteSelectServlet
 */
@WebServlet("/RouteSelectServlet")
public class RouteSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RouteSelectServlet() {
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
		HttpSession se = request.getSession();
		userInfoBean ub = (userInfoBean)se.getAttribute("userBean");

		routeBean rb = new routeBean();
		ArrayList<routeBean> list = rb.getRecords(ub.getId());
		//結果ページを振り分け
		//if(!list.isEmpty())
			dispatcher = request.getRequestDispatcher("ShousaiR.jsp");
		//else
			//dispatcher = request.getRequestDispatcher("routeDB-faild.jsp");
		
		//リストのインスタンスを遷移先へ渡す
		request.setAttribute("routeList", list);
		se.setAttribute("userBean",ub);
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
