package dao.impl;

import bean.User;
import dao.UserDAO;
import dao.exception.DAOException;
import java.sql.*;
import java.util.ArrayList;

public class SQLUserDAO implements UserDAO {
	private static String url = "jdbc:mysql://localhost/restaurant_system?allowPublicKeyRetrieval=true&useSSL=false";
	private static String username = "root";
	private static String passwordSQL = "root1234";
	
	@Override
	public int signIn(String login, String password) throws DAOException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, passwordSQL)){
            	String SQLQuery = "SELECT * FROM Users WHERE login=?";           	
                try(PreparedStatement preparedStatement = conn.prepareStatement(SQLQuery)){               	
                    preparedStatement.setString(1, login);
                    ResultSet resultSet = preparedStatement.executeQuery();                  
                    if(resultSet.next()){
                        String newPassword = resultSet.getString(3);                   
                        if (newPassword == password) {
                        	return 0;
                        }
                    }
                }           
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 1;
	}
	
	@Override
	public void registration(User user) throws DAOException {
		try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, passwordSQL)){
                  
                String sql = "INSERT INTO Users (login, password) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, user.getLogin());
                    preparedStatement.setString(2, user.getPassword());
                      
                    //preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
	}
}
