package register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterProcess
 */
@WebServlet("/RegisterProcess")
public class RegisterProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RegisterProcess() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		userDO m = new userDO();
		
		m.setName(request.getParameter("name"));
		m.setPw(request.getParameter("pw"));
		m.setGrade(request.getParameter("grade"));
		m.setTel(request.getParameter("tel"));
		m.setEmail(request.getParameter("email"));
			
		m.putInform();
		
		request.setAttribute("name", m.getName());
		getServletContext().getRequestDispatcher("/register/result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
