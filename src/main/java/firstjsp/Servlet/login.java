
package firstjsp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstjsp.dao.StudentDao;
import firstjsp.dto.Student;

@WebServlet("/login")
public class login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pwd = req.getParameter("pwd");
		StudentDao d =new StudentDao();
	List<Student> students	=d.getAllStudent();
	boolean value=false;
	
	for(Student student:students)
	{
		if(student.getEmail().equals(email))
		{
			value=true;
			break;
			
		}
		
	}
	
	
	
	
	
	
	
	if(value==false)
	{//email is not present
		req.setAttribute("message", "INcorrect Email");
		RequestDispatcher dis =req.getRequestDispatcher("login.jsp");
		dis.include(req, resp);
	}
	else
	{
		//email is present
	//	System.out.println(d.getStudentByEmail(email));
		Student student = d.getStudentByEmail(email);
		
		if(student.getPassword().equals(pwd))
		{
	 req.setAttribute("list", students);
		RequestDispatcher dis =req.getRequestDispatcher("display.jsp");
		dis.include(req, resp);
	 
		}
		else
		{
			req.setAttribute("message", "INcorrect Password");
			RequestDispatcher dis =req.getRequestDispatcher("login.jsp");
			dis.include(req, resp);
		}
		
		
	}
	
	
	
}
}