package design;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class userInfoBean {
	private String Id;
	private String Birth;
	private int Sex,Height;
	private int failure/*登録失敗時用 0:成功 2:エラー 1:重複*/;
	
	public userInfoBean(){
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
	//生年月日
	public void setBirth(String birth){
		Birth = birth;
	}
	public String getBirth(){
		return Birth;
	}
	//性別
	public void setSex(int sex){
		Sex = sex;
	}
	public int getSex(){
		return Sex;
	}
	//身長
	public void setHeight(int height){
		Height = height;
	}
	public int getHeight(){
		return Height;
	}
	public void setFailure(int failure){
		this.failure = failure;
	}
	public int getFailure(){
		return this.failure;
	}
	
	//フィールドにDBからIdの情報をセット
	public void setAll(String id){
		try{
			Connection con = DBManager.getUserConnection();
			//Statement smt = con.createStatement();
			//int i = smt.executeUpdate("SELECT UserInfo Wehre Id ="+id+";");
			//SQL文
			String sql="SELECT* FROM UserInfo WHERE Id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				setId(rs.getString("Id"));
				setBirth(rs.getString("Birth"));
				setSex(rs.getInt("Sex"));
				setHeight(rs.getInt("Height"));
			}
			rs.close();
			ps.close();
			//smt.close();
			con.close();
		}catch(Exception e){
		}
	}
	//データベースへの追加
	
	public boolean insertRecord(){
		try{
			Connection con = DBManager.getUserConnection();
			String sql = "INSERT INTO UserInfo(Id,Birth,Sex,Height) VALUE (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			//値を該当位置にセット
			ps.setString(1, Id);
			ps.setString(2, Birth);
			ps.setInt(3, Sex);
			ps.setInt(4, Height);
			//sqlの実行
			int count = ps.executeUpdate();
			ps.close();
			con.close();
			if(count>0) return true; else return false;
		}catch(Exception e){
			return false;
		}
	}
	public boolean deleteRecord(){
		try{
			Connection con = DBManager.getUserConnection();
			String sql = "DELETE FROM UserInfo WHERE Id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			//値を該当位置にセット
			ps.setString(1, Id);
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
	public ArrayList<userInfoBean> getUserRecords() {
		ArrayList<userInfoBean> list = new ArrayList<userInfoBean>();
		try{
			Connection con = DBManager.getUserConnection();
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("SELECT* FROM UserInfo");
			//SELECT文からのデータを1行ずつ取得して格納していく
			while(rs.next()){
				userInfoBean tmp = new userInfoBean();
				tmp.setId(rs.getString("Id"));
				tmp.setBirth(rs.getString("Birth"));
				tmp.setSex(rs.getInt("Sex"));
				tmp.setHeight(rs.getInt("Height"));
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
	//IDが既に登録済みかの検索
	public boolean containId(String Id){
		try {
			Connection con = DBManager.getUserConnection();
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("SELECT id FROM UserInfo");
				while(rs.next()){
					if(Id.equals(rs.getString("Id"))){
						rs.close();
						smt.close();
						con.close();
						return true;
					}
				}
				rs.close();
				smt.close();
				con.close();
				return false;
		} catch (Exception e) {
			return false;
		}
	}
}
