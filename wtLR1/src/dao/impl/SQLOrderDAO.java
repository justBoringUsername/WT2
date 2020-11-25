package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Order;
import dao.OrderDAO;
import dao.exception.DAOException;

public class SQLOrderDAO implements OrderDAO{
	private static String url = "jdbc:mysql://localhost/restaurant_system?allowPublicKeyRetrieval=true&useSSL=false";
	private static String username = "root";
	private static String passwordSQL = "root1234";
	
	@Override
	public void addOrder(Order order) throws DAOException {
		
	}
	@Override
	public void deleteOrder(long idOrder) throws DAOException{
		
	}
	@Override
	public void delete(Order order) throws DAOException {
		
	}
	
	@Override
	public ArrayList<Order> viewAll() throws DAOException {
		ArrayList<Order> orders = new ArrayList<Order>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, passwordSQL)){               
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders");
                while(resultSet.next()){                     
                    String name = resultSet.getString(2);
                    int price = resultSet.getInt(3);
                    Order order = new Order(name, price);
                    orders.add(order);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return orders;
	}
}
