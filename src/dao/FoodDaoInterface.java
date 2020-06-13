package dao;

import java.sql.SQLException;
import java.util.List;

import model.food;

public interface FoodDaoInterface {
	
	int insertFood(food food) throws SQLException, Exception;
	food orderFood(int Fid) throws Exception;
	List<food> selectAllfood() throws Exception;
	void deleteFood(int Fid) throws SQLException, Exception;
	 int updateFood(food food) throws SQLException, Exception;
	

}
