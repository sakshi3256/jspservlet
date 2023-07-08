package firstjsp.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstjsp.dao.StudentDao;
import firstjsp.dto.Student;
@WebServlet("/delete")
public class delete extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao d = new StudentDao();
		d.deleteStudentById(id);
		
		List<Student> std=d.getAllStudent();
		
		req.setAttribute("list", std);
		
		RequestDispatcher dis =req.getRequestDispatcher("display.jsp");
		dis.forward(req, resp);
		
	}

}
