package design;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//データの受け取り
		HttpSession se =request.getSession();
		userInfoBean ub = (userInfoBean)se.getAttribute("userBean");
		String id = ub.getId();
		//String date = request.getParameter("date");
		//日付の取得
		GregorianCalendar cale = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(cale.getTime());
		
		//フォームからデータ受け取り
		String weight = request.getParameter("weight");
		String cal = request.getParameter("number");
		//セット
		cb.setId(id);
		cb.setDate(date);
		cb.setWeight(Float.parseFloat(weight));
		cb.setCal(Integer.parseInt(cal));
		//DBへ登録
		cb.insertRecord();
		
		dispatcher = request.getRequestDispatcher("MyPage.jsp");
		se.setAttribute("userBean", ub);
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
