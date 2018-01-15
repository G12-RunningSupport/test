package design;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;

		//  ユーザ情報を処理する JavaBean をつくる
		userBean ub = new UserBean();
		
		// 文字コードを UTF-8 として扱う
		request.setCharacterEncoding("UTF-8");
		
		 // フォームの入力データを文字列としてサーブレットで受け取る
		 //  ※日本語入力の場合だけ、文字コードをUTF-8 に変換する
		 //   （送られてきたパラメータが ISO8859-1 で一旦デコードされているので元に戻す）
		 String id = request.getParameter("UserId");
		 String year = request.getParameter("year");
		 String month = request.getParameter("month");
		 String day = request.getParameter("day");
		 int	 sex = Integer.parseInt(request.getParameter("Sex"));
		 int	 height = Integer.parseInt(request.getParameter("Height"));
		 
		 //setする
		 ub.setId(id);
		 ub.setBirth(year+"-"+month+"-"+day);
		 ub.setSex(sex);
		 ub.setHeight(height);
		 
		 //  データベースへの INSERT 処理の実行
		 int x = ub.insertRecord();
		 //登録成功
		 if (x == 0) {
			 dispatcher = request.getRequestDispatcher("mypage.jsp");
		 //ID重複
		 }else if(x == -1){
			 dispatcher = request.getRequestDispatcher("mypage.jsp");
		 //その他のエラー
		 }else{
			 dispatcher = request.getRequestDispatcher("Signup-failed.jsp");
		 }
		
		 
		 
		 // studentBean のインスタンスを request に詰めて
		 // 次に遷移する JSP に渡す
		 // JSP側 ではキーワード "studentBean" をつかってインスタンスを取り出す
		 //  二重引用符の中の単語はクラス名である必要はなく、自分で自由に決めてよい
		 request.setAttribute("userBean", ub);

		 // 最後に JSP へ処理を遷移させる
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
