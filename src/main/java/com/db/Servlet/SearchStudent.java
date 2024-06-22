package com.db.Servlet;
import com.db.Entity.Student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.PrintWriter;

public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter p=response.getWriter();
		//read the request 
		
		int id=Integer.parseInt(request.getParameter("t2"));
		p.println(id);
		//process the request
		
		Configuration config=new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		
		//Student s1=session.get(Student.class,id);
		
		Student student=session.get(Student.class,id);
		
		//provide the response
		
		p.println("Name:" +student.getName());
		p.println("Batch:" +student.getBatch());
		p.println("Marks:" +student.getMarks());
		p.println("JoiningDate:" +student.getJoiningDate());
		p.println(student);
		
		session.close();
		
	}

}
