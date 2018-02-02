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
		HttpSession se = request.getSession();
		userInfoBean ub = (userInfoBean)se.getAttribute("userBean");
		request.setCharacterEncoding("UTF-8");
		
		//フォームからデータの受け取り
//		userInfoBean ub = (userInfoBean)request.getAttribute("userBean");
//		String id = "test-error";
//		if(ub!=null){
//			id = ub.getId();
//		}
		String id = ub.getId();
		String date = request.getParameter("date");
		int no = rb.getMaxNo(id);
		String distance = request.getParameter("distance").replaceFirst(" km","");
		String start = request.getParameter("startTime")+":00";
		String finish = request.getParameter("finishTime")+":00";
		//セット
		rb.setId(id);
		rb.setDate(date);
		rb.setNo(no+1);
		rb.setDistance((int)Float.parseFloat(distance));
		rb.setStart(start);
		rb.setFinish(finish);
		//ページ振り分け
		if(rb.insertRecord())
			dispatcher = request.getRequestDispatcher("MyPage.jsp");
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
