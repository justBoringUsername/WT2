package dao;

import dao.exception.DAOException;
import bean.User;

public interface UserDAO {
	int signIn(String login, String password) throws DAOException;
	void registration(User user) throws DAOException;
}
