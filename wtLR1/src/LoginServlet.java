import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.impl.SQLUserDAO;
import dao.exception.DAOException;
//import dao.factory.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		SQLUserDAO sqluserdao = new SQLUserDAO();
		try {
			if ((sqluserdao.signIn(login, password)) == 1) {
				HttpSession session = request.getSession();
			    session.setAttribute("login", login);
			    session.setAttribute("password", password);				 
			     
			    getServletContext().getRequestDispatcher("/crud.jsp").forward(request, response);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

}
