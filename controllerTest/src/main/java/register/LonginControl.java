package register;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LonginControl
 */
@WebServlet("/LonginControl")
public class LonginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//String action = request.getParameter("action");
		String view = "";
		UserDAO r = new UserDAO();
		userDO user = new userDO();
		
		user.setName(request.getParameter("name"));
		user.setPw(request.getParameter("pw"));
		user.setEmail(request.getParameter("grade"));
		user.setGrade(request.getParameter("tell"));
		user.setTel(request.getParameter("email"));
		
		r.register(user); view = "환영합니다.";
		
		/*switch(action) {
			case "login": view = r.login(request.getParameter("name"), request.getParameter("pw")); break;
			case "register": r.register(user); view = "환영합니다."; break;
		}*/
		
		getServletContext().getRequestDispatcher(view)
		.forward(request, response);
	
	}

}
