package service;

import bean.Order;
import service.exception.ServiceException;

public interface RestaurantService {
	void addNewOrder(Order order) throws ServiceException;
	void addEditedOrder(Order order) throws ServiceException;
}
