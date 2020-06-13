package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.food;
import utility.ConnectionManager;

public class FoodDaoImpl  implements FoodDaoInterface{

	@Override
	public int insertFood(food food) throws SQLException, Exception {

		ConnectionManager con = new ConnectionManager();
		System.out.println(food.getFid()+" "+food.getFname()+" "+food.getFprice()+" "+food.getFimage());

		String sql ="insert into fooditems values(?,?,?,?)";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setInt(1, food.getFid());
		st.setString(2, food.getFname());
		st.setInt(3,food.getFprice());
		st.setString(4, food.getFimage());
		int result=st.executeUpdate();
		st.close();
		System.out.println("printing result  "+result);
		return result;

	}

	@Override
	public food orderFood(int Fid) throws Exception {

		food food=new food();
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.getConnection();
		Statement stmt=null;
		stmt=con.createStatement();
		String sql="select * FROM FOODITEMS WHERE Fid="+Fid;
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){

			food.setFid(rs.getInt("FID"));

			food.setFname(rs.getString("FNAME"));

			food.setFprice(rs.getInt("FPRICE"));

			food.setFimage(rs.getString("FIMAGE"));

		}
		rs.close();
		stmt.close();
		con.close();
	    return food;



		
	}

	@Override
	public List<food> selectAllfood() throws Exception {


		List<food> list = new ArrayList<food>();
		food food=null;
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.getConnection();

		Statement stmt=con.createStatement();
		String sql="SELECT * FROM fooditems";

		ResultSet rs=stmt.executeQuery(sql);

		while(rs.next()) {
			food = new food();

			food.setFid(rs.getInt("FID"));

			food.setFname(rs.getString("FNAME"));

			food.setFprice(rs.getInt("FPRICE"));

			food.setFimage(rs.getString("FIMAGE"));

			list.add(food);
		}

		rs.close();
		stmt.close();
		con.close();
		return list;

	}

	@Override
	public void deleteFood(int Fid) throws SQLException, Exception {

		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.getConnection();
		String sql = "delete from Fooditems where Fid="+Fid;
		Statement st=con.createStatement();
		if(st.execute(sql)) {
			st.close(); 
			
		}
		else {
			st.close();
			
		}
		
		
		
		
	}

	@Override
	public int updateFood(food food) throws SQLException, Exception {
		
		
		String sqlQuery = "UPDATE Fooditems SET Fname = ?, Fprice= ? WHERE Fid = ?";
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.getConnection();
		PreparedStatement stmt = con.prepareStatement(sqlQuery);
		stmt.setString(1, food.getFname());
	    stmt.setInt(2, food.getFprice());
	    
	    stmt.setInt(3,food.getFid());
	    stmt.executeUpdate();
	    
	    stmt.close();
	    con.close();
		return 1;
	    
		
	}

}
