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
 * Servlet implementation class CheckIdServlet
 */
@WebServlet("/CheckIdServlet")
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;

		//  ユーザ情報を処理する JavaBean をつくる
		userInfoBean ub = new userInfoBean();
		// ubをセッションで渡すため
		HttpSession se = request.getSession();
		// 文字コードを UTF-8 として扱う
		request.setCharacterEncoding("UTF-8");
		
		 // フォームの入力データを文字列としてサーブレットで受け取る
		 //  ※日本語入力の場合だけ、文字コードをUTF-8 に変換する
		 //   （送られてきたパラメータが ISO8859-1 で一旦デコードされているので元に戻す）
		 String id = request.getParameter("UserId");
		
		 
		 //ランキングの要素をセット
		 /*routeBean rb = new routeBean();
		 ArrayList<routeBean> list = rb.getRank();
		 */
		 // containメソッドでUserIdがDBに登録されているか確認する
		 if(ub.containId(id)){
			 //beanの全要素をセット
			 ub.setAll(id);
			 // マイページをディスパッチする
			 dispatcher = request.getRequestDispatcher("MyPage.jsp");
		 }else{
			 //認証エラーページをディスパッチ
			 dispatcher = request.getRequestDispatcher("idFailed.jsp");
		 }
		 
		 
		 
		 // studentBean のインスタンスを request に詰めて
		 // 次に遷移する JSP に渡す
		 // JSP側 ではキーワード "studentBean" をつかってインスタンスを取り出す
		 //  二重引用符の中の単語はクラス名である必要はなく、自分で自由に決めてよい
		 se.setAttribute("userBean",ub);
		 //request.setAttribute("routeList", list);

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
