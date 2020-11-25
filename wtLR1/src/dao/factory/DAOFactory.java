package dao.factory;

import dao.OrderDAO;
import dao.UserDAO;
import dao.impl.SQLOrderDAO;
import dao.impl.SQLUserDAO;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	
	private final OrderDAO sqlOrderImpl = new SQLOrderDAO();
	private final UserDAO sqlUserImpl = new SQLUserDAO();
	
	private DAOFactory(){}
	
	public static DAOFactory getInstance(){
		return instance;
	}
	
	public OrderDAO getOrderDAO(){
		return sqlOrderImpl;
	}
	
	public UserDAO getUserDAO(){ 
		return sqlUserImpl;
	}
}

//DAOFactory daoObjectFactory = DAOFactory.getInstance();
//BookDAO bookDAO = daoObjectFactory.getBookDAO();
//bookDAO.addBook(book);
