package design;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class calBean {

	private String Id;
	private String Date;
	private float Weight;
	private int Cal;
	
	public calBean(){
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
	//体重
	public void setWeight(float weight){
		Weight = weight;
	}
	public float getWeight(){
		return Weight;
	}
	//摂取カロリー
	public void setCal(int cal){
		Cal = cal;
	}
	public int getCal(){
		return Cal;
	}
	
	//データベースへの追加
	
	public boolean insertRecord(){
		try{
			Connection con = DBManager.getUserConnection();
			String sql = "INSERT INTO Cal(Id,Date,Weight,Cal) VALUE (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			//値を該当位置にセット
			ps.setString(1, Id);
			ps.setString(2,Date);
			ps.setFloat(3,Weight);
			ps.setInt(4,Cal);
			//sqlの実行
			int count = ps.executeUpdate();
			ps.close();
			con.close();
			if(count>0) return true; else return false;
		}catch(Exception e){
			return false;
		}
	}
	//指定された日付で削除
	public boolean deleteRecord(){
		try{
			Connection con = DBManager.getUserConnection();
			String sql = "DELETE FROM Cal WHERE Date=?";
			PreparedStatement ps = con.prepareStatement(sql);
			//値を該当位置にセット
			ps.setString(1, Date);
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
	public ArrayList<calBean> getRecords() {
		ArrayList<calBean> list = new ArrayList<calBean>();
		try{
			Connection con = DBManager.getUserConnection();
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("SELECT* FROM Cal");
			//SELECT文からのデータを1行ずつ取得して格納していく
			while(rs.next()){
				calBean tmp = new calBean();
				tmp.setId(rs.getString("Id"));
				tmp.setDate(rs.getString("Date"));
				tmp.setWeight(rs.getFloat("Weight"));
				tmp.setCal(rs.getInt("Cal"));
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
	/*最新の体重を取得
	public float getNewWeight(){		
		try{
			Connection con = DBManager.getUserConnection();
			Statement smt = con.createStatement();

			String sql = "SELECT Weight FROM Cal WHERE Id = ? ORDER BY Date DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,Id);
			ResultSet rs = smt.executeQuery(sql);

			//rs.next();
			return rs.getFloat("Weight");
		}catch(Exception e){
			return -1;
		}
	}*/
}