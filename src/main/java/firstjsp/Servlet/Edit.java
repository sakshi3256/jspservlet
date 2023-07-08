package firstjsp.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import firstjsp.dao.StudentDao;
import firstjsp.dto.Student;

public class Edit extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id= Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email=req.getParameter("email");
		String pwd =req.getParameter("password");
		String address=req.getParameter("address");
		//long phone =Long.parseLong(req.getParameter("phone"));
		String phone = req.getParameter("phone");
		ServletContext context =getServletContext();
	String fees2=	context.getInitParameter("fees");
		double fees1 =Double.parseDouble(fees2);
		
		
		Student s=new Student();
		s.setStdid(id);
		s.setName(name);
		s.setEmail(email);
		s.setAddress(address);
		s.setPhone(phone);
		s.setPassword(pwd);
		s.setFees(fees1);
		
		StudentDao d = new StudentDao();
		
		Student s1 = d.updateStudent(id,s);
		
		List<Student> s2 = d.getAllStudent();
		req.setAttribute("list", s2);
		RequestDispatcher d1 = req.getRequestDispatcher("display.jsp");
		d1.forward(req, resp);
	}
	
	

}
