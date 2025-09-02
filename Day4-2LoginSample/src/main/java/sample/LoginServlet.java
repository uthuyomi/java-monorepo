package sample;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if("admin".equals(username) && "1234".equals(password)) {
			HttpSession old = request.getSession(false);
			if( old != null ){
				old.invalidate();
			}
			HttpSession s = request.getSession(true);
			s.setAttribute("loginUser", username);
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else {
			HttpSession session = request.getSession(false);
			if( session != null ){
				session.removeAttribute("loginUser");
				response.sendRedirect(request.getContextPath()+"/login.jsp?error=1");
			}
		}
	}

}
