package design;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoSelectServlet
 */
@WebServlet("/UserInfoSelectServlet")
public class UserInfoSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoSelectServlet() {
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
		ArrayList<userInfoBean> list = uib.getUserRecords();
		//結果ページを振り分け
		if(!list.isEmpty())
			dispatcher = request.getRequestDispatcher("userInfoDB-result.jsp");
		else
			dispatcher = request.getRequestDispatcher("userInfoDB-faild.jsp");
		
		//リストのインスタンスを遷移先へ渡す
		request.setAttribute("userInfoList", list);
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
