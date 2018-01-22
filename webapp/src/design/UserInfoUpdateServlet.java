package design;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoUpdateServlet
 */
@WebServlet("/UserInfoUpdateServlet")
public class UserInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoUpdateServlet() {
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
		userInfoBean uib = new userInfoBean();
		
		request.setCharacterEncoding("UTF-8");
		//フォームからデータの受け取り
		String id = request.getParameter("id");
		String birth = request.getParameter("birth");
		String sex = request.getParameter("sex");
		String height = request.getParameter("height");
		//セット
		uib.setId(id);
		uib.setBirth(birth);
		uib.setSex(Integer.parseInt(sex));
		uib.setHeight(Integer.parseInt(height));
		//ページ振り分け
		if(uib.insertRecord())
			dispatcher = request.getRequestDispatcher("userInfoDB-success.jsp");
		else
			dispatcher = request.getRequestDispatcher("userInfoDB-failed.jsp");
		
		request.setAttribute("userInfoBean", uib);
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
