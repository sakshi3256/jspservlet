package firstjsp.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstjsp.dao.StudentDao;
import firstjsp.dto.Student;

@WebServlet("/update")
public class Update extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id =Integer.parseInt(req.getParameter("id"));
		
		
		StudentDao d = new StudentDao();
	Student s=	d.getStudentById(id);
		
		req.setAttribute("student", s);
       RequestDispatcher d1 = req.getRequestDispatcher("edit.jsp");
                    d1.forward(req, resp);
	
	}
	
	

}
