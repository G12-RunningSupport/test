package design;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RouteUpdateServlet
 */
@WebServlet("/RouteUpdateServlet")
public class RouteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RouteUpdateServlet() {
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
		routeBean rb = new routeBean();		
		// ubをセッションで渡すため
		HttpSession se = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		//フォームからデータの受け取り
		userInfoBean ub = (userInfoBean)request.getAttribute("userBean");
		String id = ub.getId();
		String date = request.getParameter("date");
		String no = request.getParameter("no");
		String distance = request.getParameter("distance");
		String start = request.getParameter("startTime");
		String finish = request.getParameter("finishTime");
		//セット
		rb.setId(id);
		rb.setDate(date);
		rb.setNo(Integer.parseInt(no));
		rb.setDistance(Integer.parseInt(distance));
		rb.setStart(start);
		rb.setFinish(finish);
		//ページ振り分け
		if(rb.insertRecord())
			dispatcher = request.getRequestDispatcher("routeDB-success.jsp");
		else
			dispatcher = request.getRequestDispatcher("routeDB-failed.jsp");
		
		request.setAttribute("routeBean", rb);
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
