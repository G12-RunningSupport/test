package design;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class routeBean {
	private String Id;
	private String Date;
	private int No,Distance;
	private String Start,Finish;
	
	public routeBean(){
		;
	}
	
	//セッター、ゲッター メソッド
	
	//ユーザId
	public void setId(String id){
		Id = id;
	}
	public String getId(){
		return Id;
	}
	//日付
	public void setDate(String date){
		Date = date;
	}
	public String getDate(){
		return Date;
	}
	//回数
	public void setNo(int no){
		No = no;
	}
	public int getNo(){
		return No;
	}
	//距離
	public void setDistance(int distance){
		Distance = distance;
	}
	public int getDistance(){
		return Distance;
	}
	public void setStart(String start){
		Start = start;
	}
	public String getStart(){
		return Start;
	}
	public void setFinish(String finish){
		Finish = finish;
	}
	public String getFinish(){
		return Finish;
	}
	//データベースへの追加
	
	public boolean insertRecord(){
		try{
			Connection con = DBManager.getUserConnection();
			String sql = "INSERT INTO Route(Id,Date,No,Distance,Start,Finish) VALUE (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			//値を該当位置にセット
			ps.setString(1, Id);
			ps.setString(2, Date);
			ps.setInt(3, No);
			ps.setInt(4, Distance);
			ps.setString(5,Start);
			ps.setString(6, Finish);
			//sqlの実行
			int count = ps.executeUpdate();
			ps.close();
			con.close();
			if(count>0) return true; else return false;
		}catch(Exception e){
			return false;
		}
	}
	//指定されたNoで削除
	public boolean deleteRecord(){
		try{
			Connection con = DBManager.getUserConnection();
			String sql = "DELETE FROM Route WHERE No=?";
			PreparedStatement ps = con.prepareStatement(sql);
			//値を該当位置にセット
			ps.setInt(1, No);
			//sqlの実行
			int count = ps.executeUpdate();
			ps.close();
			con.close();
			if(count>0) return true; else return false;
		}catch(Exception e){
			return false;
		}		
	}
	//一覧の取得
	public ArrayList<routeBean> getRecords() {
		ArrayList<routeBean> list = new ArrayList<routeBean>();
		try{
			Connection con = DBManager.getUserConnection();
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("SELECT* FROM Route");
			//SELECT文からのデータを1行ずつ取得して格納していく
			while(rs.next()){
				routeBean tmp = new routeBean();
				tmp.setId(rs.getString("Id"));
				tmp.setDate(rs.getString("Date"));
				tmp.setNo(rs.getInt("No"));
				tmp.setDistance(rs.getInt("Distance"));
				tmp.setStart(rs.getString("Start"));
				tmp.setFinish(rs.getString("Finish"));
				list.add(tmp);
			}
				rs.close();
				smt.close();
				con.close();
				
				return list;
		}catch(Exception e){
			return null;
		}
		
	}
}
