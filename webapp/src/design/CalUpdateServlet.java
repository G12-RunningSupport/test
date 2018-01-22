package design;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalUpdateServlet
 */
@WebServlet("/CalUpdateServlet")
public class CalUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalUpdateServlet() {
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
		calBean cb = new calBean();
		
		request.setCharacterEncoding("UTF-8");
		//フォームからデータの受け取り
		String id = request.getParameter("id");
		String date = request.getParameter("date");
		String weight = request.getParameter("weight");
		String cal = request.getParameter("number");
		//セット
		cb.setId(id);
		cb.setDate(date);
		cb.setWeight(Float.parseFloat(weight));
		cb.setCal(Integer.parseInt(cal));
		//ページ振り分け
		if(cb.insertRecord())
			dispatcher = request.getRequestDispatcher("calDB-success.jsp");
		else
			dispatcher = request.getRequestDispatcher("calDB-failed.jsp");
		
		request.setAttribute("calBean", cb);
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
