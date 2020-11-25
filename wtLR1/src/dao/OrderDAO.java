package dao;

import bean.Order;
import dao.exception.DAOException;
import java.util.ArrayList;

public interface OrderDAO {
	void addOrder(Order order) throws DAOException;
	void deleteOrder(long idOrder) throws DAOException;
	void delete(Order order) throws DAOException;
	ArrayList<Order> viewAll() throws DAOException;
}