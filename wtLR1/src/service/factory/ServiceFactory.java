package service.factory;

import service.ClientService;
import service.RestaurantService;
import service.impl.ClientServiceImpl;
import service.impl.RestaurantServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final ClientService clientService = new ClientServiceImpl();
	private final RestaurantService restaurantService = new RestaurantServiceImpl();
	
	private ServiceFactory(){}
	
	public static ServiceFactory getInstance(){
		return instance;
	}
	
	public ClientService getCLientService(){
		return clientService;
	}
	
	public RestaurantService getRestaurantService(){
		return restaurantService;
	}
}
