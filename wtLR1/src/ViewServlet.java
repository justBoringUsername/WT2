

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Order;
import dao.exception.DAOException;
import dao.impl.*;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		SQLOrderDAO sqlorderdao = new SQLOrderDAO();
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			orders = sqlorderdao.viewAll();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
	    session.setAttribute("content", orders);			 
	     
	    getServletContext().getRequestDispatcher("/view.jsp").forward(request, response);
	}

}
