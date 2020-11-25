package controller;

import java.util.HashMap;
import java.util.Map;

import controller.command.Command;
import controller.command.CommandName;
//import controller.command.impl.AddOrder;
//import controller.command.impl.Register;
//import controller.command.impl.SignIn;
//import controller.command.impl.WrongRequest;

final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider(){
		/*repository.put(CommandName.SIGN_IN, new SingIn());
		repository.put(CommandName.REGISTRATION, new Register());
		repository.put(CommandName.ADD_ORDER, new AddOrder());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());*/
	}
	
	@SuppressWarnings("unlikely-arg-type")
	Command getCommand(String name){ 
		CommandName commandName =null;
		Command command = null;
		
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
			}catch(IllegalArgumentException | NullPointerException e){
				//write log
				command = repository.get(CommandName.WRONG_REQUEST);
			} 
		return command;		
	}	
}
