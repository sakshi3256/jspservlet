package firstjsp.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstjsp.dao.StudentDao;
import firstjsp.dto.Student;

public class Signup extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id1=req.getParameter("id");
		int id =Integer.parseInt(id1);
		String name = req.getParameter("name");
		String email=req.getParameter("email");
		String pwd =req.getParameter("pwd");
		String address=req.getParameter("address");
		//long phone =Long.parseLong(req.getParameter("phone"));
		String phone = req.getParameter("phone");
		ServletContext context =getServletContext();
	String fees2=	context.getInitParameter("fees");
		double fees1 =Double.parseDouble(fees2);
		
		StudentDao d = new StudentDao();
		
			
	
		
		
		List<Student> students =d.getAllStudent();
	
		
		boolean value =false;
		for(Student student:students)
		{
			if(student.getEmail().equals(email))
			{
				value=true;
				break;
			}
		}
		
		
		if(value==false)
		{
// email is not present so I can insert a student object
			Student s=new Student();
			s.setStdid(id);
			s.setName(name);
			s.setEmail(email);
			s.setAddress(address);
			s.setPhone(phone);
			s.setPassword(pwd);
			s.setFees(fees1);
			
			
		Student s1=d.saveStudent(s);
		
		
		req.setAttribute("message", "SIGNEDINSUCESSFULLY");
		RequestDispatcher disp =req.getRequestDispatcher("login.jsp");
		disp.forward(req, resp);
		}
		else
		{
			req.setAttribute("message", "Sorry email already exist");
			RequestDispatcher disp =req.getRequestDispatcher("signup.jsp");
			disp.include(req, resp);
		}
		
		
		
	

	
		
		
	}

}
