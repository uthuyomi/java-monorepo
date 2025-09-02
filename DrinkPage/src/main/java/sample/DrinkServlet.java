package sample;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DrinkServlet
 */
@WebServlet("/drink")
public class DrinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrinkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userdrink = request.getParameter("userdrink");
		
		if( userdrink != null && !userdrink.isBlank() ) {
			HttpSession old = request.getSession(false);
			if( old != null ) {
				old.invalidate();
			}
			HttpSession session = request.getSession();
			session.setAttribute("drink", userdrink);
			
			request.getRequestDispatcher("/drink.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.removeAttribute("drink");
			response.sendRedirect(request.getContextPath()+"/drink.jsp");
		}
		
		
	}

}
